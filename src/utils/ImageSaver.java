package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSaver implements Constants{
    public static String saveImage(File imageFile) throws IOException {
        BufferedImage temp = ImageIO.read(imageFile);

        /*Converts image into JPG friendly format in case it is in other extension ex:png*/
        BufferedImage convertedImage = new BufferedImage(
                temp.getWidth(),
                temp.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        /*Draws original image on of converted image*/
        Graphics2D g = convertedImage.createGraphics();
        g.drawImage(temp, 0, 0, null);
        g.dispose();

        /*images/ directory is made if not already made*/
        File destinationDir = new File(IMAGES_DIRECTORY);
        if (!destinationDir.exists()) {
            destinationDir.mkdir();
        }

        String fileName = imageFile.getName().replaceAll("\\..*$", "") + ".jpg";
        File destinationFile = new File(destinationDir, fileName);
        ImageIO.write(convertedImage, "jpg", destinationFile);

        return destinationFile.getAbsolutePath();
    }
}
