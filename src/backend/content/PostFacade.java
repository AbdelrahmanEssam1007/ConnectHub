package backend.content;

import backend.User;
import utils.FileNames;

public class PostFacade extends ContentFacade {
    public PostFacade(User user){
        super(FileNames.POSTS, new PostLoader(), new PostFactory(), user);
    }
}
