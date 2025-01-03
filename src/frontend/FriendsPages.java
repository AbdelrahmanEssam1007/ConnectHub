/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import utils.ModernScrollBarUI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Zaki
 */
public class FriendsPages extends javax.swing.JPanel {

    /**
     * Creates new form FriendsPages
     */
    JPanel currentFriends;
    JPanel friendRequests;
    JPanel suggestedFriends;
    JPanel searchFriends;
    int setWidth;
    int setHeight;

    public FriendsPages(int width, int height) {
        initComponents();
        setSize(width,height);

        this.setWidth = width;
        this.setHeight = height;

        this.currentFriends = new JPanel();
        this.currentFriends.setLayout(new BoxLayout (this.currentFriends, BoxLayout.Y_AXIS));
        this.currentFriends.setBackground(Color.WHITE);
        this.currentFriends.setSize(this.currentFriendsPanel.getWidth(),this.currentFriendsPanel.getHeight());
        this.currentFriendsPanel.setLayout(new BorderLayout ());

        this.friendRequests = new JPanel();
        this.friendRequests.setLayout(new BoxLayout (this.friendRequests, BoxLayout.Y_AXIS));
        this.friendRequests.setBackground(Color.WHITE);
        this.friendRequests.setSize(this.friendRequestsPanel.getWidth(),this.friendRequestsPanel.getHeight());
        this.friendRequestsPanel.setLayout(new BorderLayout ());

        this.suggestedFriends = new JPanel();
        this.suggestedFriends.setLayout(new BoxLayout (this.suggestedFriends, BoxLayout.Y_AXIS));
        this.suggestedFriends.setBackground(Color.WHITE);
        this.suggestedFriends.setSize(this.suggestedFriendsPanel.getWidth(),this.suggestedFriendsPanel.getHeight());
        this.suggestedFriendsPanel.setLayout(new BorderLayout ());
//        this.currentFriendsPanel.setLayout(new BoxLayout (this.currentFriendsPanel, BoxLayout.Y_AXIS));
//        this.friendRequestsPanel.setLayout(new BoxLayout (this.friendRequestsPanel, BoxLayout.Y_AXIS));
//        this.suggestedFriendsPanel.setLayout(new BoxLayout (this.suggestedFriendsPanel, BoxLayout.Y_AXIS));
//        this.searchedFriendsPanel.setLayout(new BoxLayout (this.suggestedFriendsPanel, BoxLayout.Y_AXIS));
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
        jPanel1 = new javax.swing.JPanel();
        currentFriendsPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        friendRequestsPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        suggestedFriendsPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(576, 536));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(576, 536));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(576, 536));

        javax.swing.GroupLayout currentFriendsPanelLayout = new javax.swing.GroupLayout(currentFriendsPanel);
        currentFriendsPanel.setLayout(currentFriendsPanelLayout);
        currentFriendsPanelLayout.setHorizontalGroup(
            currentFriendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        currentFriendsPanelLayout.setVerticalGroup(
            currentFriendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentFriendsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentFriendsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Current Friends", jPanel1);

        javax.swing.GroupLayout friendRequestsPanelLayout = new javax.swing.GroupLayout(friendRequestsPanel);
        friendRequestsPanel.setLayout(friendRequestsPanelLayout);
        friendRequestsPanelLayout.setHorizontalGroup(
            friendRequestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        friendRequestsPanelLayout.setVerticalGroup(
            friendRequestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendRequestsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendRequestsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Friend Requests", jPanel2);

        javax.swing.GroupLayout suggestedFriendsPanelLayout = new javax.swing.GroupLayout(suggestedFriendsPanel);
        suggestedFriendsPanel.setLayout(suggestedFriendsPanelLayout);
        suggestedFriendsPanelLayout.setHorizontalGroup(
            suggestedFriendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        suggestedFriendsPanelLayout.setVerticalGroup(
            suggestedFriendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suggestedFriendsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suggestedFriendsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Suggested Friends", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

//    private void mainPanelStateChanged(javax.swing.event.ChangeEvent evt) {                                       
//        setCurrentFriends();
//    }

    public void addToCurrentFriendsPanel (JPanel panel) {
        this.currentFriends.add(panel);
    }
    public void removeAllCurrentFriendsPanel () {
        this.currentFriendsPanel.removeAll();
        this.currentFriends.removeAll();
    }
    public void setCurrentFriends () {
        this.currentFriends.revalidate();
        this.currentFriends.repaint();
        JScrollPane scrollContent = new JScrollPane(this.currentFriends, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar sb = scrollContent.getVerticalScrollBar();
        sb.setOpaque(false);
        sb.setForeground(new Color(33, 140, 206));
        sb.setPreferredSize(new Dimension(20, 15));
        sb.setUI(new ModernScrollBarUI());
        this.currentFriendsPanel.add (scrollContent);
        //        this.currentFriendsPanel.setViewportView(this.currentFriends);
        this.currentFriendsPanel.revalidate();
        this.currentFriendsPanel.repaint();
        this.currentFriendsPanel.setVisible(true);
    }
    
    public void addToFriendRequestsPanel (JPanel panel) {
        this.friendRequests.add(panel);
    }
    public void removeAllFriendRequestsPanel () {
        this.friendRequestsPanel.removeAll();
        this.friendRequests.removeAll();
    }
    public void setFriendRequests () {
        this.friendRequests.revalidate();
        this.friendRequests.repaint();
        JScrollPane scrollContent = new JScrollPane(this.friendRequests, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar sb = scrollContent.getVerticalScrollBar();
        sb.setOpaque(false);
        sb.setForeground(new Color(33, 140, 206));
        sb.setPreferredSize(new Dimension(20, 15));
        sb.setUI(new ModernScrollBarUI());
        this.friendRequestsPanel.add (scrollContent);
        this.friendRequestsPanel.revalidate();
        this.friendRequestsPanel.repaint();
        this.friendRequestsPanel.setVisible(true);
    }
    
    public void addToSuggestedFriendsPanel (JPanel panel) {
        this.suggestedFriends.add(panel);
    }
    public void removeAllSuggestedFriendsPanel () {
        this.suggestedFriendsPanel.removeAll();
        this.suggestedFriends.removeAll();
    }
    public void setSuggestedFriends () {
        this.suggestedFriends.revalidate();
        this.suggestedFriends.repaint();
        JScrollPane scrollContent = new JScrollPane(this.suggestedFriends, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar sb = scrollContent.getVerticalScrollBar();
        sb.setOpaque(false);
        sb.setForeground(new Color(33, 140, 206));
        sb.setPreferredSize(new Dimension(20, 15));
        sb.setUI(new ModernScrollBarUI());
        this.suggestedFriendsPanel.add (scrollContent);
        this.suggestedFriendsPanel.revalidate();
        this.suggestedFriendsPanel.repaint();
        this.suggestedFriendsPanel.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel currentFriendsPanel;
    private javax.swing.JPanel friendRequestsPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel suggestedFriendsPanel;
    // End of variables declaration//GEN-END:variables
}
