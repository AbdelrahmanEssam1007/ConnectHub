package backend.groups;

import backend.User;

public class GroupMember {
  protected User user;
  protected Group group;
  private GroupContentManager groupContentManager;
  private GroupManager groupManager;

  public GroupMember(User user, Group group) {
    this.user = user;
    this.group = group;
    this.groupContentManager = new GroupContentManager(user);
    this.groupManager = GroupManager.getInstance();
  }

  public void addPost(){

  }

  public void deletePost(){

  }
}
