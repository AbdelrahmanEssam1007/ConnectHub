package backend.content;

import java.io.IOException;
import java.util.List;

public interface ContentLoader {
    List<? extends Content> loadContent() throws IOException;

}
