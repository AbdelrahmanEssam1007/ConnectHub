/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.content;

import backend.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import utils.ImageSaver;

import java.awt.*;
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
    /*public Content(){};*/
    
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
