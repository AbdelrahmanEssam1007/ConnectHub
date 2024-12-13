/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.FriendManager;
import backend.User;
import backend.content.PostManager;
import backend.content.StoryManager;
import backend.groups.Group;
import backend.groups.GroupManager;
import backend.groups.GroupRole;
import frontend.content.PostsPanel;
import frontend.content.StoriesPanel;

import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import utils.Constants;

/**
 *
 * @author Zaki
 */
public class FriendsPanel extends javax.swing.JPanel {

    /**
     * Creates new form FriendsPanel
     */
    
    private User friendUser;
    private User loggedinUser;
    private FriendManager FM;
    private String type;
    private Group group = null;
    private GroupRole role;
    private GroupRole friendRole;
    

    private String pfpImagePath;
    private ImageIcon pfpImage;
    private JLabel pfpLabel;
    
    public FriendsPanel() {
        initComponents();
    }
    
    public FriendsPanel (User loggedinUser, User friendUser, FriendManager FM, String type, int width, int height) {
        this();
        setSize(width,height);
        setVisible(true);
        
        this.jButton3.setVisible(false);
        this.statusLabel.setVisible(false);

        this.loggedinUser = loggedinUser;
        this.friendUser = friendUser;
        this.FM = FM;
        this.type = type;

        pfpImagePath = friendUser.getProfile().getProfilePhoto();
        if(pfpImagePath == null) {
            pfpImagePath = Constants.DEFAULT_PFP; // Default profile picture
        }
        pfpImage = new ImageIcon(pfpImagePath);
        Image scaledPfpImage = pfpImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        pfpImage = new ImageIcon(scaledPfpImage);

        pfpLabel = new JLabel(pfpImage);
        pfpPanel.setLayout(new BorderLayout());
        pfpPanel.add(pfpLabel, BorderLayout.CENTER);
        
        this.usernameLabel.setText(friendUser.getUserName());
        
        if (this.friendUser.getStatus()) {
            this.userStatusPanel.setBackground(Color.GREEN);
        }
        else {
            this.userStatusPanel.setBackground(Color.RED);
        }
        
        if (this.type.equals("Current")) {
            jButton1.setText("Block");
            jButton1.setBackground(new java.awt.Color(152, 152, 152));
            jButton2.setText("Remove");
            jButton2.setBackground(new java.awt.Color(152, 152, 152));
        }
        else if (this.type.equals("Request")) {
            jButton1.setText("Accept");
            jButton1.setBackground(new java.awt.Color(0, 153, 255));
            jButton1.setForeground(new java.awt.Color(255, 255, 255));
            jButton2.setText("Reject");
            jButton2.setBackground(new java.awt.Color(152, 152, 152));
        }
        else if (this.type.equals("Searched")) {
            jButton1.setText("Send Friend Request");
            if (this.loggedinUser.getProfile().getBlocked().contains(this.friendUser.getUserId())) {
                jButton1.setText("Unblock");
            }
            jButton1.setBackground(new java.awt.Color(0, 153, 255));
            jButton1.setForeground(new java.awt.Color(255, 255, 255));
            jButton2.setVisible(false);
        }
    }
    
    public FriendsPanel (User loggedinUser, User friendUser, FriendManager FM, String type, int width, int height, Group group) {
        this(loggedinUser, friendUser, FM, type, width, height);
        
        this.group = group;
        
        this.role = GroupManager.getInstance().getGroupRole(group.getGroupID(), loggedinUser.getUserId());
        this.friendRole = GroupManager.getInstance().getGroupRole(group.getGroupID(), friendUser.getUserId());
        
        this.statusLabel.setVisible(true);
        
        if (this.friendRole == GroupRole.PRIMARY_ADMIN) {
            this.statusLabel.setText("Primary Admin");
        }
        else if (this.friendRole == GroupRole.ADMIN) {
            this.statusLabel.setText("Admin");
        }
        else if (this.friendRole == GroupRole.GROUP_MEMBER) {
            this.statusLabel.setText("Member");
        }
        else if (this.friendRole == GroupRole.PENDING_MEMBER) {
            this.statusLabel.setText("Pending");
        }
        
        if (this.role == GroupRole.PRIMARY_ADMIN) {
            if (this.friendRole == GroupRole.PRIMARY_ADMIN) {
                this.jButton1.setVisible(false);
                this.jButton2.setVisible(false);
            }
            else {
                this.jButton1.setText("Kick");
                if (this.friendRole == GroupRole.ADMIN) {
                    this.jButton2.setText("Demote");
                }
                else if (this.friendRole == GroupRole.GROUP_MEMBER) {
                    this.jButton2.setText("Promote");
                }
                else if (this.friendRole == GroupRole.PENDING_MEMBER) {
                    this.jButton2.setText("Accept");
                    this.jButton3.setVisible(true);
                    this.jButton3.setText("Reject");
                }
            }
        }
        else if (this.role == GroupRole.ADMIN) {
            this.jButton2.setVisible(false);
            if (this.friendRole == GroupRole.PRIMARY_ADMIN || this.friendRole == GroupRole.ADMIN) {
                this.jButton1.setVisible(false);
            }
            else if (this.friendRole == GroupRole.GROUP_MEMBER) {
                this.jButton1.setText("Kick");
            }
            else if (this.friendRole == GroupRole.PENDING_MEMBER) {
                this.jButton1.setText("Accept");
                this.jButton3.setVisible(true);
                this.jButton3.setText("Reject");
            }
        }
        else {
            this.jButton1.setVisible(false);
            this.jButton2.setVisible(false);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pfpPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        userStatusPanel = new javax.swing.JPanel();
        viewProfileButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMinimumSize(new java.awt.Dimension(564, 126));
        setPreferredSize(new java.awt.Dimension(564, 126));

        pfpPanel.setBackground(new java.awt.Color(255, 255, 255));
        pfpPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.black, java.awt.Color.darkGray, java.awt.Color.black));
        pfpPanel.setMinimumSize(new java.awt.Dimension(110, 110));
        pfpPanel.setPreferredSize(new java.awt.Dimension(110, 110));

        javax.swing.GroupLayout pfpPanelLayout = new javax.swing.GroupLayout(pfpPanel);
        pfpPanel.setLayout(pfpPanelLayout);
        pfpPanelLayout.setHorizontalGroup(
            pfpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );
        pfpPanelLayout.setVerticalGroup(
            pfpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout userStatusPanelLayout = new javax.swing.GroupLayout(userStatusPanel);
        userStatusPanel.setLayout(userStatusPanelLayout);
        userStatusPanelLayout.setHorizontalGroup(
            userStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        userStatusPanelLayout.setVerticalGroup(
            userStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        viewProfileButton.setText("View Profile");
        viewProfileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewProfileButtonMouseClicked(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pfpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(userStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(viewProfileButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pfpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2)
                                .addComponent(jButton3))
                            .addComponent(viewProfileButton))))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewProfileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProfileButtonMouseClicked
        JFrame profilePage = new JFrame("ConnectHub - " + this.friendUser.getUserName() + "'s Profile");
        profilePage.setSize(600, 630);
        profilePage.setLayout(new BoxLayout(profilePage.getContentPane(), BoxLayout.Y_AXIS));
        profilePage.add(new ProfilePanel(this.friendUser, this.loggedinUser, profilePage.getWidth(), 200));
        profilePage.add(new PostsPanel(this.loggedinUser, new PostManager(this.friendUser),profilePage.getWidth(), profilePage.getHeight()/3, "Profile"));
        profilePage.add(new StoriesPanel(this.loggedinUser, new StoryManager(this.friendUser),profilePage.getWidth(), profilePage.getHeight()/3, "Profile"));
        profilePage.setVisible(true);
        profilePage.revalidate();
        profilePage.repaint();
    }//GEN-LAST:event_viewProfileButtonMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (this.type.equals("Current")) {
//            jButton1.setText("Block");
//            jButton2.setText("Remove");
            this.FM.blockUser(this.friendUser);
        }
        else if (this.type.equals("Request")) {
//            jButton1.setText("Accept");
//            jButton2.setText("Reject");
            FM.acceptFriendRequest(this.friendUser);
        }
        else if (this.type.equals("Searched")) {
//            jButton1.setText("Send Friend Request");
//            jButton2.setVisible(false);
            try {
                FM.sendFriendRequest(this.friendUser);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Friend request already sent.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (this.type.equals("Current")) {
//            jButton1.setText("Block");
//            jButton2.setText("Remove");
            FM.removeUserFriend(this.friendUser);
        }
        else if (this.type.equals("Request")) {
//            jButton1.setText("Accept");
//            jButton2.setText("Reject");
            FM.declineFriendRequest(this.friendUser);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel pfpPanel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel userStatusPanel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JButton viewProfileButton;
    // End of variables declaration//GEN-END:variables
}
