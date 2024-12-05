/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.content;

import utils.FileNames;

public class StoryManager extends ContentManagerFactory{
    public StoryManager(){
        super(FileNames.POSTS, new StoryLoader());
    }

    @Override
    public Content createContent() {
        return null;
    }
}
