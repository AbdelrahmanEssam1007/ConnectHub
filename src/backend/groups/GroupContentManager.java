package backend.groups;

import backend.User;
import backend.content.Content;
import backend.content.ContentManagerFactory;
import backend.content.PostFactory;
import backend.content.PostLoader;
import utils.FileNames;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupContentManager extends ContentManagerFactory {
    public GroupContentManager(User user){
        super(FileNames.POSTS, new PostLoader(), new PostFactory(), user);
    }

    @Override
    public void readFromDB(String groupID) {
        try {
            content.clear();
            List<? extends Content> allContent = contentLoader.loadContent();
            content.addAll(allContent);
            List<Content> tempContent = new ArrayList<>();

            for(Content x : content){
                if(x.getGroupID() == null)
                    continue;
                else if(x.getGroupID().equals(groupID))
                    tempContent.add(x);
            }

            content = tempContent;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
