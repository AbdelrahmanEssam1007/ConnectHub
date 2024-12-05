/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.FriendManager;
import backend.CustomCellRenderer;
import backend.Profile;
import backend.User;
import backend.UserDB;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Zaki
 */
public class UserPage extends javax.swing.JFrame {

    /**
     * Creates new form UserPage
     */
    
    private User loggedInUser;
    
    public UserPage() {
        initComponents();
        
        this.setTitle("ConnectHub - <username>");
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension (600, 630));
        this.setVisible(true);
        
        
    }
    
    public UserPage (User user) {
        this ();
        
        this.loggedInUser = user;
        
        this.updateCurrentFriendsList();
        
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 630));
        setPreferredSize(new java.awt.Dimension(600, 630));
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
        this.currentFriendsList.setCellRenderer(new CustomCellRenderer ());
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
        this.friendRequestsList.setCellRenderer(new CustomCellRenderer ());
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
        this.friendSuggestionsList.setCellRenderer(new CustomCellRenderer ());
        jScrollPane3.setViewportView(friendSuggestionsList);

        sendRequestToSuggestedButton.setText("Send Friend Request");
        sendRequestToSuggestedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendRequestToSuggestedButtonMouseClicked(evt);
            }
        });

        jLabel4.setText("Search For New Friends");

        searchedUsersList.setModel(new DefaultListModel<String>());
        this.searchedUsersList.setCellRenderer(new CustomCellRenderer ());
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(quitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(showProfileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showFriendsPostsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showFriendsStoriesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createNewPostButton)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showFriendsPostsButton)
                    .addComponent(showFriendsStoriesButton)
                    .addComponent(showProfileButton)
                    .addComponent(createNewPostButton))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_showProfileButtonMouseClicked

    private void showFriendsPostsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFriendsPostsButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_showFriendsPostsButtonMouseClicked

    private void showFriendsStoriesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFriendsStoriesButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_showFriendsStoriesButtonMouseClicked

    private void blockCurrentFriendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blockCurrentFriendButtonMouseClicked
        if (this.currentFriendsList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "You must select a username", "No Selection Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        new FriendManager(this.loggedInUser).blockUser(UserDB.getInstance().searchUserByUserName(this.currentFriendsList.getSelectedValue()));
        this.updateCurrentFriendsList();
    }//GEN-LAST:event_blockCurrentFriendButtonMouseClicked

    private void removeCurrentFriendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCurrentFriendButtonMouseClicked
        if (this.currentFriendsList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "You must select a username", "No Selection Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        new FriendManager(this.loggedInUser).removeUserFriend(UserDB.getInstance().searchUserByUserName(this.currentFriendsList.getSelectedValue()));
        this.updateCurrentFriendsList();
    }//GEN-LAST:event_removeCurrentFriendButtonMouseClicked

    private void rejectRequestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rejectRequestButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rejectRequestButtonMouseClicked

    private void acceptRequestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptRequestButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_acceptRequestButtonMouseClicked

    private void sendRequestToSuggestedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendRequestToSuggestedButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sendRequestToSuggestedButtonMouseClicked

    private void searchForUsersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchForUsersButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchForUsersButtonMouseClicked

    private void sendRequestToSearchedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendRequestToSearchedButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sendRequestToSearchedButtonMouseClicked

    private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_quitButtonMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void createNewPostButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createNewPostButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewPostButtonMouseClicked

    private void updateCurrentFriendsList () {
        List <String> friends = new ArrayList<>();
        for (String friendID : loggedInUser.getProfile().getFriends()) {
            friends.add(UserDB.getInstance().searchUserByUserId(friendID).getUserName());
        }
        this.currentFriendsList.setListData(new Vector<String>(friends));
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
