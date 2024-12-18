package frontend.notifications;

import backend.FriendManager;
import backend.Notifications.Notification;
import backend.Notifications.NotificationsDB;
import backend.User;
import backend.UserDB;
import backend.content.Post;
import backend.content.PostFacade;
import backend.content.Story;
import backend.content.StoryFacade;
import backend.groups.Group;
import backend.groups.GroupDB;
import backend.groups.GroupRole;
import frontend.GroupDetails;
import frontend.content.PostsPanel;
import frontend.content.StoriesPanel;
import utils.Constants;
import utils.ImageAvatar;
import utils.NotificationType;

import javax.swing.*;

/**
 *
 * @author RAVEN
 */
public class Item extends javax.swing.JPanel implements Constants {

    private String type;
    private String senderUserID;
    private String senderUserName;
    private String loggedInUserID;
    private String loggedInUserName;
    private String notificationID;
    private String postID;
    private UserDB userDB;
    private Notification notification;

    public Item(Notification notification, String time){
        initComponents();
        //pic.setIcon(icon);
        this.notification = notification;

        userDB = UserDB.getInstance();
        this.senderUserID = notification.getSenderUserID();
        this.loggedInUserID = notification.getUserID();
        this.type = notification.getType();
        this.senderUserName = userDB.searchUserByUserId(senderUserID).getUserName();
        this.loggedInUserName = userDB.searchUserByUserId(loggedInUserID).getUserName();
        this.notificationID = notification.getNotificationID();
        this.postID = notification.getPostID();

        lbName.setText(senderUserName.length() > 14 ? senderUserName.substring(0, 11) + "..." : senderUserName);
        lbDes.setText(notification.getMessage());
        lbTime.setText(time);

        if(userDB.searchUserByUserId(senderUserID).getProfile().getProfilePhoto() == null)
            pic.setIcon(new ImageIcon(Constants.DEFAULT_PFP));
        else
            pic.setIcon(new ImageIcon(userDB.searchUserByUserId(senderUserID).getProfile().getProfilePhoto()));

        // Set button text and color based on notification type
        if(type.equals(NotificationType.GROUP_ACTIVITY.getType())) {
            jButton1.setText("");
            jButton1.setVisible(false);
            jButton2.setBackground(new java.awt.Color(0, 153, 255));
            jButton2.setText("Open Group");
        }
        else if(type.equals(NotificationType.POST.getType()) || type.equals(NotificationType.COMMENT.getType()) || type.equals(NotificationType.LIKE.getType())) {
            jButton1.setText("");
            jButton1.setVisible(false);
            jButton2.setBackground(new java.awt.Color(0, 153, 255));
            jButton2.setText("Open Post");
        }
        else if(type.equals(NotificationType.STORY.getType())) {
            jButton1.setText("");
            jButton1.setVisible(false);
            jButton2.setBackground(new java.awt.Color(0, 153, 255));
            jButton2.setText("Open Story");
        }
        else if(type.equals(NotificationType.FRIEND_REQUEST.getType())) {
            jButton1.setVisible(true);
            jButton1.setBackground(new java.awt.Color(0, 153, 255));
            jButton2.setBackground(new java.awt.Color(102, 102, 102));
            jButton1.setText("Accept");
            jButton2.setText("Decline");
        } else if (type.equals(NotificationType.BLANK.getType())) {
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }

    }

    public Item(Icon icon, String name, String des, String time) {
        initComponents();
        pic.setIcon(icon);
        lbName.setText(name);
        lbDes.setText(des);
        lbTime.setText(time);
    }

    public Item(String name, String des, String time) {
        initComponents();
        lbName.setText(name);
        lbDes.setText(des);
        lbTime.setText(time);
    }

    public Item(){
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new ImageAvatar();
        lbName = new javax.swing.JLabel();
        lbDes = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(334, 66));
        setMaximumSize(new java.awt.Dimension(334, 66));
        setSize(new java.awt.Dimension(334, 66));
        setPreferredSize(new java.awt.Dimension(334, 66));

        setOpaque(false);

        pic.setIcon(new javax.swing.ImageIcon(Constants.DEFAULT_PFP)); // NOI18N

        lbName.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        lbName.setForeground(new java.awt.Color(106, 106, 106));
        lbName.setText("Name");

        lbDes.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        lbDes.setForeground(new java.awt.Color(134, 134, 134));
        lbDes.setText("Description");

        lbTime.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        lbTime.setForeground(new java.awt.Color(134, 134, 134));
        lbTime.setText("a day ago");

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("jButton1");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1ButtonMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("jButton2");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2ButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDes))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName)
                            .addComponent(lbDes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTime)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 9, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // Accept friend request
        if(this.type.equals(NotificationType.FRIEND_REQUEST.getType())) {
            FriendManager.getInstance(UserDB.getInstance().searchUserByUserId(this.loggedInUserID)).acceptFriendRequest(UserDB.getInstance().searchUserByUserId(this.senderUserID));
            notification.setStatus("responded");
            NotificationsDB.getInstance(this.loggedInUserID).updateNotification(notification);
            //System.out.println("Update notification status: " + notification.getNotificationID() + " new status: " + notification.getStatus());
        }
    }

    private void jButton2ButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if(this.type.equals(NotificationType.FRIEND_REQUEST.getType())) {
            // Decline friend request
            FriendManager.getInstance(UserDB.getInstance().searchUserByUserId(this.loggedInUserID)).declineFriendRequest(UserDB.getInstance().searchUserByUserId(this.senderUserID));
            notification.setStatus("responded");
            NotificationsDB.getInstance(this.loggedInUserID).updateNotification(notification);
        } else if (this.type.equals(NotificationType.GROUP_ACTIVITY.getType())) {
            // Open group
            User user = UserDB.getInstance().searchUserByUserName(loggedInUserName);
            Group group = GroupDB.getInstance().searchGroupByID(postID);
            GroupRole role = group.getUserRole(user.getUserId());
            new GroupDetails(user, group, role).setVisible(true);
        } else if (this.type.equals(NotificationType.POST.getType()) || this.type.equals(NotificationType.COMMENT.getType()) || this.type.equals(NotificationType.LIKE.getType())) {
            // Open post
            JFrame frame = new JFrame();
            frame.setSize(600,300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            User user = UserDB.getInstance().searchUserByUserName(loggedInUserName);
            PostFacade postFacade = new PostFacade(user);
            PostsPanel postPanel = new PostsPanel(user, postFacade, frame.getHeight(), frame.getWidth(), "All");
            Post postNotify = (Post) postFacade.searchContentByID(postID);
            frame.add(postPanel.createContentPanel(postNotify));
            frame.setVisible(true);
        } else if (this.type.equals(NotificationType.STORY.getType())) {
            // Open story
            JFrame frame = new JFrame();
            frame.setSize(600,300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            User user = UserDB.getInstance().searchUserByUserName(loggedInUserName);
            StoryFacade storyFacade = new StoryFacade(user);
            StoriesPanel storiesPanel = new StoriesPanel(user, storyFacade, frame.getHeight(), frame.getWidth(), "All");
            Story storyNotify = (Story) storyFacade.searchContentByID(postID);
            frame.add(storiesPanel.createContentPanel(storyNotify));
            frame.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lbDes;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbTime;
    private ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
