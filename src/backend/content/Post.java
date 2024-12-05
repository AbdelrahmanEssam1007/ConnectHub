/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.content;

import backend.User;

import java.io.File;
import java.time.LocalDateTime;

/**
 *
 * @author Amr
 */
public class Post extends Content{

    public Post (ContentData contentData, LocalDateTime postDate, String postID, String authorID, String username) {
        super(contentData, postDate, postID, authorID, username);
    }

}
