/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.*;
import backend.Notifications.Notification;
import backend.Notifications.NotificationsDB;
import backend.Notifications.NotificationsService;
import backend.content.PostManager;
import backend.content.StoryManager;
import frontend.content.CreatePostPanel;
import frontend.content.PostsPanel;
import frontend.content.StoriesPanel;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.swing.*;

import java.awt.Component;
import java.awt.Point;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import raven.glasspanepopup.DefaultLayoutCallBack;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;

/**
 *
 * @author Zaki
 */
public class UserPage extends javax.swing.JFrame {

    private User loggedInUser;
    private FriendManager FM;
    private PostManager postManager;
    private StoryManager storyManager;
    private RefreshManager refreshManager;
    private PostsPanel postsPanel;
    private StoriesPanel storiesPanel;
    private ProfilePanel profilePanel;
    private String type = "Profile";
    private String typeFeed = "Post";
    private UserDB userDB = UserDB.getInstance();
    private FriendsPages friendsPages;

    private Notifications notifications;


    public UserPage() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("ConnectHub - " + "<username>");
        this.setVisible(true);

        this.profileContentPanel.setLayout(new BorderLayout());
        this.storiesContentPanel.setLayout(new BorderLayout());
        this.postsContentPanel.setLayout(new BorderLayout());

        this.setVisible(true);

        Notification notification = new Notification("Sent you a friend request.", "e9a28975-62c3-4cba-b586-669918ad4389", "a0951309-15c0-46c6-b66a-d341c2499332", "new", LocalDateTime.now(), "FRIEND_REQUEST");
        try{
            NotificationsDB notificationsDB = NotificationsDB.getInstance("e9a28975-62c3-4cba-b586-669918ad4389");
            notificationsDB.addNotification(notification);
            notificationsDB.saveDB();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GlassPanePopup.install(this);
        this.notifications = new Notifications();

        NotificationsService notificationsService = new NotificationsService("e9a28975-62c3-4cba-b586-669918ad4389", this.notifications);
        notificationsService.start();
    }

    public UserPage (User user) {
        this ();

        this.loggedInUser = user;

        this.setTitle("ConnectHub" + " - " + this.loggedInUser.getUserName());

        this.FM = FriendManager.getInstance(user);
        this.postManager = new PostManager(this.loggedInUser);
        this.storyManager = new StoryManager(this.loggedInUser);
        this.type = "Friends";
        this.typeFeed = "Post";
        this.postsPanel = new PostsPanel(this.loggedInUser, postManager,this.postsContentPanel.getWidth(), this.postsContentPanel.getHeight(), type);
        this.typeFeed = "Stories";
        this.storiesPanel = new StoriesPanel(this.loggedInUser, storyManager, this.storiesContentPanel.getWidth(), this.storiesContentPanel.getHeight(), type);
        this.profilePanel = new ProfilePanel(this.loggedInUser, this.loggedInUser, this.profileContentPanel.getWidth(), 200);
        this.refreshManager = new RefreshManager(List.of(postsPanel, storiesPanel));
        this.friendsPages = new FriendsPages(getWidth(), getHeight()-20);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                userDB.refreshDB();
                userDB.searchUserByUserId(loggedInUser.getUserId()).setStatus(false);
                userDB.SaveDB();
            }
        });
        
        this.refreshButtonMouseClicked(null);




        //NotificationsService notificationsService = new NotificationsService(this.loggedInUser.getUserId());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JTabbedPane();
        userProfilePanel = new javax.swing.JPanel();
        profileContentPanel = new javax.swing.JPanel();
        friendsPanel = new javax.swing.JPanel();
        friendsContentPanel = new javax.swing.JPanel();
        friendsStoriesPanel = new javax.swing.JPanel();
        storiesContentPanel = new javax.swing.JPanel();
        friendsPostsPanel = new javax.swing.JPanel();
        postsContentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        groupsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        searchUsersButton = new javax.swing.JButton();
        searchGroupsButton = new javax.swing.JButton();
        searchCriteriaField = new javax.swing.JTextField();
        searchResultsPanel = new javax.swing.JPanel();
        createNewContentButton = new javax.swing.JButton();
        notificationsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 630));
        setSize(new java.awt.Dimension(600, 630));

        logoutButton.setText("Log Out");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });

        mainPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainPanelStateChanged(evt);
            }
        });

        profileContentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout profileContentPanelLayout = new javax.swing.GroupLayout(profileContentPanel);
        profileContentPanel.setLayout(profileContentPanelLayout);
        profileContentPanelLayout.setHorizontalGroup(
                profileContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 576, Short.MAX_VALUE)
        );
        profileContentPanelLayout.setVerticalGroup(
                profileContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 536, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout userProfilePanelLayout = new javax.swing.GroupLayout(userProfilePanel);
        userProfilePanel.setLayout(userProfilePanelLayout);
        userProfilePanelLayout.setHorizontalGroup(
                userProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(userProfilePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(profileContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        userProfilePanelLayout.setVerticalGroup(
                userProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(userProfilePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(profileContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        mainPanel.addTab("Profile", userProfilePanel);

        friendsContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        friendsContentPanel.setMinimumSize(new java.awt.Dimension(576, 536));

        javax.swing.GroupLayout friendsContentPanelLayout = new javax.swing.GroupLayout(friendsContentPanel);
        friendsContentPanel.setLayout(friendsContentPanelLayout);
        friendsContentPanelLayout.setHorizontalGroup(
                friendsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 576, Short.MAX_VALUE)
        );
        friendsContentPanelLayout.setVerticalGroup(
                friendsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 536, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout friendsPanelLayout = new javax.swing.GroupLayout(friendsPanel);
        friendsPanel.setLayout(friendsPanelLayout);
        friendsPanelLayout.setHorizontalGroup(
                friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(friendsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(friendsContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        friendsPanelLayout.setVerticalGroup(
                friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(friendsContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        mainPanel.addTab("Friends", friendsPanel);

        storiesContentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout storiesContentPanelLayout = new javax.swing.GroupLayout(storiesContentPanel);
        storiesContentPanel.setLayout(storiesContentPanelLayout);
        storiesContentPanelLayout.setHorizontalGroup(
                storiesContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 576, Short.MAX_VALUE)
        );
        storiesContentPanelLayout.setVerticalGroup(
                storiesContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 536, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout friendsStoriesPanelLayout = new javax.swing.GroupLayout(friendsStoriesPanel);
        friendsStoriesPanel.setLayout(friendsStoriesPanelLayout);
        friendsStoriesPanelLayout.setHorizontalGroup(
                friendsStoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(friendsStoriesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(storiesContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        friendsStoriesPanelLayout.setVerticalGroup(
                friendsStoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(friendsStoriesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(storiesContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        mainPanel.addTab("Friends' Stories", friendsStoriesPanel);

        postsContentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout postsContentPanelLayout = new javax.swing.GroupLayout(postsContentPanel);
        postsContentPanel.setLayout(postsContentPanelLayout);
        postsContentPanelLayout.setHorizontalGroup(
                postsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 576, Short.MAX_VALUE)
        );
        postsContentPanelLayout.setVerticalGroup(
                postsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 536, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout friendsPostsPanelLayout = new javax.swing.GroupLayout(friendsPostsPanel);
        friendsPostsPanel.setLayout(friendsPostsPanelLayout);
        friendsPostsPanelLayout.setHorizontalGroup(
                friendsPostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(friendsPostsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(postsContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        friendsPostsPanelLayout.setVerticalGroup(
                friendsPostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(friendsPostsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(postsContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        mainPanel.addTab("Friends' Posts", friendsPostsPanel);

        groupsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout groupsPanelLayout = new javax.swing.GroupLayout(groupsPanel);
        groupsPanel.setLayout(groupsPanelLayout);
        groupsPanelLayout.setHorizontalGroup(
                groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 576, Short.MAX_VALUE)
        );
        groupsPanelLayout.setVerticalGroup(
                groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 536, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(groupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(groupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        mainPanel.addTab("Groups", jPanel2);

        searchUsersButton.setText("Search Users");
        searchUsersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchUsersButtonMouseClicked(evt);
            }
        });

        searchGroupsButton.setText("Search Groups");
        searchGroupsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchGroupsButtonMouseClicked(evt);
            }
        });

        searchResultsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout searchResultsPanelLayout = new javax.swing.GroupLayout(searchResultsPanel);
        searchResultsPanel.setLayout(searchResultsPanelLayout);
        searchResultsPanelLayout.setHorizontalGroup(
                searchResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        searchResultsPanelLayout.setVerticalGroup(
                searchResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 507, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(searchResultsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(searchCriteriaField, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchGroupsButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchUsersButton)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchUsersButton)
                                        .addComponent(searchGroupsButton)
                                        .addComponent(searchCriteriaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchResultsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        mainPanel.addTab("Search", jPanel1);

        createNewContentButton.setText("Create New Content");
        createNewContentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createNewContentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createNewContentButtonMouseClicked(evt);
            }
        });

        notificationsButton.setText("Notifications");
        notificationsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        notificationsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationsButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mainPanel)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(logoutButton)
                                                .addGap(38, 38, 38)
                                                .addComponent(createNewContentButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(notificationsButton)
                                                .addGap(50, 50, 50)
                                                .addComponent(refreshButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(logoutButton)
                                        .addComponent(refreshButton)
                                        .addComponent(createNewContentButton)
                                        .addComponent(notificationsButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mainPanel)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainPanelStateChanged
        if (this.loggedInUser != null) {
            this.refreshButtonMouseClicked(null);
        }
    }//GEN-LAST:event_mainPanelStateChanged

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        UserDB.getInstance().refreshDB();
        this.loggedInUser = UserDB.getInstance().searchUserByUserId(this.loggedInUser.getUserId());
        this.loggedInUser = FM.refresh();
        this.refreshManager.refreshAll();
        this.friendsContentPanel.removeAll();
        this.setProfileContentPanel();
        this.setPostsContentPanel();
        this.setStoriesContentPanel();
        this.setCurrentFriendsPanel();
        this.setFriendRequestsPanel();
        this.setSuggestedFriendsPanel();
        this.friendsContentPanel.add(this.friendsPages);
        this.friendsContentPanel.revalidate();
        this.friendsContentPanel.repaint();
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        this.loggedInUser = FM.refresh();
        SwingUtilities.invokeLater(() -> {
            Main main = Main.getInstance();
            main.setVisible(true);
        });
        UserDB.getInstance().refreshDB();
        UserDB.getInstance().searchUserByUserId(this.loggedInUser.getUserId()).setStatus(false);
        UserDB.getInstance().SaveDB();
        this.loggedInUser = FM.refresh();
        this.dispose();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void searchGroupsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGroupsButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchGroupsButtonMouseClicked

    private void searchUsersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchUsersButtonMouseClicked
        this.refreshButtonMouseClicked(null);
        this.searchResultsPanel.removeAll();
        for (User user : UserDB.getInstance().getUsers()) {
            if ( user.getUserName().contains(this.searchCriteriaField.getText()) && // search criteria
                    !user.getUserName().equals(this.loggedInUser.getUserName()) && // not the user himself
                    !this.loggedInUser.getProfile().getFriends().contains(user.getUserId()) && // not already friends
                    !user.getProfile().getBlocked().contains(this.loggedInUser.getUserId())) { // not blocked by user
                this.searchResultsPanel.add(new FriendsPanel (this.loggedInUser, user, this.FM, "Searched", getWidth()-20, getHeight()-30));
            }

        }
        this.searchResultsPanel.revalidate ();
        this.searchResultsPanel.repaint();
    }//GEN-LAST:event_searchUsersButtonMouseClicked

    private void createNewContentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createNewContentButtonMouseClicked
        this.refreshButtonMouseClicked(evt);
        new CreatePostPanel(postManager, storyManager, refreshManager).setVisible(true);
        this.refreshButtonMouseClicked(evt);
    }//GEN-LAST:event_createNewContentButtonMouseClicked

    private void notificationsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationsButtonMouseClicked
        // TODO add your handling code here:

        GlassPanePopup.showPopup(this.notifications, new DefaultOption() {
            @Override
            public float opacity() {
                return 0;
            }


            public LayoutCallback getLayoutCallBack(Component parent) {
                return new DefaultLayoutCallBack(parent) {
                    @Override
                    public void correctBounds(ComponentWrapper cw) {
                        if (parent.isVisible()) {
                            Point pl = parent.getLocationOnScreen();
                            Point bl = notificationsButton.getLocationOnScreen();
                            int x = bl.x - pl.x;
                            int y = bl.y - pl.y;
                            y += (1f - getAnimate()) * 10f;
                            cw.setBounds(x - cw.getWidth() + notificationsButton.getWidth(), y + notificationsButton.getHeight(), cw.getWidth(), cw.getHeight());
                        } else {
                            super.correctBounds(cw);
                        }
                    }
                };
            }

            @Override
            public String getLayout(Component parent, float animate) {
                return null;
            }
        });
        this.notifications.addNoti(new Item());
        this.notifications.revalidate();
        this.notifications.repaint();
    }//GEN-LAST:event_notificationsButtonMouseClicked


    void setProfileContentPanel () {
        this.profileContentPanel.removeAll();
        this.profileContentPanel.setLayout(new BoxLayout(this.profileContentPanel, BoxLayout.Y_AXIS));
        this.type = "Profile";
        this.postsPanel = new PostsPanel(this.loggedInUser, new PostManager(loggedInUser),this.profileContentPanel.getWidth(), this.profileContentPanel.getHeight()/3, type);
        this.storiesPanel = new StoriesPanel(this.loggedInUser, new StoryManager(loggedInUser), this.profileContentPanel.getWidth(), this.profileContentPanel.getHeight()/3, type);
        this.profileContentPanel.add(this.profilePanel);
        this.profileContentPanel.add(this.postsPanel);
        this.profileContentPanel.add(this.storiesPanel);
        this.profileContentPanel.setVisible(true);
        this.profileContentPanel.revalidate();
        this.profileContentPanel.repaint();
    }
    
    void setPostsContentPanel () {
        this.postsContentPanel.removeAll();
        this.type = "Friends";
        this.typeFeed = "Post";
        this.postsPanel = new PostsPanel(this.loggedInUser, new PostManager(this.loggedInUser),this.postsContentPanel.getWidth(), this.postsContentPanel.getHeight(), type);
        this.postsContentPanel.add(this.postsPanel);
        this.postsContentPanel.revalidate();
        this.postsContentPanel.repaint();
    }
    
    void setStoriesContentPanel () {
        this.storiesContentPanel.removeAll();
        this.type = "Friends";
        this.typeFeed = "Stories";
        this.storiesPanel = new StoriesPanel(this.loggedInUser, new StoryManager(this.loggedInUser),this.storiesContentPanel.getWidth(), this.storiesContentPanel.getHeight(), type);
        this.storiesContentPanel.add(this.storiesPanel);
        this.storiesContentPanel.revalidate();
        this.storiesContentPanel.repaint();
    }
    
    void setCurrentFriendsPanel () {
//        this.friendsContentPanel.removeAll();
        this.friendsPages.removeAllCurrentFriendsPanel();
        for (String userID : this.loggedInUser.getProfile().getFriends()) {
            this.friendsPages.addToCurrentFriendsPanel(new FriendsPanel (this.loggedInUser, userDB.searchUserByUserId(userID), this.FM, "Current", getWidth()-20, getHeight()-30));
        }
        this.friendsPages.setCurrentFriends();
        this.friendsContentPanel.add(this.friendsPages);
        this.friendsContentPanel.revalidate();
        this.friendsContentPanel.repaint();
    }
    
    void setFriendRequestsPanel () {
//        this.friendsContentPanel.removeAll();
        this.friendsPages.removeAllFriendRequestsPanel();
        for (String userID : this.loggedInUser.getProfile().getPending()) {
            this.friendsPages.addToFriendRequestsPanel(new FriendsPanel (this.loggedInUser, userDB.searchUserByUserId(userID), this.FM, "Request", getWidth()-20, getHeight()-30));
        }
        this.friendsPages.setFriendRequests();
    }
    
    void setSuggestedFriendsPanel () {
//        this.friendsContentPanel.removeAll();
        this.friendsPages.removeAllSuggestedFriendsPanel();
        for (String friendID : loggedInUser.getProfile().getFriends()) {
            for (String suggestedFriendID : UserDB.getInstance().searchUserByUserId(friendID).getProfile().getFriends()) {
                if (!loggedInUser.getProfile().getFriends().contains(suggestedFriendID) // not already friends
                        && !loggedInUser.getProfile().getPending().contains(suggestedFriendID) // not already sent a request
                        && !suggestedFriendID.equals(loggedInUser.getUserId()) // not the user himself
                        && !loggedInUser.getProfile().getBlocked().contains(suggestedFriendID) // not blocked
                        && !UserDB.getInstance().searchUserByUserId(suggestedFriendID).getProfile().getBlocked().contains(loggedInUser.getUserId())) { // not blocked by the suggested friend
                    this.friendsPages.addToSuggestedFriendsPanel(new FriendsPanel (this.loggedInUser, userDB.searchUserByUserId(suggestedFriendID), this.FM, "Searched", getWidth()-20, getHeight()-30));
                }
            }
        }
        this.friendsPages.setSuggestedFriends();
    }
    
    public void pressRefreshButton () {
        this.refreshButtonMouseClicked(null);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewContentButton;
    private javax.swing.JPanel friendsContentPanel;
    private javax.swing.JPanel friendsPanel;
    private javax.swing.JPanel friendsPostsPanel;
    private javax.swing.JPanel friendsStoriesPanel;
    private javax.swing.JPanel groupsPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTabbedPane mainPanel;
    private javax.swing.JButton notificationsButton;
    private javax.swing.JPanel postsContentPanel;
    private javax.swing.JPanel profileContentPanel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField searchCriteriaField;
    private javax.swing.JButton searchGroupsButton;
    private javax.swing.JPanel searchResultsPanel;
    private javax.swing.JButton searchUsersButton;
    private javax.swing.JPanel storiesContentPanel;
    private javax.swing.JPanel userProfilePanel;
    // End of variables declaration//GEN-END:variables
}
