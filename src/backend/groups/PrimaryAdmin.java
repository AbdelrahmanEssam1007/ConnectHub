package backend.groups;

import backend.User;

public class PrimaryAdmin extends Admin {
  private GroupContentManager groupContentManager;
  private GroupManager groupManager;
  private GroupDB groupDB;

  public PrimaryAdmin(User user, Group group){
    super(user, group);
    this.groupContentManager = new GroupContentManager(user);
    this.groupManager = GroupManager.getInstance();
    this.groupDB = GroupDB.getInstance();
  }

  public void demoteAdmin(Admin admin){
    groupManager.demoteAdmin(group.getGroupID(), user.getUserId(), admin.getUser().getUserId());
  }

  public void promoteAdmin(GroupMember member){
    groupManager.promoteToAdmin(group.getGroupID(), user.getUserId(), member.getUser().getUserId());
  }

  public void deleteGroup(){
    groupManager.deleteGroup(group, user);
  }

}
