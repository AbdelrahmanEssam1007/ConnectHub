package backend.groups;

import backend.User;
import backend.content.Post;

import java.io.File;
import java.io.IOException;

public class GroupMember {
  protected User user;
  protected Group group;
  private GroupContentManager groupContentManager;
  private GroupManager groupManager;
  private GroupDB groupDB;

  public GroupMember(User user, Group group) {
    this.user = user;
    this.group = group;
    this.groupContentManager = new GroupContentManager(user);
    this.groupManager = GroupManager.getInstance();
    this.groupDB = GroupDB.getInstance();
  }

  public void addPost(String text, File imageFile){
    try {
      if(imageFile != null && text != null) {
        groupContentManager.createTextImageContent(text, imageFile, group);
      }
      else if(imageFile != null){
        groupContentManager.createImageOnlyContent(imageFile, group);
      }
      else if(text != null)
        groupContentManager.createTextOnlyContent(text, group);
      else
        throw new RuntimeException("Cannot add empty post");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void deletePost(Post post){
    if(post.getAuthorID().equals(user.getUserId())){
      groupContentManager.removeContent(post);
    }
    else
      throw new RuntimeException("As a member, you cannot delete a post not your own.");
  }

  public void leaveGroup(){
    groupManager.leaveGroup(group.getGroupID(), user.getUserId());
  }

  public User getUser() {
    return user;
  }

  public void editPost(String postID, String text, String imagePath){
    Post post = (Post)groupContentManager.searchContentByID(postID);
    if(post.getAuthorID().equals(user.getUserId())){
      groupContentManager.editContent(postID, text, imagePath);
    }
    else
      throw new RuntimeException("As a member, you cannot edit a post not your own");
  }
}
