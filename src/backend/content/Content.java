/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.content;

import backend.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Content {
    @JsonProperty
    private ContentData contentData;
    private LocalDateTime postDate;
    private String postID;
    private String authorID;
    private String username;

    public Content(ContentData contentData, LocalDateTime postDate, String postID, String authorID, String username) {
        this.contentData = contentData;
        this.postDate = postDate;
        this.postID = postID;
        this.authorID = authorID;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*TODO: try removing empty constructor here and in content data*/
    public Content(){};

    public Content(String text, User user) {
        contentData = new ContentData(text);
        this.postDate = LocalDateTime.now();
        this.postID = "postIDTest";
        this.authorID = user.getUserId();
        this.username = user.getUserName();
    }
    
    public Content(String text, File imageFile, User user) {
        String path = saveImage(imageFile);
        contentData = new ContentData(text, path);
        this.postDate = LocalDateTime.now();
        this.postID = "postIDTest";
        this.authorID = user.getUserId();
        this.username = user.getUserName();
    }
    
    public Content(File imageFile, User user) {
        String path = saveImage(imageFile);
        contentData = new ContentData(path, true);
        this.postDate = LocalDateTime.now();
        this.postID = "postIDTest";
        this.authorID = user.getUserId();
        this.username = user.getUserName();
    }
    
    private String saveImage(File imageFile){
        try {
            BufferedImage temp = ImageIO.read(imageFile);

            BufferedImage convertedImage = new BufferedImage(
                temp.getWidth(),
                temp.getHeight(),
                BufferedImage.TYPE_INT_RGB 
            );

            Graphics2D g = convertedImage.createGraphics();
            g.drawImage(temp, 0, 0, null);
            g.dispose();

            File destinationDir = new File("images/");
            if (!destinationDir.exists()) {
                destinationDir.mkdir();
            }

            String fileName = imageFile.getName().replaceAll("\\..*$", "") + ".jpg";
            File destinationFile = new File(destinationDir, fileName);
            ImageIO.write(convertedImage, "jpg", destinationFile);

            return destinationFile.getAbsolutePath();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public String returnImagePath(){
        return contentData.getImagePath();
    }
    
    public String returnText(){
        return contentData.getText();
    }
        
    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public void setContentData(ContentData contentData) {
        this.contentData = contentData;
    }

    public ContentData getContentData() {
        return contentData;
    }
}
