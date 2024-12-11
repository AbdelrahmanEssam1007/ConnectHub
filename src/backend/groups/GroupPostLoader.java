package backend.groups;

import backend.content.ContentLoader;
import backend.content.Post;
import utils.FileNames;
import utils.JSONFileReader;

import java.io.IOException;
import java.util.List;

public final class GroupPostLoader implements ContentLoader {
    @Override
    public List<Post> loadContent() throws IOException {
        return JSONFileReader.readJson(FileNames.GROUP_POSTS.getFileName(), Post.class);
    }
}
