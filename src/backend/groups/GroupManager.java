package backend.groups;

import java.util.ArrayList;

public class GroupManager {

  private GroupDB groupDB;
  private static GroupManager GROUP_MANAGER;

  private GroupManager() {
    groupDB = new GroupDB();
  }

  public static GroupManager getInstance() {
    if (GROUP_MANAGER == null) {
      GROUP_MANAGER = new GroupManager();
    }
    return GROUP_MANAGER;
  }

  public Group createGroup(String name, String description) {
    return groupDB.createGroup(name, description);
  }

  public void deleteGroup() {
    // delete group
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
