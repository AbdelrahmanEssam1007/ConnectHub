/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Zaki
 */
public class GroupsPages extends javax.swing.JPanel {

    /**
     * Creates new form GroupsPages
     */
    
    JPanel currentGroups;
    JPanel suggestedGroups;
    
    public GroupsPages(int width, int height) {
        initComponents();
        
        setSize(width, height);
        
        this.currentGroups = new JPanel();
        this.currentGroups.setLayout(new BoxLayout (this.currentGroups, BoxLayout.Y_AXIS));
        this.currentGroups.setBackground(Color.WHITE);
        this.currentGroups.setSize(this.currentGroupsPanel.getWidth(), this.currentGroupsPanel.getHeight());
        this.currentGroupsPanel.setLayout(new BorderLayout ());
        
        this.suggestedGroups = new JPanel();
        this.suggestedGroups.setLayout(new BoxLayout (this.suggestedGroups, BoxLayout.Y_AXIS));
        this.suggestedGroups.setBackground(Color.WHITE);
        this.suggestedGroups.setSize(this.suggestedGroupsPanel.getWidth(), this.suggestedGroupsPanel.getHeight());
        this.suggestedGroupsPanel.setLayout(new BorderLayout ());
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
        currentGroupsPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        suggestedGroupsPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(576, 536));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout currentGroupsPanelLayout = new javax.swing.GroupLayout(currentGroupsPanel);
        currentGroupsPanel.setLayout(currentGroupsPanelLayout);
        currentGroupsPanelLayout.setHorizontalGroup(
            currentGroupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        currentGroupsPanelLayout.setVerticalGroup(
            currentGroupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentGroupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentGroupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Current Groups", jPanel1);

        javax.swing.GroupLayout suggestedGroupsPanelLayout = new javax.swing.GroupLayout(suggestedGroupsPanel);
        suggestedGroupsPanel.setLayout(suggestedGroupsPanelLayout);
        suggestedGroupsPanelLayout.setHorizontalGroup(
            suggestedGroupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        suggestedGroupsPanelLayout.setVerticalGroup(
            suggestedGroupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suggestedGroupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suggestedGroupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Suggested Groups", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addToCurrentGroupsPanel (JPanel panel) {
        this.currentGroups.add(panel);
    }
    public void removeAllCurrentGroupsPanel () {
        this.currentGroupsPanel.removeAll();
        this.currentGroups.removeAll();
    }
    public void setCurrentGroups () {
        this.currentGroups.revalidate();
        this.currentGroups.repaint();
        this.currentGroupsPanel.add (new JScrollPane(this.currentGroups, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        this.currentGroupsPanel.revalidate();
        this.currentGroupsPanel.repaint();
        this.currentGroupsPanel.setVisible(true);
    }
    
    public void addToSuggestedGroupsPanel (JPanel panel) {
        this.suggestedGroups.add(panel);
    }
    public void removeAllSuggestedGroupsPanel () {
        this.suggestedGroupsPanel.removeAll();
        this.suggestedGroups.removeAll();
    }
    public void setSuggestedGroups () {
        this.suggestedGroups.revalidate();
        this.suggestedGroups.repaint();
        this.suggestedGroupsPanel.add (new JScrollPane(this.suggestedGroups, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        this.suggestedGroupsPanel.revalidate();
        this.suggestedGroupsPanel.repaint();
        this.suggestedGroupsPanel.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel currentGroupsPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel suggestedGroupsPanel;
    // End of variables declaration//GEN-END:variables
}