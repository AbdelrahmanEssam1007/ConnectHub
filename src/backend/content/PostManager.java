package backend.content;

import utils.FileNames;

import java.util.ArrayList;
import java.util.List;

public class PostManager extends ContentManagerFactory{
    public PostManager(){
        super(FileNames.POSTS, new PostLoader());
    }

    @Override
    public Content createContent() {
        return null;
    }
}
