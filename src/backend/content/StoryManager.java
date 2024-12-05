/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.content;

import backend.User;
import utils.FileNames;

public class StoryManager extends ContentManagerFactory{
    public StoryManager(User user){
        super(FileNames.POSTS, new StoryLoader(), new StoryFactory(), user);
    }

    public void removeExpired(){
        readFromDB("All");
        for(Content x : content){
            if(x.expired()){
                removeContent(x);
            }
            saveToDB(content);
        }
    }
}
