/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.content;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Content {
    @JsonProperty
    private ContentData contentData;
    private LocalDateTime postDate;
    private String postID;
    private String authorID;
    private String groupID;
    private String username;

    /*TODO: Replace it with json creator constructor if enough time*/
    /*Do not remove empty constructor for now, needed for Jackson*/
    public Content(){};

    public Content(ContentData contentData, LocalDateTime postDate, String postID, String authorID, String groupID, String username) {
        this.contentData = contentData;
        this.postDate = postDate;
        this.postID = postID;
        this.authorID = authorID;
        this.username = username;
        this.groupID = groupID;
    }

    public boolean expired(){ return false; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
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

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Content objContent = (Content)obj;
        return getPostID().equals(objContent.getPostID());
    }
}
