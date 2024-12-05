package frontend.content;

import backend.User;
import backend.content.ContentManagerFactory;

public class StoriesPanel extends ContentPanel{
    public StoriesPanel(User user, ContentManagerFactory contentManager, int width, int height){
        super(user, contentManager, width, height);
    }
}
