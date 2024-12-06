package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils implements Constants{
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

        return destinationFile.getPath();
    }

    /*Returns scaled image and keeps AR*/
    public static ImageIcon scaleImageIcon(String imagePath, int imageWidth){
        ImageIcon imageIcon = new ImageIcon(imagePath);
        int imageHeight = imageIcon.getIconHeight() * imageWidth / imageIcon.getIconWidth();
        Image scaledIcon = imageIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledIcon);
    }

    /*Image uploader*/
    public static File uploadImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an image file");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else if(result == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null, "Error uploading image.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return null;
    }

}
