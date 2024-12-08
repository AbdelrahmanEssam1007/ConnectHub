/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.User;

/**
 *
 * @author Zaki
 */
public class UserPage extends javax.swing.JFrame {

    /**
     * Creates new form UserPage
     */
    public UserPage() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("ConnectHub " + "<username>");
        
    }
    
    public UserPage (User user) {
        this ();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        userProfilePanel = new javax.swing.JPanel();
        profileContentPanel = new javax.swing.JPanel();
        friendsPanel = new javax.swing.JPanel();
        friendsStoriesPanel = new javax.swing.JPanel();
        storiesContentPanel = new javax.swing.JPanel();
        friendsPostsPanel = new javax.swing.JPanel();
        postsContentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 630));
        setPreferredSize(new java.awt.Dimension(600, 630));
        setSize(new java.awt.Dimension(600, 630));

        logoutButton.setText("Log Out");

        refreshButton.setText("Refresh");

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

        jTabbedPane1.addTab("Profile", userProfilePanel);

        javax.swing.GroupLayout friendsPanelLayout = new javax.swing.GroupLayout(friendsPanel);
        friendsPanel.setLayout(friendsPanelLayout);
        friendsPanelLayout.setHorizontalGroup(
            friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        friendsPanelLayout.setVerticalGroup(
            friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Friends", friendsPanel);

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

        jTabbedPane1.addTab("Friends' Stories", friendsStoriesPanel);

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

        jTabbedPane1.addTab("Friends' Posts", friendsPostsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel friendsPanel;
    private javax.swing.JPanel friendsPostsPanel;
    private javax.swing.JPanel friendsStoriesPanel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel postsContentPanel;
    private javax.swing.JPanel profileContentPanel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JPanel storiesContentPanel;
    private javax.swing.JPanel userProfilePanel;
    // End of variables declaration//GEN-END:variables
}
