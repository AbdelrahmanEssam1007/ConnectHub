package frontend;

import backend.User;
import backend.content.PostManager;
import frontend.content.PostsPanel;

import javax.swing.*;

public class TestPosts extends JFrame{
    public TestPosts() {
        User user = new User();
        PostManager postManager = new PostManager(user);
        postManager.createTextOnlyContent("Hello World");
        postManager.createTextOnlyContent("Hello My World");
        postManager.saveToDB();
        PostsPanel testPanel = new PostsPanel(user, postManager, 800, 600);
        setVisible(true);
        add(testPanel);
        setSize(700,800);
    }

    public static void main(String[] args) {
        new TestPosts();
    }
}
