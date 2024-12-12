package backend.groups;

import java.util.ArrayList;
import java.util.Map;

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

  public void createGroup(String name, String description, String photo, String userID) {
    Group group = new Group(name, description, photo);
    Map<String, GroupRole> groupMembers = group.getGroupMembers();
    groupMembers.put(userID, GroupRole.PRIMARY_ADMIN);
    groupDB.createGroup(group);
  }

  public void deleteGroup( Group group) {
    groupDB.deleteGroup(group);
  }

  public void requestToJoinGroup() {

  }

  public ArrayList<Group> getGroups() {
    return groupDB.getGroups();
  }

  public boolean isGroupMember() {
    return true;
  }

  public Group getGroup(String groupID) {
    return groupDB.searchGroupByID(groupID);
  }

  public GroupRole getGroupRole() {
    return GroupRole.GROUP_MEMBER;
  }

  public ArrayList<String> getGroupMembers(String groupID) {
    return (ArrayList<String>) groupDB.searchGroupByID( groupID).getGroupMembers();
  }

  public void respondToJoinRequest(String groupID, String userID) {
    groupDB.searchGroupByID(groupID).getGroupMembers().put(userID, GroupRole.GROUP_MEMBER);
  }

  public void promoteToAdmin(String groupID, String userID) {
    groupDB.searchGroupByID(groupID).getGroupMembers().put(userID, GroupRole.ADMIN);
  }

  public void demoteAdmin(String groupID, String userID) {
    groupDB.searchGroupByID(groupID).getGroupMembers().put(userID, GroupRole.GROUP_MEMBER);
  }

  public void leaveGroup(String groupID, String userID) {
    groupDB.searchGroupByID(groupID).getGroupMembers().remove(userID);
  }
}
