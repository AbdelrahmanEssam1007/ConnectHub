package backend.content;

import backend.User;
import utils.FileNames;
import utils.JSONFileReader;
import utils.JSONFileWriter;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ContentManagerFactory {
    private final FileNames fileName;
    private final ContentLoader contentLoader;
    private final ContentFactory contentFactory;
    private final User user;
    List<Content> content = new ArrayList<>();

    public ContentManagerFactory(FileNames fileName, ContentLoader contentLoader, ContentFactory contentFactory,
                                 User user) {
        this.fileName = fileName;
        this.contentLoader = contentLoader;
        this.contentFactory = contentFactory;
        this.user = user;
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
            JSONFileWriter.writeJson(fileName.getFileName(), allContent);
            System.out.println("Content Removed: " + contentLoader +" Changed " + changed);
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

    protected void addContent(Content content){
        this.content.add(content);
        System.out.println("saved to db");
        saveToDB(List.of(content));
    }

    public void createTextOnlyContent(String text){
        addContent(contentFactory.createTextOnlyContent(text, user));
    }

    public void createImageOnlyContent(File imageFile) throws IOException{
        addContent(contentFactory.createImageOnlyContent(imageFile, user));
    }

    public void createTextImageContent(String text, File imageFile) throws IOException{
        addContent(contentFactory.createTextImageContent(text, imageFile, user));
    }

    public User getUser() {
        return user;
    }
}
