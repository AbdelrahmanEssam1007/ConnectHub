package frontend.content;

import backend.content.PostManager;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CreatePostPanel extends JFrame{
    private JPanel panel1;
    private JTextArea contentTextInput;
    private JPanel imageContainer;
    private JButton createPostButton;
    private JButton uploadImageButton;
    private final PostManager postManager;
    private File imageFile;

    public CreatePostPanel(PostManager postManager) throws HeadlessException {
        /*Initializing needed variables*/
        this.postManager = postManager;

        /*Setting up main creation panel*/
        setTitle("Create Post");
        setResizable(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);

        /*Upload image button listener*/
        uploadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageFile = ImageUtils.uploadImage();
                if(imageFile != null){
                    try {
                        String imagePath = ImageUtils.saveImage(imageFile);
                        imageContainer.setLayout(new BorderLayout());
                        imageContainer.removeAll();
                        imageContainer.add(new JLabel(new ImageIcon(imagePath)));
                        imageContainer.revalidate();
                        imageContainer.repaint();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                        dispose();
                    }
                }
            }
        });

        /*Create post button listener*/
        createPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = contentTextInput.getText();
                if(imageFile != null && !text.isEmpty()){
                    try {
                        postManager.createTextImageContent(text, imageFile);
                        JOptionPane.showMessageDialog(null, "Successfully made post!",
                                "Post Creation", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    dispose();
                }
                else if(imageFile != null){
                    try {
                        postManager.createImageOnlyContent(imageFile);
                        JOptionPane.showMessageDialog(null, "Successfully made post!",
                                "Post Creation", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    dispose();
                }
                else if(!text.isEmpty()){
                    postManager.createTextOnlyContent(text);
                    JOptionPane.showMessageDialog(null, "Successfully made post!",
                            "Post Creation", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Cannot create empty post!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
