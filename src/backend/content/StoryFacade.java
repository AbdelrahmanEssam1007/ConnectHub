/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.content;

import backend.User;
import utils.FileNames;

public class StoryFacade extends ContentFacade {
    public StoryFacade(User user){
        super(FileNames.STORIES, new StoryLoader(), new StoryFactory(), user);
    }

    public void removeExpired(){
        readFromDB("All");
        for(Content x : content){
            if(x.expired()){
                System.out.println("Sent x");
                removeContent(x);
            }
        }
    }
}
