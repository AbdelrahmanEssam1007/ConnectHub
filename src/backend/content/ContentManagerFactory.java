package backend.content;

import backend.User;
import utils.FileNames;
import utils.JSONFileReader;
import utils.JSONFileWriter;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ContentManagerFactory {
    private final FileNames fileName;
    private final ContentLoader contentLoader;
    List<Content> content = new ArrayList<>();

    public ContentManagerFactory(FileNames fileName, ContentLoader contentLoader) {
        this.fileName = fileName;
        this.contentLoader = contentLoader;
    }

    public void readFromDB(){
        try {
            content.clear();
            List<? extends Content> allContent = contentLoader.loadContent();
            content.addAll(allContent);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveToDB(){
        try {
            List<Content> allContent = new ArrayList<>(contentLoader.loadContent());
            allContent.addAll(content);
            JSONFileWriter.writeJson(fileName.getFileName(), allContent);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /*TODO: remove*/
    public  void removeContent(Content item, User user){
        /*
        * Check userID removing is same as userID of post
        * Search for item in list of content
        * remove from list
        * remove save to db
        * */
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    protected void addContent(Content content){
        this.content.add(content);
    }
    /*TODO: implement createContent*/
    public abstract Content createContent();
}
