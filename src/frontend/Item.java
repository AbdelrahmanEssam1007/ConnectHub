package frontend;

import javax.swing.Icon;

import utils.Constants;
import utils.ImageAvatar;

import java.awt.*;
import java.lang.constant.Constable;

/**
 *
 * @author RAVEN
 */
public class Item extends javax.swing.JPanel implements Constants {

    public Item(Icon icon, String name, String des, String time, String type) {
        initComponents();
        pic.setIcon(icon);
        lbName.setText(name);
        lbDes.setText(des);
        lbTime.setText(time);
        if(type.equals("GROUP_ACTIVITY")) {
            jButton1.setText("");
            jButton1.setVisible(false);
            jButton2.setBackground(new java.awt.Color(0, 153, 255));
            jButton2.setText("Open Group");
        }
        else if(type.equals("POST")) {
            jButton1.setText("");
            jButton1.setVisible(false);
            jButton2.setBackground(new java.awt.Color(0, 153, 255));
            jButton2.setText("Open Post");
        }
        else if(type.equals("FRIEND_REQUEST")) {
            jButton1.setVisible(true);
            jButton1.setBackground(new java.awt.Color(0, 153, 255));
            jButton2.setBackground(new java.awt.Color(102, 102, 102));
            jButton1.setText("Accept");
            jButton2.setText("Decline");
        } else if (type.equals("BLANK")) {
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

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("jButton2");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lbDes;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbTime;
    private ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
