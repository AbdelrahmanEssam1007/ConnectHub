package frontend.content;

import backend.Refreshable;
import backend.User;
import backend.content.ContentManagerFactory;
import backend.content.StoryFactory;
import backend.content.StoryManager;

public class StoriesPanel extends ContentPanel implements Refreshable {
    public StoriesPanel(User user, ContentManagerFactory contentManager, int width, int height, String type){
        super(user, contentManager, width, height, type);
    }

    @Override
    public void refresh() {
        if(contentManagerFactory instanceof StoryManager){
            ((StoryManager)contentManagerFactory).removeExpired();
        }
        loadContent(type);
        revalidate();
        repaint();
    }
}
