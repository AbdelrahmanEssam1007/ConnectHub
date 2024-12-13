/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.User;
import backend.groups.Group;
import backend.groups.GroupManager;
import backend.groups.GroupMember;
import backend.groups.GroupRole;
import backend.groups.PrimaryAdmin;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import utils.Constants;

/**
 *
 * @author Zaki
 */
public class GroupPanel extends javax.swing.JPanel {

    /**
     * Creates new form GroupPanel
     */
    
    private String pfpImagePath;
    private ImageIcon pfpImage;
    private JLabel pfpLabel;
    
    private GroupRole role;
    private User user;
    private Group group;
    
    public GroupPanel(User user, Group group) {
        initComponents();
        
        pfpImagePath = group.getGroupPhoto();
        if(pfpImagePath == null) {
            pfpImagePath = Constants.DEFAULT_PFP; // Default profile picture
        }
        pfpImage = new ImageIcon(pfpImagePath);
        Image scaledPfpImage = pfpImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        pfpImage = new ImageIcon(scaledPfpImage);

        pfpLabel = new JLabel(pfpImage);
        pfpPanel.setLayout(new BorderLayout());
        pfpPanel.add(pfpLabel, BorderLayout.CENTER);
        
        this.groupnameLabel.setText(group.getGroupName());
        
        this.role = GroupManager.getInstance().getGroupRole(group.getGroupID(), user.getUserId());
        if (this.role == GroupRole.GUEST) {
            this.jButton1.setText("View");
            this.jButton2.setText("Request to Join");
        }
        else if (this.role == GroupRole.PRIMARY_ADMIN || this.role == GroupRole.ADMIN) {
            this.jButton1.setText("Manage");
            if (this.role == GroupRole.PRIMARY_ADMIN) {
                this.jButton2.setText("Delete");
            }
            else {
                this.jButton2.setText("Leave");
            }
        }
        else if (this.role == GroupRole.PENDING_MEMBER) {
            this.jButton1.setText("View");
            this.jButton2.setVisible(false);
        }
        else {
            this.jButton1.setText("View");
            this.jButton2.setText("Leave");
        }
        
        this.user = user;
        this.group = group;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pfpPanel = new javax.swing.JPanel();
        groupnameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(564, 126));
        setPreferredSize(new java.awt.Dimension(564, 126));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(564, 126));

        pfpPanel.setBackground(new java.awt.Color(255, 255, 255));
        pfpPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.black, java.awt.Color.darkGray, java.awt.Color.black));
        pfpPanel.setMinimumSize(new java.awt.Dimension(110, 110));

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

        groupnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pfpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(groupnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 254, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pfpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(groupnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        new GroupDetails(user, group, role).setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (this.role == GroupRole.GUEST) {
            GroupManager.getInstance().requestToJoinGroup(this.group.getGroupID(), this.user.getUserId());
        }
        else if (this.role == GroupRole.PRIMARY_ADMIN) {
            new PrimaryAdmin (this.user, this.group).deleteGroup();
        }
        else if (this.role == GroupRole.ADMIN) {
            new GroupMember(this.user, this.group).leaveGroup();
        }
        else {
            new GroupMember(this.user, this.group).leaveGroup();
        }
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel groupnameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pfpPanel;
    // End of variables declaration//GEN-END:variables
}
