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

import utils.FileNames;
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
    private List<Post> posts = new ArrayList<>();
    public PostsPanel(User user, int width, int height) {
        initComponents();
        this.user = user;
        setLayout(new BorderLayout());
        setSize(width, height);
        postContainer.setLayout(new BoxLayout(postContainer, BoxLayout.Y_AXIS));
        JScrollPane postScroller = new JScrollPane(postContainer);
        add(postScroller, BorderLayout.CENTER);
        setBackground(Color.WHITE);

        Post x = new Post("test", user);
        posts.add(x);
        saveToDB();

        readFromDB();
        for(Post t : posts){
            addPostPanel(t);
        }

    }
    
    private void saveToDB(){
        try {
            List<Post> allPosts = JSONFileReader.readJson(FileNames.POSTS.getFileName(), Post.class);
            allPosts.addAll(posts);
            JSONFileWriter.writeJson(FileNames.POSTS.getFileName(), allPosts);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void readFromDB(){
        try {
            List<Post> allPosts =JSONFileReader.readJson(FileNames.POSTS.getFileName(), Post.class);
            posts.clear();
            posts.addAll(allPosts);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading posts from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private File uploadImage(){
        fileChooser.setDialogTitle("Select an image file");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        else{
            JOptionPane.showMessageDialog(null, "Error uploading image..", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void addPostPanel(Post post) {
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
        JLabel postHeader = new JLabel(post.getUsername()+ "    " + post.getPostDate().format(postDateFormat));
        postHeader.setFont(new Font("Arial", Font.BOLD, 12));
        postPanel.add(postHeader);

        /*To do combine all types of posts in one constructor*/
        String imagePath = post.returnImagePath();
        if (post.returnText() != null && imagePath != null) {
            postPanel.add(new JLabel(post.returnText()));
        } else if (post.returnText() != null) {
            postPanel.add(new JLabel(post.returnText()));
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
