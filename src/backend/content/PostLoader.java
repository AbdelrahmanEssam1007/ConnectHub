package backend.content;

import utils.FileNames;
import utils.JSONFileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PostLoader implements ContentLoader {
    @Override
    public List<Post> loadContent() throws IOException {
        return JSONFileReader.readJson(FileNames.POSTS.getFileName(), Post.class);
    }
}
