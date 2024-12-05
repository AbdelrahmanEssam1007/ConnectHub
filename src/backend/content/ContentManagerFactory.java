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

    public void readFromDB(){
        try {
            content.clear();
            List<? extends Content> allContent = contentLoader.loadContent();
            content.addAll(allContent);
            List<String> friends =  user.getProfile().getFriends();
            List<Content> tempContent = new ArrayList<>();
            for(Content x : content){
                if(friends.contains(x.getAuthorID()))
                    tempContent.add(x);
            }
            content = tempContent;
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

    public  void removeContent(Content item){
        if(!user.getUserId().equals(item.getAuthorID())){
            JOptionPane.showMessageDialog(null,
                    "You don't have permission to remove this content.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        content.remove(item);
        saveToDB();
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    protected void addContent(Content content){
        this.content.add(content);
        saveToDB();
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
}
