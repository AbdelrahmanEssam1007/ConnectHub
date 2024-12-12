package backend.groups;

import java.util.ArrayList;

public class GroupManager {

  private GroupDB groupDB;
  private static GroupManager GROUP_MANAGER;

  private GroupManager() {
    groupDB = GroupDB.getInstance();
  }

  public static GroupManager getInstance() {
    if (GROUP_MANAGER == null) {
      GROUP_MANAGER = new GroupManager();
    }
    return GROUP_MANAGER;
  }

  public void createGroup(String name, String description, String photo) {
    groupDB.createGroup(new Group(name, description, photo));
  }

  public void deleteGroup( Group group) {
    groupDB.deleteGroup(group);
  }

  public void requestToJoinGroup() {
    // request to join group
  }

  public ArrayList<Group> getGroups() {
    return groupDB.getGroups();
  }

  public boolean isGroupMember() {
    return true;
  }

  public Group getGroup() {
    return new Group();
  }

  public GroupRole getGroupRole() {
    return GroupRole.GROUP_MEMBER;
  }

  public ArrayList<String> getGroupMembers() {
    return new ArrayList<String>();
  }

  public void respondToJoinRequest() {
    // respond to join request
  }

  public void promoteToAdmin() {
    // promote to admin
  }

  public void demoteAdmin() {
    // demote admin
  }

  public void leaveGroup() {
    // leave group
  }


}
