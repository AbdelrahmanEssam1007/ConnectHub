package frontend;

import backend.User;
import backend.UserDB;
import utils.FileNames;
import utils.JSONFileReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import static utils.SimpleHash.checkPassword;

public class SignInPage extends JFrame {
    private JPanel SignInPanel;
    private JTextField usernameTF;
    private JPasswordField passTF;
    private JButton loginButton;
    private JButton quitButton;
    private JButton backButton;
    private static SignInPage pageInstance = null;

    public static synchronized SignInPage getInstance(){
        if(pageInstance == null)
            pageInstance = new SignInPage();
        return pageInstance;
    }

    private SignInPage() {
        setContentPane(SignInPanel);
        setSize(new Dimension(640, 480));
        setLocationRelativeTo(null);
        setTitle("Sign In");
        setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = usernameTF.getText();
                String password = passTF.getText();
                User user;
                UserDB userDB = new UserDB();
                try {
                    userDB.setUsers(JSONFileReader.readJson(FileNames.USERS.getFileName(), User.class));
                    user = userDB.searchUserByEmail(email);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else if(user != null && checkPassword(password, user.getPassword())) {
                    System.out.println(user.getUserName());
                    System.out.println("Login successful");
                    setVisible(false);
                    dispose();
                    //new Main(User)
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                    passTF.setText("");
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    Main main = Main.getInstance();
                    main.setVisible(true);
                });
                dispose();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        getRootPane().setDefaultButton(loginButton);
    }
}
