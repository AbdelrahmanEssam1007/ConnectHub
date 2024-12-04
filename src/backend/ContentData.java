/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

final class ContentData {
    private String imagePath = null;
    private String text = null;

    public ContentData(){};

    public ContentData(String text) {
        this.text = text;
    }

    public ContentData(String text, String imagePath) {
        this.text = text;
        this.imagePath = imagePath;
    }

    public ContentData(String imagePath, boolean imageOnly) {
        if(imageOnly)
            this.imagePath = imagePath;
        else
            JOptionPane.showMessageDialog(null, "Uploading image only incorrectly.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public BufferedImage loadImage(){
        try {
            if(imagePath != null)
                return ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            UIManager.put("OptionPane.minimumSize",new Dimension(300,200));
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
