package backend.content;

import utils.FileNames;
import utils.JSONFileReader;

import java.io.IOException;
import java.util.List;

public class StoryLoader implements ContentLoader {
    @Override
    public List<Story> loadContent() throws IOException {
        return JSONFileReader.readJson(FileNames.STORIES.getFileName(), Story.class);
    }
}
