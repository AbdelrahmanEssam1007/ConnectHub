package frontend;

import backend.Profile;
import backend.User;
import utils.Constants;
import utils.ImageUtils;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ProfilePanel extends JPanel implements Constants {
    private JTextArea bioTextArea;
    private JPanel pfpPanel;
    private JPanel coverPanel;
    private JPanel mainPanel;
    private JButton editButton;
    private JButton cancelButton;

    private String pfpImagePath;
    private String coverImagePath;

    private ImageIcon pfpImage;
    private ImageIcon coverImage;

    private JLabel pfpLabel;
    private JLabel coverLabel;

    public ProfilePanel(User user, int width, int height) {
        Profile profile = user.getProfile();
        pfpImagePath = profile.getProfilePhoto();
        coverImagePath = profile.getCoverPhoto();

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

        coverImage = new ImageIcon(coverImagePath);
        Image scaledCoverImage = coverImage.getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
        coverImage = new ImageIcon(scaledCoverImage);

        pfpPanel.setBackground(Color.WHITE);
        pfpPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        coverPanel.setBackground(Color.WHITE);
        coverPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Set up bio text area
        bioTextArea.setText(profile.getBio());
        bioTextArea.setEditable(false);
        bioTextArea.setLineWrap(true);
        bioTextArea.setWrapStyleWord(true);
        bioTextArea.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null || (getLength() + str.length()) <= 250) { // Limit bio to 250 characters
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
        setVisible(true);

        cancelButton.setVisible(false);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isEditable = bioTextArea.isEditable();
                bioTextArea.setEditable(!isEditable);
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
                            Image scaledCoverImage = ImageUtils.scaleImageIcon(coverImagePath, 250).getImage();
                            coverImage = new ImageIcon(scaledCoverImage);
                            coverLabel.setIcon(coverImage);
                        }
                    });

                    cancelButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            bioTextArea.setText(profile.getBio());
                            bioTextArea.setEditable(false);
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