/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.*;

import java.awt.Dimension;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import backend.User;
import backend.content.Post;
import backend.content.PostManager;
import backend.content.Story;
import backend.content.StoryManager;
import frontend.content.CreatePostPanel;
import frontend.content.PostsPanel;
import frontend.content.StoriesPanel;
import utils.ImageUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Zaki
 */
public class UserPage extends javax.swing.JFrame {

    /**
     * Creates new form UserPage
     */

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

    public UserPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension (800, 700));
    }

    public UserPage (User user) {
        this ();
        this.loggedInUser = user;
        this.setTitle("ConnectHub" + " - " + this.loggedInUser.getUserName());
        this.FM = FriendManager.getInstance(user);
        this.updateCurrentFriendsList();
        this.updateFriendRequestsList();
        this.updateFriendSuggestionsList();

        postManager = new PostManager(this.loggedInUser);
        storyManager = new StoryManager(this.loggedInUser);
        System.out.println(jPanel1.getWidth());
        postsPanel = new PostsPanel(this.loggedInUser, postManager,jPanel1.getWidth(), jPanel1.getHeight(), type);
        storiesPanel = new StoriesPanel(this.loggedInUser, storyManager, jPanel1.getWidth(), jPanel1.getHeight(), type);
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setLayout(new BorderLayout());

        /*Setup Refresh manager*/
        refreshManager = new RefreshManager(List.of(postsPanel, storiesPanel));
        refreshManager.refreshAll();

        /*Adding first panel profile panel*/
        jPanel1.add(postsPanel, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
        postsPanel.setVisible(true);
        this.setVisible(true);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                UserDB.getInstance().refreshDB();
                UserDB.getInstance().searchUserByUserId(loggedInUser.getUserId()).setStatus(false);
                UserDB.getInstance().SaveDB();
            }
        });
        this.showProfileButtonMouseClicked(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showFriendsPostsButton = new javax.swing.JButton();
        showFriendsStoriesButton = new javax.swing.JButton();
        showProfileButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentFriendsList = new javax.swing.JList<>();
        removeCurrentFriendButton = new javax.swing.JButton();
        blockCurrentFriendButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        friendRequestsList = new javax.swing.JList<>();
        acceptRequestButton = new javax.swing.JButton();
        rejectRequestButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        friendSuggestionsList = new javax.swing.JList<>();
        sendRequestToSuggestedButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        searchedUsersList = new javax.swing.JList<>();
        sendRequestToSearchedButton = new javax.swing.JButton();
        searchCriteriaField = new javax.swing.JTextField();
        searchForUsersButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        quitButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        createNewPostButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 630));
        setPreferredSize(new java.awt.Dimension(600, 630));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 630));

        showFriendsPostsButton.setText("Friends' Posts");
        showFriendsPostsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showFriendsPostsButtonMouseClicked(evt);
            }
        });

        showFriendsStoriesButton.setText("Friends' Stories");
        showFriendsStoriesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showFriendsStoriesButtonMouseClicked(evt);
            }
        });

        showProfileButton.setText("Profile");
        showProfileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showProfileButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Current Friends");

        currentFriendsList.setModel(new DefaultListModel<String>()
        );
        currentFriendsList.setCellRenderer(new CustomCellRenderer());
        jScrollPane1.setViewportView(currentFriendsList);

        removeCurrentFriendButton.setText("Remove");
        removeCurrentFriendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCurrentFriendButtonMouseClicked(evt);
            }
        });

        blockCurrentFriendButton.setText("Block");
        blockCurrentFriendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blockCurrentFriendButtonMouseClicked(evt);
            }
        });

        jLabel2.setText("Friend Requests");

        friendRequestsList.setModel(new DefaultListModel<String>()
        );
        friendRequestsList.setCellRenderer(new CustomCellRenderer());
        jScrollPane2.setViewportView(friendRequestsList);

        acceptRequestButton.setText("Accept");
        acceptRequestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acceptRequestButtonMouseClicked(evt);
            }
        });

        rejectRequestButton.setText("Reject");
        rejectRequestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rejectRequestButtonMouseClicked(evt);
            }
        });

        jLabel3.setText("Friend Suggestions");

        friendSuggestionsList.setModel(new DefaultListModel<String>());
        friendSuggestionsList.setCellRenderer(new CustomCellRenderer());
        jScrollPane3.setViewportView(friendSuggestionsList);

        sendRequestToSuggestedButton.setText("Send Friend Request");
        sendRequestToSuggestedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendRequestToSuggestedButtonMouseClicked(evt);
            }
        });

        jLabel4.setText("Search For New Friends");

        searchedUsersList.setModel(new DefaultListModel<String>());
        searchedUsersList.setCellRenderer(new CustomCellRenderer());
        jScrollPane4.setViewportView(searchedUsersList);

        sendRequestToSearchedButton.setText("Send Friend Request");
        sendRequestToSearchedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendRequestToSearchedButtonMouseClicked(evt);
            }
        });

        searchForUsersButton.setText("Search");
        searchForUsersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchForUsersButtonMouseClicked(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setMinimumSize(new java.awt.Dimension(550, 535));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 535));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        quitButton.setText("Quit");
        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitButtonMouseClicked(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });

        createNewPostButton.setText("Create New Post");
        createNewPostButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createNewPostButtonMouseClicked(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchCriteriaField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchForUsersButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(sendRequestToSearchedButton)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rejectRequestButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(acceptRequestButton))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(blockCurrentFriendButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(removeCurrentFriendButton))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(sendRequestToSuggestedButton)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(showProfileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showFriendsPostsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showFriendsStoriesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createNewPostButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showFriendsPostsButton)
                    .addComponent(showFriendsStoriesButton)
                    .addComponent(showProfileButton)
                    .addComponent(createNewPostButton)
                    .addComponent(refreshButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeCurrentFriendButton)
                            .addComponent(blockCurrentFriendButton))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(acceptRequestButton)
                            .addComponent(rejectRequestButton))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sendRequestToSuggestedButton)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchForUsersButton)
                            .addComponent(searchCriteriaField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sendRequestToSearchedButton))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitButton)
                    .addComponent(logoutButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showProfileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showProfileButtonMouseClicked
        this.loggedInUser = FM.refresh();
        refreshManager.refreshAll();
        profilePanel = new ProfilePanel(this.loggedInUser, jPanel1.getWidth(), 200);
        type = "Profile";
        postsPanel = new PostsPanel(this.loggedInUser, new PostManager(loggedInUser),jPanel1.getWidth(), jPanel1.getHeight()/2, type);
        storiesPanel = new StoriesPanel(this.loggedInUser, new StoryManager(loggedInUser), jPanel1.getWidth(), jPanel1.getHeight()/2, type);
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
        jPanel1.removeAll();
        jPanel1.add(profilePanel);
        jPanel1.add(postsPanel);
        jPanel1.add(storiesPanel);
        jPanel1.revalidate();
        jPanel1.repaint();
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_showProfileButtonMouseClicked

    private void showFriendsPostsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFriendsPostsButtonMouseClicked
        this.loggedInUser = FM.refresh();
        refreshManager.refreshAll();
        type = "Friends";
        typeFeed = "Post";
        postsPanel = new PostsPanel(this.loggedInUser, new PostManager(loggedInUser),jPanel1.getWidth(), jPanel1.getHeight(), type);
        jPanel1.removeAll();
        jPanel1.add(postsPanel);
        jPanel1.revalidate();
        jPanel1.repaint();
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_showFriendsPostsButtonMouseClicked

    private void showFriendsStoriesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFriendsStoriesButtonMouseClicked
        this.loggedInUser = FM.refresh();
        refreshManager.refreshAll();
        type = "Friends";
        typeFeed = "Stories";
        storiesPanel = new StoriesPanel(this.loggedInUser, new StoryManager(loggedInUser), jPanel1.getWidth(), jPanel1.getHeight(), type);
        jPanel1.removeAll();
        jPanel1.add(storiesPanel);
        jPanel1.revalidate();
        jPanel1.repaint();
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_showFriendsStoriesButtonMouseClicked

    private void blockCurrentFriendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blockCurrentFriendButtonMouseClicked
        this.loggedInUser = FM.refresh();
        refreshManager.refreshAll();
        if (this.currentFriendsList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "You must select a username", "No Selection Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        FM.blockUser(UserDB.getInstance().searchUserByUserName(this.currentFriendsList.getSelectedValue()));
        this.updateCurrentFriendsList();
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_blockCurrentFriendButtonMouseClicked

    private void removeCurrentFriendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCurrentFriendButtonMouseClicked
        this.loggedInUser = FM.refresh();
        refreshManager.refreshAll();
        if (this.currentFriendsList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "You must select a username", "No Selection Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        FM.removeUserFriend(UserDB.getInstance().searchUserByUserName(this.currentFriendsList.getSelectedValue()));
        this.updateCurrentFriendsList();
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_removeCurrentFriendButtonMouseClicked

    private void rejectRequestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rejectRequestButtonMouseClicked
        this.loggedInUser = FM.refresh();
        if (this.friendRequestsList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "You must select a username", "No Selection Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        FM.declineFriendRequest(UserDB.getInstance().searchUserByUserName(this.friendRequestsList.getSelectedValue()));
        this.updateFriendRequestsList();
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_rejectRequestButtonMouseClicked

    private void acceptRequestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptRequestButtonMouseClicked
        this.loggedInUser = FM.refresh();
        refreshManager.refreshAll();
        if (this.friendRequestsList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "You must select a username", "No Selection Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        FM.acceptFriendRequest(UserDB.getInstance().searchUserByUserName(this.friendRequestsList.getSelectedValue()));
        this.updateFriendRequestsList();
        this.updateCurrentFriendsList();
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_acceptRequestButtonMouseClicked

    private void sendRequestToSuggestedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendRequestToSuggestedButtonMouseClicked
        this.loggedInUser = FM.refresh();
        refreshManager.refreshAll();
        if (this.friendSuggestionsList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "You must select a username", "No Selection Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        try {
            FM.sendFriendRequest(UserDB.getInstance().searchUserByUserName(this.friendSuggestionsList.getSelectedValue()));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Friend request already sent.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_sendRequestToSuggestedButtonMouseClicked

    private void searchForUsersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchForUsersButtonMouseClicked
        this.loggedInUser = FM.refresh();
        refreshManager.refreshAll();
        List <String> searchedUsers = new ArrayList<>();
        for (User user : UserDB.getInstance().getUsers()) {
            if ( user.getUserName().contains(this.searchCriteriaField.getText()) && // search criteria
                    !user.getUserName().equals(this.loggedInUser.getUserName()) && // not the user himself
                    !this.loggedInUser.getProfile().getFriends().contains(user.getUserId()) && // not already friends
                    !user.getProfile().getBlocked().contains(this.loggedInUser.getUserId())) { // not blocked by user
                searchedUsers.add(user.getUserName());
            }

        }
        this.searchedUsersList.setListData(new Vector<String>(searchedUsers));
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_searchForUsersButtonMouseClicked

    private void sendRequestToSearchedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendRequestToSearchedButtonMouseClicked
        this.loggedInUser = FM.refresh();
        refreshManager.refreshAll();
        if (this.searchedUsersList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "You must select a username", "No Selection Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(this.loggedInUser.getProfile().getBlocked().contains(UserDB.getInstance().searchUserByUserName(this.searchedUsersList.getSelectedValue()).getUserId())){
            int response = JOptionPane.showConfirmDialog(null, "You have blocked this user. Do you want to unblock them?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                FM.unblockUser(UserDB.getInstance().searchUserByUserName(this.searchedUsersList.getSelectedValue()));
            } else {
                JOptionPane.showMessageDialog(null, "You cannot send a friend request to a user you have blocked.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        try {
            FM.sendFriendRequest(UserDB.getInstance().searchUserByUserName(this.searchedUsersList.getSelectedValue()));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Friend request already sent.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_sendRequestToSearchedButtonMouseClicked

    private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseClicked
        this.loggedInUser = FM.refresh();
        UserDB.getInstance().refreshDB();
        UserDB.getInstance().searchUserByUserId(this.loggedInUser.getUserId()).setStatus(false);
        UserDB.getInstance().SaveDB();
        this.loggedInUser = FM.refresh();
        this.dispose();
    }//GEN-LAST:event_quitButtonMouseClicked

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

    private void createNewPostButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createNewPostButtonMouseClicked
        this.loggedInUser = FM.refresh();
        new CreatePostPanel(postManager, storyManager, refreshManager).setVisible(true);
        refreshManager.refreshAll();
        profilePanel = new ProfilePanel(this.loggedInUser, jPanel1.getWidth(), 200);
        if(typeFeed.equals("Post"))
            postsPanel = new PostsPanel(this.loggedInUser, postManager,jPanel1.getWidth(), jPanel1.getHeight(), type);
        else{
            storiesPanel = new StoriesPanel(this.loggedInUser, storyManager, jPanel1.getWidth(), jPanel1.getHeight(), type);
        }

        jPanel1.removeAll();
        jPanel1.add(profilePanel, BorderLayout.PAGE_START);
        jPanel1.add(postsPanel, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();

        if(type.equals("Profile")){
            showProfileButtonMouseClicked(null);
        }
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_createNewPostButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        UserDB.getInstance().refreshDB();
        this.loggedInUser = FM.refresh();
        loggedInUser = UserDB.getInstance().searchUserByUserId(loggedInUser.getUserId());
        this.updateCurrentFriendsList();
        this.updateFriendRequestsList();
        this.updateFriendSuggestionsList();
        if (type.equals("Profile")) {
            this.showProfileButtonMouseClicked(evt);
        }
        else if (type.equals("Friends") && typeFeed.equals("Post")) {
            this.showFriendsPostsButtonMouseClicked(evt);
        }
        else if (type.equals("Friends") && typeFeed.equals("Stories")) {
            this.showFriendsStoriesButtonMouseClicked(evt);
        }
        this.loggedInUser = FM.refresh();
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void updateCurrentFriendsList () {
        this.loggedInUser = FM.refresh();
        List <String> friends = new ArrayList<>();
        for (String friendID : loggedInUser.getProfile().getFriends()) {
            friends.add(UserDB.getInstance().searchUserByUserId(friendID).getUserName());
        }
        this.currentFriendsList.setListData(new Vector<String>(friends));
        this.loggedInUser = FM.refresh();
    }

    private void updateFriendRequestsList () {
        this.loggedInUser = FM.refresh();
        List <String> friendRequests = new ArrayList<>();
        for (String friendID : loggedInUser.getProfile().getPending()) {
            friendRequests.add(UserDB.getInstance().searchUserByUserId(friendID).getUserName());
        }
        this.friendRequestsList.setListData(new Vector<String>(friendRequests));
        this.loggedInUser = FM.refresh();
    }

    private void updateFriendSuggestionsList() {
        this.loggedInUser = FM.refresh();
        Set<String> uniqueFriendSuggestions = new HashSet<>();

        for (String friendID : loggedInUser.getProfile().getFriends()) {
            for (String suggestedFriendID : UserDB.getInstance().searchUserByUserId(friendID).getProfile().getFriends()) {
                if (!loggedInUser.getProfile().getFriends().contains(suggestedFriendID) // not already friends
                        && !loggedInUser.getProfile().getPending().contains(suggestedFriendID) // not already sent a request
                        && !suggestedFriendID.equals(loggedInUser.getUserId()) // not the user himself
                        && !loggedInUser.getProfile().getBlocked().contains(suggestedFriendID) // not blocked
                        && !UserDB.getInstance().searchUserByUserId(suggestedFriendID).getProfile().getBlocked().contains(loggedInUser.getUserId())) { // not blocked by the suggested friend
                    uniqueFriendSuggestions.add(UserDB.getInstance().searchUserByUserId(suggestedFriendID).getUserName());
                }
            }
        }

        this.friendSuggestionsList.setListData(new Vector<>(uniqueFriendSuggestions));
        this.loggedInUser = FM.refresh();
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
    private javax.swing.JButton acceptRequestButton;
    private javax.swing.JButton blockCurrentFriendButton;
    private javax.swing.JButton createNewPostButton;
    private javax.swing.JList<String> currentFriendsList;
    private javax.swing.JList<String> friendRequestsList;
    private javax.swing.JList<String> friendSuggestionsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton rejectRequestButton;
    private javax.swing.JButton removeCurrentFriendButton;
    private javax.swing.JTextField searchCriteriaField;
    private javax.swing.JButton searchForUsersButton;
    private javax.swing.JList<String> searchedUsersList;
    private javax.swing.JButton sendRequestToSearchedButton;
    private javax.swing.JButton sendRequestToSuggestedButton;
    private javax.swing.JButton showFriendsPostsButton;
    private javax.swing.JButton showFriendsStoriesButton;
    private javax.swing.JButton showProfileButton;
    // End of variables declaration//GEN-END:variables
}
