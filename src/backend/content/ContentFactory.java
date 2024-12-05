package backend.content;

import backend.User;
import utils.ImageSaver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public abstract class ContentFactory {

    public Content createTextOnlyContent(String text, User user){
        return createContent(new ContentData(text), user);
    }

    public Content createImageOnlyContent(File imageFile, User user) throws IOException {
        String imagePath = ImageSaver.saveImage(imageFile);
        return createContent(new ContentData(null, imagePath), user);
    }

    public Content createTextImageContent(String text, File imageFile, User user) throws IOException {
        String imagePath = ImageSaver.saveImage(imageFile);
        return createContent(new ContentData(text, imagePath), user);
    }

    public abstract Content createContent(ContentData contentData, User user);
}
