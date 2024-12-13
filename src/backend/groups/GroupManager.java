package backend.groups;

import java.util.ArrayList;
import java.util.List;
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
    group.setGroupPrimaryAdminID(userID);
    groupDB.createGroup(group);
  }

  public void deleteGroup( Group group) {
    groupDB.deleteGroup(group);
  }

  public void requestToJoinGroup(String groupID, String userID) {
    groupDB.searchGroupByID(groupID).getPendingMembersIDs().add(userID);
    groupDB.saveToDB();
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

  public List<String> getGroupMembers(String groupID) {
    return groupDB.searchGroupByID(groupID).getGroupMembersIDs();
  }

  public void respondToJoinRequest(String groupID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    if(group.getPendingMembersIDs().contains(userID)){
      group.getGroupMembersIDs().add(userID);
      group.getPendingMembersIDs().remove(userID);
    }
    else
      throw new RuntimeException("User did not send join request.");
    groupDB.saveToDB();
  }

  public void promoteToAdmin(String groupID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    if(group.getGroupMembersIDs().contains(userID)){
      group.getGroupMembersIDs().remove(userID);
      group.getGroupAdminsIDs().add(userID);
    }
    else
      throw new RuntimeException("User is not a member cannot promote to admin.");
    groupDB.saveToDB();
  }

  public void demoteAdmin(String groupID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    if(group.getGroupAdminsIDs().contains(userID)){
      group.getGroupMembersIDs().add(userID);
      group.getGroupAdminsIDs().remove(userID);
    }
    else
      throw new RuntimeException("User is not an admin, cannot demote him.");
    groupDB.saveToDB();
  }

  public void leaveGroup(String groupID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    if(group.getGroupMembersIDs().contains(userID)){
      group.getGroupMembersIDs().remove(userID);
    }
    else
      throw new RuntimeException("User is not a member, cannot leave.");
    groupDB.saveToDB();
  }
}
