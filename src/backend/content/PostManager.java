package backend.content;

import backend.User;
import utils.FileNames;

import java.util.ArrayList;
import java.util.List;

public class PostManager extends ContentManagerFactory{
    PostFactory postFactory = new PostFactory();
    public PostManager(User user, String type){
        super(FileNames.POSTS, new PostLoader(), new PostFactory(), user, type);
    }
}
