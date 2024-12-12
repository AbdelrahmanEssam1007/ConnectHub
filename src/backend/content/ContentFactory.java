package backend.content;

import backend.User;
import backend.groups.Group;
import utils.ImageUtils;

import java.io.File;
import java.io.IOException;

public abstract class ContentFactory {

    public Content createTextOnlyContent(String text, User user, Group group){
        return createContent(new ContentData(text), user, group);
    }

    public Content createImageOnlyContent(File imageFile, User user, Group group) throws IOException {
        String imagePath = ImageUtils.saveImage(imageFile);
        return createContent(new ContentData(null, imagePath), user, group);
    }

    public Content createTextImageContent(String text, File imageFile, User user, Group group) throws IOException {
        String imagePath = ImageUtils.saveImage(imageFile);
        return createContent(new ContentData(text, imagePath), user, group);
    }

    public abstract Content createContent(ContentData contentData, User user, Group group);
}
