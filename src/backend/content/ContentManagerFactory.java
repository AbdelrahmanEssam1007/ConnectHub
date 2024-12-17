package backend.content;

import backend.User;
import backend.groups.Group;
import utils.FileNames;
import utils.IDGenerator;
import utils.JSONFileReader;
import utils.JSONFileWriter;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
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

    public void addComment(User user, String contentID, String text){
        Comment newComment = new Comment(text, IDGenerator.generateUserId(), user.getUserId());
        Content content  = searchContentByID(contentID);
        content.getComments().add(newComment);
        saveToDB(this.content);
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
