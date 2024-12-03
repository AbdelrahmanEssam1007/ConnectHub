/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.User;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Content {
    private ContentData contentData;
    private String postDate;
    private String postID;
    private String authorID;

    public Content(String text, User user) {
        contentData = new ContentData(text);
        this.postDate = LocalDateTime.now().toString();
        this.postID = "postIDTest";
        this.authorID = user.getUserId();
    }
    
    public Content(String text, File imageFile, User user) {
        String path = saveImage(imageFile);
        contentData = new ContentData(text, path);
        this.postDate = LocalDateTime.now().toString();
        this.postID = "postIDTest";
        this.authorID = user.getUserId();
    }
    
    public Content(File imageFile, User user) {
        String path = saveImage(imageFile);
        contentData = new ContentData(path);
        this.postDate = LocalDateTime.now().toString();
        this.postID = "postIDTest";
        this.authorID = user.getUserId();
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
    
    public BufferedImage getImage(){
        return contentData.loadImage();
    }
    
    public String getText(){
        return contentData.getText();
    }
        
    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
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
    
}
