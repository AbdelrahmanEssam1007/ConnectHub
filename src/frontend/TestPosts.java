package frontend;

import backend.User;

import javax.swing.*;

public class TestPosts extends JFrame{
    public TestPosts() {
        User user = new User();
        PostsPanel testPanel = new PostsPanel(user,700,800);
        setVisible(true);
        add(testPanel);
        setSize(700,800);
    }

    public static void main(String[] args) {
        new TestPosts();
    }
}
