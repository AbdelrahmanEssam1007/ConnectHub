package backend.groups;

public class Admin extends GroupMember {
  private static Admin ADMIN = null;
  private GroupContentManager groupContentManager;
  private GroupManager groupManager;

  Admin(){
    super();
  }

  public static Admin getInstance() {
    if (ADMIN == null) {
      ADMIN = new Admin();
    }
    return ADMIN;
  }

  public void editPost(){

  }

  public void leaveGroup(){

  }

  public void removeMember(){
    // remove member from group
  }

  public void addMember(){
    // add member to group
  }

}
