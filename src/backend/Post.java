/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.File;

/**
 *
 * @author Amr
 */
public class Post extends Content{

    public Post(){};

    public Post (String text, User user) {
        super(text, user);
    }
    
    public Post (String text, File imageFile, User user) {
        super(text, imageFile, user);
    }
    
    public Post (File imageFile, User user) {
        super(imageFile, user);
    }
}
