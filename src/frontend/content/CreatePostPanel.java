package frontend.content;

import backend.RefreshManager;
import backend.content.ContentManagerFactory;
import backend.content.PostManager;
import backend.content.StoryManager;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CreatePostPanel extends JDialog{
    private JPanel panel1;
    private JTextArea contentTextInput;
    private JPanel imageContainer;
    private JButton createPostButton;
    private JButton uploadImageButton;
    private JRadioButton postRadioButton;
    private JRadioButton storyRadioButton;
    private ButtonGroup contentGroup;
    private File imageFile;
    private final PostManager postManager;
    private final StoryManager storyManager;
    private final RefreshManager refreshManager;

    public CreatePostPanel(PostManager postManager, StoryManager storyManager, RefreshManager refreshManager) throws HeadlessException {
        /*Initializing needed variables*/
        this.postManager = postManager;
        this.storyManager = storyManager;
        this.refreshManager = refreshManager;
        setModal(true);

        /*Managing button group*/
        contentGroup = new ButtonGroup();
        contentGroup.add(storyRadioButton);
        contentGroup.add(postRadioButton);

        /*Setting up main creation panel*/
        setTitle("Create Post");
        setResizable(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panel1);

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
                        if(postRadioButton.isSelected()){
                            postManager.createTextImageContent(text, imageFile);
                            JOptionPane.showMessageDialog(null, "Successfully made post!",
                                "Post Creation", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if(storyRadioButton.isSelected()){
                            storyManager.createTextImageContent(text, imageFile);
                            JOptionPane.showMessageDialog(null, "Successfully made story!",
                                    "Story Creation", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Must select radio button.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    refreshManager.refreshAll();
                    dispose();
                }
                else if(imageFile != null){
                    try {
                        if(postRadioButton.isSelected()){
                            postManager.createImageOnlyContent(imageFile);
                            JOptionPane.showMessageDialog(null, "Successfully made post!",
                                "Post Creation", JOptionPane.INFORMATION_MESSAGE);
                        }else if(storyRadioButton.isSelected()){
                            storyManager.createImageOnlyContent(imageFile);
                            JOptionPane.showMessageDialog(null, "Successfully made story!",
                                    "Story Creation", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Must select radio button.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    refreshManager.refreshAll();
                    dispose();
                }
                else if(!text.isEmpty()){
                    if(postRadioButton.isSelected()){
                        postManager.createTextOnlyContent(text);
                        JOptionPane.showMessageDialog(null, "Successfully made post!",
                                "Post Creation", JOptionPane.INFORMATION_MESSAGE);
                    }else if(storyRadioButton.isSelected()){
                        storyManager.createTextOnlyContent(text);
                        JOptionPane.showMessageDialog(null, "Successfully made story!",
                                "Story Creation", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Must select radio button.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    refreshManager.refreshAll();
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
