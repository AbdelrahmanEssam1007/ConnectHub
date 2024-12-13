package backend.groups;

import backend.User;
import backend.content.ContentManagerFactory;
import backend.content.Post;

import java.io.File;

public class Admin extends GroupMember {
  private GroupContentManager groupContentManager;
  private GroupManager groupManager;
  private GroupDB groupDB;

  Admin(User user, Group group){
    super(user, group);
    this.groupContentManager = new GroupContentManager(user);
    this.groupManager = GroupManager.getInstance();
    this.groupDB = GroupDB.getInstance();
  }

  public void editPost(String postID, String text, String imagePath){
    Post post = (Post)groupContentManager.searchContentByID(postID);
    if(text != null)
      post.editText(text);
    if(imagePath != null)
      post.editImagePath(imagePath);
  }

  public void removeMember(){
    // remove member from group
  }

  public void addMember(){
    // add member to group
  }

}
