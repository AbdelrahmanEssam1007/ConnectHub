package frontend;

import backend.Profile;
import backend.User;

import javax.swing.*;

public class testProfile extends JFrame {
    public testProfile() {
        //User user = new User();
        Profile profile = new Profile();
        //ProfilePanel profilePanel = new ProfilePanel(profile);
        //add(profilePanel);
        setSize(500, 200);
        setVisible(true); // Set visible after adding components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Proper window close behavior
    }

    public static void main(String[] args) {
        new testProfile();
    }
}

