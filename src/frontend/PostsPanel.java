/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.Post;
import backend.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import utils.JSONFileReader;
import utils.JSONFileWriter;

/**
 *
 * @author Amr
 */
public class PostsPanel extends javax.swing.JPanel {
    private User user;
    private JFileChooser fileChooser = new JFileChooser();
    private JPanel postContainer = new JPanel();
    private ArrayList<Post> posts = new ArrayList<>();
    public PostsPanel(User user, int width, int height) {
        initComponents();
        this.user = user;
        setLayout(new BorderLayout());
        setSize(width, height);
        postContainer.setLayout(new BoxLayout(postContainer, BoxLayout.Y_AXIS));
        JScrollPane postScroller = new JScrollPane(postContainer);
        add(postScroller, BorderLayout.CENTER);
        
        int result = uploadImage();
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            addPostPanel(new Post("Hello This is text", user));
            addPostPanel(new Post("second post here", selectedFile, user));
            addPostPanel(new Post(selectedFile, user));
        }

    }
    
    /*private void saveToDB(){
        try {
            List<Post> allPosts = JSONFileReader.readJson("posts.json", Post.class);
            allPosts.addAll(posts);
            JSONFileWriter.writeJson("posts.json", allPosts);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loading or saving to post database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }*/
    
    private int uploadImage(){
        fileChooser.setDialogTitle("Select an image file");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));

        int result = fileChooser.showOpenDialog(this);
        return result;
    }
    
    private void addPostPanel(Post post){
        posts.add(post);
        postContainer.add(createPostPanel(post));
        postContainer.revalidate();
        postContainer.repaint();
    }
    
    private JPanel createPostPanel(Post post){
        JPanel postPanel = new JPanel();
        postPanel.setBackground(Color.WHITE);
        postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS));
        postPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        DateTimeFormatter postDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        JLabel postHeader = new JLabel(post.getUsername()+ "      " + post.getPostDate().format(postDateFormat));
        postHeader.setFont(new Font("Arial", Font.BOLD, 12));
        postPanel.add(postHeader);
        
        String imagePath = post.getImagePath();
        if (post.getText() != null && imagePath != null) {
            postPanel.add(new JLabel(post.getText()));
        } else if (post.getText() != null) {
            postPanel.add(new JLabel(post.getText()));
        }
        if(imagePath != null){
            ImageIcon postImage = new ImageIcon(imagePath);
            int imageWidth = getWidth() - 60;
            int imageHeight = postImage.getIconHeight() * imageWidth / postImage.getIconWidth();
            Image scaledPost = postImage.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            postImage = new ImageIcon(scaledPost);
            postPanel.add(new JLabel(postImage));
        }
        

        return postPanel;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
