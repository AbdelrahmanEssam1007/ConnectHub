package backend.content;

import backend.Notifications.Notification;
import backend.Notifications.NotificationsDB;
import backend.User;
import backend.UserDB;
import backend.groups.Group;
import utils.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class ContentManagerFactory {
    protected final FileNames fileName;
    protected final ContentLoader contentLoader;
    protected final ContentFactory contentFactory;
    protected final User user;
    protected List<Content> content = new ArrayList<>();

    public ContentManagerFactory(FileNames fileName, ContentLoader contentLoader, ContentFactory contentFactory, User user) {
        this.fileName = fileName;
        this.contentLoader = contentLoader;
        this.contentFactory = contentFactory;
        this.user = user;
    }

    public Content searchContentByID(String contentID){
        for(Content x : content){
            if(x.getPostID().equals(contentID))
                return x;
        }
        return null;
    }

    public void addComment(String userID, String contentID, String text){
        readFromDB("All");
        Content content  = searchContentByID(contentID);
        Comment newComment = new Comment(text, IDGenerator.generateUserId(), userID);
        content.getComments().add(newComment);
        NotificationsDB.getInstance(content.getAuthorID()).addNotification(new Notification("added a comment to your post", content.getAuthorID(), userID, "new", LocalDateTime.now(), NotificationType.COMMENT.getType(), contentID));
        try {
            JSONFileWriter.writeJson(fileName.getFileName(), this.content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addLike(String userID, String contentID){
        readFromDB("All");
        Content content = searchContentByID(contentID);
        Like newLike = new Like(userID);
        content.getLikes().add(newLike);
        NotificationsDB.getInstance(content.getAuthorID()).addNotification(new Notification("liked your post", content.getAuthorID(), userID, "new", LocalDateTime.now(), NotificationType.LIKE.getType(), contentID));
        try {
            JSONFileWriter.writeJson(fileName.getFileName(), this.content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeLike(String userID, String contentID){
        readFromDB("All");
        Content content = searchContentByID(contentID);
        List<Like> likes = content.getLikes();
        Like likeToRemove = searchLikesByAuthorID(userID, contentID);

        if(likeToRemove == null)
            throw new RuntimeException("Like does not exist, cannot remove");

        content.getLikes().remove(likeToRemove);
        try {
            JSONFileWriter.writeJson(fileName.getFileName(), this.content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Like searchLikesByAuthorID(String authorID, String contentID){
        Content content = searchContentByID(contentID);
        for(Like x : content.getLikes()){
            if(x.getAuthorID().equals(authorID))
                return x;
        }
        return null;
    }

    public List<Comment> returnComments(String contentID){
        readFromDB("All");
        Content content = searchContentByID(contentID);
        return content.getComments();
    }

    public void readFromDB(String type){
        try {
            content.clear();
            List<? extends Content> allContent = contentLoader.loadContent();
            content.addAll(allContent);
            List<Content> tempContent = new ArrayList<>();

            switch (type) {
                case "Profile" -> {
                    for (Content x : content) {
                        if (user.getUserId().equals(x.getAuthorID()))
                            tempContent.add(x);
                    }
                }
                case "Friends" -> {
                    List<String> friends = user.getProfile().getFriends();
                    for (Content x : content) {
                        if (friends.contains(x.getAuthorID()))
                            tempContent.add(x);
                    }
                }
                case "All" -> tempContent = content;
                default -> throw new IOException("Unknown type input");
            }

            content = tempContent;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveToDB(List<Content> contentToSave){
        try {
            List<Content> allContent = new ArrayList<>(contentLoader.loadContent());
            System.out.println("Content count is " + allContent.size());
            allContent.addAll(contentToSave);
            JSONFileWriter.writeJson(fileName.getFileName(), allContent);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public  void removeContent(Content item){
        try {
            List<Content> allContent = new ArrayList<>(contentLoader.loadContent());
            boolean changed = allContent.remove(item);
            System.out.println("ITEM REMOVED: " + changed + " into " + fileName.getFileName() );
            JSONFileWriter.writeJson(fileName.getFileName(), allContent);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editContent(String contentID, String text, String imagePath){
        try {
            this.content = new ArrayList<>(contentLoader.loadContent());
            Content content = searchContentByID(contentID);
            if(text != null)
                content.editText(text);
            if(imagePath != null)
                content.editImagePath(imagePath);

            JSONFileWriter.writeJson(fileName.getFileName(), this.content);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    protected String addContent(Content content){
        this.content.add(content);
        System.out.println("saved to db");
        saveToDB(List.of(content));
        return content.getPostID();
    }

    public String createTextOnlyContent(String text, Group group){
        return addContent(contentFactory.createTextOnlyContent(text, user, group));
    }

    public String createImageOnlyContent(File imageFile, Group group) throws IOException{
        return addContent(contentFactory.createImageOnlyContent(imageFile, user, group));
    }

    public String createTextImageContent(String text, File imageFile, Group group) throws IOException{
        return addContent(contentFactory.createTextImageContent(text, imageFile, user, group));
    }

    public User getUser() {
        return user;
    }
}
