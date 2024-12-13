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

  public void removeMember(User userToRemove){
    groupManager.removeMember(group.getGroupID(), user.getUserId(), userToRemove.getUserId());
  }

  public void respondToMemberRequest(User userToRespondTo, boolean approve){
    groupManager.respondToJoinRequest(group.getGroupID(), user.getUserId(), userToRespondTo.getUserId(), approve);
  }

}
