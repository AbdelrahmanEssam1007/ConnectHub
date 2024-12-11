package backend.groups;

public class GroupMember {
  private static GroupMember GROUP_MEMBER;
  private GroupContentManager groupContentManager;
  private GroupManager groupManager;
  public static GroupMember getInstance() {
    if (GROUP_MEMBER == null) {
      GROUP_MEMBER = new GroupMember();
    }
    return GROUP_MEMBER;
  }

  public void addPost(){

  }

  public void deletePost(){

  }

  public void editPost(){

  }

  public void leaveGroup(){

  }
}
