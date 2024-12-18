package frontend.content;

import backend.Refreshable;
import backend.User;
import backend.content.ContentFacade;
import backend.content.StoryFacade;

public class StoriesPanel extends ContentPanel implements Refreshable {
    public StoriesPanel(User user, ContentFacade contentManager, int width, int height, String type){
        super(user, contentManager, width, height, type);
    }

    @Override
    public void refresh() {
        if(contentFacade instanceof StoryFacade){
            ((StoryFacade) contentFacade).removeExpired();
        }
        loadContent(type);
        revalidate();
        repaint();
    }
}
