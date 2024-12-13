/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.User;
import backend.UserDB;
import backend.groups.*;
import frontend.content.PostsPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Zaki
 */
public class GroupDetails extends javax.swing.JFrame {

    /**
     * Creates new form GroupDetails
     */
    
    private User user;
    private Group group;
    private GroupRole role;
    private GroupContentManager groupContentManager;
    private PostsPanel postsPanel;

    public GroupDetails(User user, Group group, GroupRole role) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.user = user;
        this.group = group;
        this.role = role;
        
        JPanel membersPanel = new JPanel();
        membersPanel.setLayout(new BoxLayout (membersPanel, BoxLayout.Y_AXIS));
        this.groupMembersDetailsPanel.setLayout(new BorderLayout ());
        for (String userID : this.group.getAllMembers()) {
            membersPanel.add(new FriendsPanel (user, UserDB.getInstance().searchUserByUserId(userID), null, "Group", getWidth(), 150, this.group));
        }

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshButtonPressed();
            }
        } );
        this.groupMembersDetailsPanel.add(refresh, BorderLayout.PAGE_START);
        this.groupMembersDetailsPanel.add(new JScrollPane (membersPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        this.groupMembersDetailsPanel.revalidate();
        this.groupMembersDetailsPanel.repaint();
        
        this.groupPostsPanel.setLayout(new BorderLayout());
        this.groupContentManager = new GroupContentManager(user);
        this.postsPanel = new PostsPanel(user, groupContentManager, groupPostsPanel.getWidth(), groupPostsPanel.getHeight(), group.getGroupID());
        this.groupPostsPanel.add(refresh, BorderLayout.PAGE_START);
        this.groupPostsPanel.add(postsPanel);
    }

    private void refreshButtonPressed() {
        JPanel refreshedPanel = new JPanel();
        refreshedPanel.setLayout(new BoxLayout (refreshedPanel, BoxLayout.Y_AXIS));
        for (String userID : this.group.getAllMembers()) {
            refreshedPanel.add(new FriendsPanel (user, UserDB.getInstance().searchUserByUserId(userID), null, "Group", getWidth(), 150, this.group));
        }
        this.groupMembersDetailsPanel.remove(1);
        this.groupMembersDetailsPanel.add(new JScrollPane (refreshedPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

        this.postsPanel = new PostsPanel(user, new GroupContentManager(user), groupPostsPanel.getWidth(), groupPostsPanel.getHeight(), group.getGroupID());
        this.groupMembersDetailsPanel.remove(1);
        this.groupPostsPanel.add(postsPanel);

        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        groupMembersDetailsPanel = new javax.swing.JPanel();
        groupPostsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(588, 583));
        setPreferredSize(new java.awt.Dimension(588, 583));
        setSize(new java.awt.Dimension(588, 583));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout groupMembersDetailsPanelLayout = new javax.swing.GroupLayout(groupMembersDetailsPanel);
        groupMembersDetailsPanel.setLayout(groupMembersDetailsPanelLayout);
        groupMembersDetailsPanelLayout.setHorizontalGroup(
            groupMembersDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        groupMembersDetailsPanelLayout.setVerticalGroup(
            groupMembersDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Members", groupMembersDetailsPanel);

        javax.swing.GroupLayout groupPostsPanelLayout = new javax.swing.GroupLayout(groupPostsPanel);
        groupPostsPanel.setLayout(groupPostsPanelLayout);
        groupPostsPanelLayout.setHorizontalGroup(
            groupPostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        groupPostsPanelLayout.setVerticalGroup(
            groupPostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Posts", groupPostsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GroupDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GroupDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GroupDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GroupDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GroupDetails().setVisible(true);
//            }
//        });
//    }
    public static void main(String[] args) {
        String userID = "44023cbe-7916-450d-868a-b8b54f8a9330";
        String groupID = "7265bdfd-4c4c-4f01-889f-5bda3851c32e";
        User user = UserDB.getInstance().searchUserByUserId(userID);
        Group group = GroupDB.getInstance().searchGroupByID(groupID);
        new GroupDetails(user,group, GroupManager.getInstance().getGroupRole(groupID, userID)).setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel groupMembersDetailsPanel;
    private javax.swing.JPanel groupPostsPanel;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
