package backend.groups;

import backend.User;

public class Admin extends GroupMember {
  private GroupContentManager groupContentManager;
  private GroupManager groupManager;

  Admin(User user, Group group){
    super(user, group);
  }

  public void editPost(String postID, String newContent){

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
