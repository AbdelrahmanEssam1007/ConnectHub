/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend.content;

import backend.Refreshable;
import backend.content.*;
import backend.User;

/**
 *
 * @author Amr
 */
public class PostsPanel extends ContentPanel implements Refreshable {
    public PostsPanel(User user, ContentManagerFactory contentManager, int width, int height){
        super(user, contentManager, width, height);
    }

    @Override
    public void refresh() {
        loadContent();
        revalidate();
        repaint();
    }
}
