package backend.groups;

import backend.User;
import backend.content.ContentManagerFactory;
import backend.content.PostFactory;
import backend.content.PostLoader;
import utils.FileNames;

public class GroupContentManager extends ContentManagerFactory {
    public GroupContentManager(User user){
        super(FileNames.GROUP_POSTS, new GroupPostLoader(), new PostFactory(), user);
    }
}
