package frontend;

import backend.Profile;
import backend.User;
import backend.UserDB;
import utils.Constants;
import utils.ImageUtils;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class ProfilePanel extends JPanel implements Constants {
    private JTextArea bioTextArea;
    private JPanel pfpPanel;
    private JPanel coverPanel;
    private JPanel mainPanel;
    private JButton editButton;
    private JButton cancelButton;
    private JScrollPane bioScroll;
    private User profileUser;

    private String pfpImagePath;
    private String coverImagePath;

    private ImageIcon pfpImage;
    private ImageIcon coverImage;

    private JLabel pfpLabel;
    private JLabel coverLabel;
    private UserDB userDB = UserDB.getInstance();

    public ProfilePanel(User profileUser, User lookingUser, int width, int height) {
        this.profileUser = profileUser;
        pfpImagePath = profileUser.getProfile().getProfilePhoto();
        coverImagePath = profileUser.getProfile().getCoverPhoto();

        if(pfpImagePath == null) {
            pfpImagePath = Constants.DEFAULT_PFP; // Default profile picture
        }
        if(coverImagePath == null) {
            coverImagePath = Constants.DEFAULT_COVER_PHOTO; // Default cover photo
        }

        // Load and scale images
        pfpImage = new ImageIcon(pfpImagePath);
        Image scaledPfpImage = pfpImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        pfpImage = new ImageIcon(scaledPfpImage);

        Image scaledCoverImage = ImageUtils.scaleImageIcon(coverImagePath, 400).getImage();
        coverImage = new ImageIcon(scaledCoverImage);

        pfpPanel.setBackground(Color.WHITE);
        pfpPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        coverPanel.setBackground(Color.WHITE);
        coverPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Set up bio text area
        bioTextArea.setEditable(false);
        bioTextArea.setLineWrap(true);
        bioTextArea.setWrapStyleWord(true);
        bioTextArea.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) {
                    return;
                }
                String currentText = getText(0, getLength());
                int currentLines = currentText.split("\n").length;
                int newLines = str.split("\n").length;
                if ((currentLines + newLines) <= 3 && (getLength() + str.length()) <= 250) { // Limit bio to 250 characters and 3 lines
                    super.insertString(offs, str, a);
                }
            }
        });

        pfpLabel = new JLabel(pfpImage);
        coverLabel = new JLabel(coverImage);

        // Add image labels to panels
        pfpPanel.setLayout(new BorderLayout());
        pfpPanel.add(pfpLabel, BorderLayout.CENTER);
        coverPanel.setLayout(new BorderLayout());
        coverPanel.add(coverLabel, BorderLayout.CENTER);

        add(mainPanel);
        setSize(width, height);
        bioTextArea.setText(profileUser.getProfile().getBio());
        bioTextArea.setRows(3);
        bioScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        setVisible(true);
        //bioTextArea.setEnabled(false);

        cancelButton.setVisible(false);

        if(!profileUser.getUserId().equals(lookingUser.getUserId()))
            editButton.setVisible(false);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(editButton.getText().equals("Save")) {
                    profileUser.getProfile().setBio(bioTextArea.getText());
                    userDB.setUser(profileUser);
                }
                boolean isEditable = bioTextArea.isEditable();
                bioTextArea.setEditable(!isEditable);
                //bioTextArea.setEnabled(!isEditable);
                //bioTextArea.setFocusable(isEditable);
                editButton.setText(isEditable ? "Edit" : "Save"); // Toggle button text
                cancelButton.setVisible(!isEditable);

                if (!isEditable) {
                    pfpLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // Open file chooser for user to upload new profile picture
                            File newFile = ImageUtils.uploadImage();
                            if (newFile == null) { // User cancelled
                                return;
                            }
                            pfpImagePath = newFile.getAbsolutePath();
                            Image scaledPfpImage = ImageUtils.scaleImageIcon(pfpImagePath, 100).getImage();
                            pfpImage = new ImageIcon(scaledPfpImage);
                            pfpLabel.setIcon(pfpImage);
                            // TODO: save image only if user saves changes
                            String newPfpPath;
                            try {
                                newPfpPath = ImageUtils.saveImage(newFile);
                                profileUser.getProfile().setProfilePhoto(newPfpPath);
                                userDB.setUser(profileUser);
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Error saving image.", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    });

                    coverLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // Open file chooser for user to upload new cover photo
                            File newFile = ImageUtils.uploadImage();
                            if (newFile == null) { // User cancelled
                                return;
                            }
                            coverImagePath = newFile.getAbsolutePath();
                            Image scaledCoverImage = ImageUtils.scaleImageIcon(coverImagePath, 400).getImage();
                            coverImage = new ImageIcon(scaledCoverImage);
                            coverLabel.setIcon(coverImage);
                            String newCoverPath;
                            try {
                                newCoverPath = ImageUtils.saveImage(newFile);
                                profileUser.getProfile().setCoverPhoto(newCoverPath);
                                userDB.setUser(profileUser);
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Error saving image.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });

                    cancelButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            bioTextArea.setText(profileUser.getProfile().getBio());
                            bioTextArea.setEditable(false);
                            //bioTextArea.setEnabled(false);
                            editButton.setText("Edit");
                            cancelButton.setVisible(false);
                            pfpLabel.removeMouseListener(pfpLabel.getMouseListeners()[0]);
                            coverLabel.removeMouseListener(coverLabel.getMouseListeners()[0]);
                        }
                    });
                } else {
                    pfpLabel.removeMouseListener(pfpLabel.getMouseListeners()[0]);
                    coverLabel.removeMouseListener(coverLabel.getMouseListeners()[0]);
                }
            }
        });
    }
}
