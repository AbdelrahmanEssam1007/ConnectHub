package frontend;

import backend.Profile;
import utils.Constants;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;

public class ProfilePanel extends JPanel implements Constants {
    private JTextArea bioTextArea;
    private JPanel pfpPanel;
    private JPanel coverPanel;
    private JPanel mainPanel;
    private JButton editButton;

    private String pfpImagePath;
    private String coverImagePath;

    private ImageIcon pfpImage;
    private ImageIcon coverImage;

    private JLabel pfpLabel;
    private JLabel coverLabel;

    private JFileChooser fileChooser = new JFileChooser();

    public ProfilePanel(Profile profile) {
        pfpImagePath = profile.getProfilePhoto();
        coverImagePath = profile.getCoverPhoto();

        if(pfpImagePath == null) {
            pfpImagePath = Constants.DEFAULT_PFP;
        }
        if(coverImagePath == null) {
            coverImagePath = Constants.DEFAULT_COVER_PHOTO;
        }

        // Load and scale images
        pfpImage = new ImageIcon(pfpImagePath);
        Image scaledPfpImage = pfpImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        pfpImage = new ImageIcon(scaledPfpImage);

        coverImage = new ImageIcon(coverImagePath);
        Image scaledCoverImage = coverImage.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        coverImage = new ImageIcon(scaledCoverImage);

        pfpPanel.setBackground(Color.WHITE);
        pfpPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        coverPanel.setBackground(Color.WHITE);
        coverPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        bioTextArea.setText(profile.getBio());
        bioTextArea.setEditable(false);
        bioTextArea.setLineWrap(true);
        bioTextArea.setWrapStyleWord(true);
        bioTextArea.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null || (getLength() + str.length()) <= 250) {
                    super.insertString(offs, str, a);
                }
            }
        });

        pfpLabel = new JLabel(pfpImage);
        coverLabel = new JLabel(coverImage);

        pfpPanel.setLayout(new BorderLayout());
        pfpPanel.add(pfpLabel, BorderLayout.CENTER);
        coverPanel.setLayout(new BorderLayout());
        coverPanel.add(coverLabel, BorderLayout.CENTER);

        add(mainPanel);
        setSize(500, 200);
        setVisible(true);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isEditable = bioTextArea.isEditable();
                bioTextArea.setEditable(!isEditable);
                editButton.setText(isEditable ? "Edit" : "Save");

                if (!isEditable) {
                    pfpLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            fileChooser.setDialogTitle("Select a new Profile Picture");
                            fileChooser.setAcceptAllFileFilterUsed(false);
                            fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
                            int result = fileChooser.showOpenDialog(ProfilePanel.this);
                            if (result == JFileChooser.APPROVE_OPTION) {
                                // use image saver
                                pfpImagePath = fileChooser.getSelectedFile().getAbsolutePath();
                                pfpImage = new ImageIcon(pfpImagePath);
                                Image scaledPfpImage = pfpImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                                pfpImage = new ImageIcon(scaledPfpImage);
                                pfpLabel.setIcon(pfpImage);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Error uploading image..", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });

                    coverLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            fileChooser.setDialogTitle("Select a new Cover Photo");
                            fileChooser.setAcceptAllFileFilterUsed(false);
                            fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
                            int result = fileChooser.showOpenDialog(ProfilePanel.this);
                            if (result == JFileChooser.APPROVE_OPTION) {
                                // use image saver
                                coverImagePath = fileChooser.getSelectedFile().getAbsolutePath();
                                coverImage = new ImageIcon(coverImagePath);
                                Image scaledCoverImage = coverImage.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
                                coverImage = new ImageIcon(scaledCoverImage);
                                coverLabel.setIcon(coverImage);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Error uploading image..", "Error", JOptionPane.ERROR_MESSAGE);
                            }
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