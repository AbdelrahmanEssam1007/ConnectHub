package frontend;

import utils.Constants;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class CreateGroupsPanel extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField groupNameTF;
    private JTextField groupDescTF;
    private JPanel groupPhotoPanel;

    private String coverImagePath;
    private ImageIcon coverImage;
    private JLabel coverLabel;

    public CreateGroupsPanel() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        setSize(new Dimension(600, 500));
        setLocationRelativeTo(null);
        setTitle("Create Group");

        buttonOK.setBackground(new java.awt.Color(0, 153, 255));
        buttonOK.setForeground(new java.awt.Color(255, 255, 255));

        buttonCancel.setBackground(new java.awt.Color(152, 152, 152));

        coverImagePath = Constants.DEFAULT_COVER_PHOTO; // Default cover photo
        Image scaledCoverImage = ImageUtils.scaleImageIcon(coverImagePath, 400).getImage();
        coverImage = new ImageIcon(scaledCoverImage);

        coverLabel = new JLabel(coverImage);

        groupPhotoPanel.setLayout(new BorderLayout());
        groupPhotoPanel.add(coverLabel, BorderLayout.CENTER);

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
//                String newCoverPath;
//                try {
//                    newCoverPath = ImageUtils.saveImage(newFile);
//                    profileUser.getProfile().setCoverPhoto(newCoverPath);
//                    userDB.setUser(profileUser);
//                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(null, "Error saving image.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setVisible(true);
    }

    private void onOK() {
        // TODO: add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CreateGroupsPanel dialog = new CreateGroupsPanel();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
