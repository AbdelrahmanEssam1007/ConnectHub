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

    public Story(){};
    public Story (ContentData contentData, LocalDateTime postDate, String postID, String authorID, String groupID, String username) {
        super(contentData, postDate, postID, authorID, groupID, username);
    }

    @Override
    public boolean expired(){
        return getPostDate().plusSeconds(STORY_EXPIRY).isBefore(LocalDateTime.now());
    }
}
