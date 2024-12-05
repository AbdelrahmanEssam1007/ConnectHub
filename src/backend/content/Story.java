/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.content;

import java.io.File;
import java.time.LocalDateTime;

import backend.User;
import utils.Constants;

public class Story extends Content implements Constants{
    private LocalDateTime creationTime;
    
    public Story (String text, User user) {
        super(text, user);
        creationTime = LocalDateTime.now();
    }
    
    public Story (String text, File imageFile, User user) {
        super(text, imageFile, user);
        creationTime = LocalDateTime.now();

    }
    
    public Story (File imageFile, User user) {
        super(imageFile, user);
        creationTime = LocalDateTime.now();
    }
    
    public boolean isExpired(){
        return creationTime.plusMinutes(STORY_EXPIRY).isBefore(LocalDateTime.now());
    }
}
