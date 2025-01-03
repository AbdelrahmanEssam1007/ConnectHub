package frontend.content;

import backend.Notifications.Notification;
import backend.Notifications.NotificationsDB;
import backend.RefreshManager;
import backend.User;
import backend.content.PostFacade;
import backend.content.StoryFacade;
import backend.groups.Group;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import utils.NotificationType;

public class CreatePostPanel extends JDialog{
    private JPanel panel1;
    private JTextArea contentTextInput;
    private JPanel imageContainer;
    private JButton createPostButton;
    private JButton uploadImageButton;
    private JRadioButton postRadioButton;
    private JRadioButton storyRadioButton;
    private JComboBox groupComboBox;
    private ButtonGroup contentGroup;
    private File imageFile;
    private final PostFacade postFacade;
    private final StoryFacade storyFacade;
    private final RefreshManager refreshManager;
    private List<Group> userGroups;
    private User loggedInUser;
    private List<String> userFriendsIDs;


    public CreatePostPanel(PostFacade postFacade, StoryFacade storyFacade, RefreshManager refreshManager, List<Group> userGroups) throws HeadlessException {
        /*Initializing needed variables*/
        this.postFacade = postFacade;
        this.storyFacade = storyFacade;
        this.refreshManager = refreshManager;
        this.userGroups = userGroups;
        this.loggedInUser = postFacade.getUser();
        setModal(true);

        userFriendsIDs = loggedInUser.getProfile().getFriends();

        /*Group combo box management*/
        groupComboBox.addItem("Your Feed.");
        for(Group x : userGroups){
            groupComboBox.addItem(x);
        }

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
                if(imageFile != null){
                    JOptionPane.showMessageDialog(null, "Cannot upload multiple images.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                imageFile = ImageUtils.uploadImage();
                if(imageFile != null){
                    try {
                        String imagePath = ImageUtils.saveImage(imageFile);
                        imageContainer.setLayout(new BorderLayout());
                        imageContainer.removeAll();
                        ImageIcon imageTemp = ImageUtils.scaleImageIcon(imagePath, imageContainer.getWidth());
                        imageContainer.add(new JLabel(imageTemp));
                        imageContainer.revalidate();
                        imageContainer.repaint();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                        dispose();
                    }
                }
                else{
                    return;
                }
            }
        });

        /*Create post button listener*/
        createPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = contentTextInput.getText();
                Group selectedGroup = null;
                if(groupComboBox.getSelectedItem() instanceof Group)
                    selectedGroup = (Group) groupComboBox.getSelectedItem();
                if(imageFile != null && !text.isEmpty()){
                    try {
                        if(postRadioButton.isSelected()){
                            String postID = postFacade.createTextImageContent(text, imageFile, selectedGroup);
                            if(selectedGroup == null){
                                for (String friendId : userFriendsIDs) {
                                    NotificationsDB.getInstance(friendId).addNotification(new Notification("created a new post", friendId, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.POST.getType(), postID));
                                }
                            }
                            else{
                                for (String memberID : selectedGroup.getAllMembers()) {
                                    NotificationsDB.getInstance(memberID).addNotification(new Notification("created a new post in " + selectedGroup.getGroupName(), memberID, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.POST.getType(), postID));
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Successfully made post!",
                                "Post Creation", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if(storyRadioButton.isSelected()){
                            String postID = storyFacade.createTextImageContent(text, imageFile, selectedGroup);
                            if(selectedGroup == null){
                                for (String friendId : userFriendsIDs) {
                                    NotificationsDB.getInstance(friendId).addNotification(new Notification("created a new story", friendId, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.STORY.getType(), postID));
                                }
                            }
                            else{
                                for (String memberID : selectedGroup.getAllMembers()) {
                                    NotificationsDB.getInstance(memberID).addNotification(new Notification("created a new story in " + selectedGroup.getGroupName(), memberID, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.STORY.getType(), postID));
                                }
                            }
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
                            String postID = postFacade.createImageOnlyContent(imageFile, selectedGroup);
                            if(selectedGroup == null){
                                for (String friendId : userFriendsIDs) {
                                    NotificationsDB.getInstance(friendId).addNotification(new Notification("created a new post", friendId, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.POST.getType(), postID));
                                }
                            }
                            else{
                                for (String memberID : selectedGroup.getAllMembers()) {
                                    NotificationsDB.getInstance(memberID).addNotification(new Notification("created a new post in " + selectedGroup.getGroupName(), memberID, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.POST.getType(), postID));
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Successfully made post!",
                                "Post Creation", JOptionPane.INFORMATION_MESSAGE);
                        }else if(storyRadioButton.isSelected()){
                            String postID = storyFacade.createImageOnlyContent(imageFile, selectedGroup);
                            if(selectedGroup == null){
                                for (String friendId : userFriendsIDs) {
                                    NotificationsDB.getInstance(friendId).addNotification(new Notification("created a new story", friendId, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.STORY.getType(), postID));
                                }
                            }
                            else{
                                for (String memberID : selectedGroup.getAllMembers()) {
                                    NotificationsDB.getInstance(memberID).addNotification(new Notification("created a new story in " + selectedGroup.getGroupName(), memberID, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.STORY.getType(), postID));
                                }
                            }
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
                    System.out.println("Text only");
                    if(postRadioButton.isSelected()){
                        String postID = postFacade.createTextOnlyContent(text, selectedGroup);
                        if(selectedGroup == null){
                            for (String friendId : userFriendsIDs) {
                                NotificationsDB.getInstance(friendId).addNotification(new Notification("created a new post", friendId, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.POST.getType(), postID));
                            }
                        }
                        else{
                            for (String memberID : selectedGroup.getAllMembers()) {
                                NotificationsDB.getInstance(memberID).addNotification(new Notification("created a new post in " + selectedGroup.getGroupName(), memberID, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.POST.getType(), postID));
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Successfully made post!",
                                "Post Creation", JOptionPane.INFORMATION_MESSAGE);
                    }else if(storyRadioButton.isSelected()){
                        String postID = storyFacade.createTextOnlyContent(text, selectedGroup);
                        if(selectedGroup == null){
                            for (String friendId : userFriendsIDs) {
                                NotificationsDB.getInstance(friendId).addNotification(new Notification("created a new story", friendId, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.STORY.getType(), postID));
                            }
                        }
                        else{
                            for (String memberID : selectedGroup.getAllMembers()) {
                                NotificationsDB.getInstance(memberID).addNotification(new Notification("created a new story in " + selectedGroup.getGroupName(), memberID, loggedInUser.getUserId(), "new", LocalDateTime.now(), NotificationType.STORY.getType(), postID));
                            }
                        }
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
