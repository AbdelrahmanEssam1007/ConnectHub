package backend.groups;

import backend.User;
import backend.content.Post;

public class Admin extends GroupMember {
  private GroupContentManager groupContentManager;
  private GroupManager groupManager;
  private GroupDB groupDB;

  public Admin(User user, Group group){
    super(user, group);
    this.groupContentManager = new GroupContentManager(user);
    this.groupManager = GroupManager.getInstance();
    this.groupDB = GroupDB.getInstance();
  }

  @Override
  public void editPost(String postID, String text, String imagePath){
    groupContentManager.editContent(postID, text, imagePath);
  }

  public void removeMember(GroupMember memberToRemove){
    groupManager.removeMember(group.getGroupID(), user.getUserId(), memberToRemove.getUser().getUserId());
  }

  public void respondToMemberRequest(User userToRespondTo, boolean approve){
    groupManager.respondToJoinRequest(group.getGroupID(), user.getUserId(), userToRespondTo.getUserId(), approve);
  }

  @Override
  public void deletePost(Post post) {
    groupContentManager.removeContent(post);
  }
}
