package backend.content;

import backend.User;
import utils.ImageUtils;

import java.io.File;
import java.io.IOException;

public abstract class ContentFactory {

    public Content createTextOnlyContent(String text, User user){
        return createContent(new ContentData(text), user);
    }

    public Content createImageOnlyContent(File imageFile, User user) throws IOException {
        String imagePath = ImageUtils.saveImage(imageFile);
        return createContent(new ContentData(null, imagePath), user);
    }

    public Content createTextImageContent(String text, File imageFile, User user) throws IOException {
        String imagePath = ImageUtils.saveImage(imageFile);
        return createContent(new ContentData(text, imagePath), user);
    }

    public abstract Content createContent(ContentData contentData, User user);
}
