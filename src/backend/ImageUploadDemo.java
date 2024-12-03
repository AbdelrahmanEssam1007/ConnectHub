package backend;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ImageUploadDemo extends JFrame {

    private JLabel imageLabel;

    public ImageUploadDemo() {
        // Set up the frame
        setTitle("Image Upload Demo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label to display the image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Add label to the frame
        add(imageLabel, BorderLayout.CENTER);

        // Create an "Upload Image" button
        JButton uploadButton = new JButton("Upload Image");
        uploadButton.addActionListener(e -> openImageDialog());

        // Add the button to the frame
        add(uploadButton, BorderLayout.SOUTH);
    }

    // Open the file chooser dialog and display the selected image
    private void openImageDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an image file");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
        }
        
        
    }

    // Load the image from the file and display it
    private void displayImage(File imageFile) {
        try {
            // Load the image file
            BufferedImage img = ImageIO.read(imageFile);

            // Create an ImageIcon from the image
            ImageIcon icon = new ImageIcon(img);

            // Resize image to fit within the label size
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);

            // Set the image icon to the label
            imageLabel.setIcon(icon);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
