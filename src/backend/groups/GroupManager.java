package backend.groups;

import backend.User;

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

  public void deleteGroup(Group group, User user) {
    if(group.getUserRole(user.getUserId()) == GroupRole.PRIMARY_ADMIN)
      groupDB.deleteGroup(group);
    else
      throw new RuntimeException("You must be the primary admin to delete group");
  }

  public void requestToJoinGroup(String groupID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    if(!group.getGroupMembersIDs().contains(userID) &&
    !group.getGroupAdminsIDs().contains(userID) &&
    !group.getGroupPrimaryAdminID().equals(userID)){
      if(group.getPendingMembersIDs().contains(userID))
        return;
      group.getPendingMembersIDs().add(userID);
      groupDB.updateGroup(group);
    }
    else
      throw new RuntimeException("User is already in the group.");
  }

  public ArrayList<Group> getGroups() {
    return groupDB.getGroups();
  }

  public boolean isGroupMember(String groupID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    return group.getGroupPrimaryAdminID().equals(userID) ||
            group.getGroupAdminsIDs().contains(userID) ||
            group.getGroupMembersIDs().contains(userID);
  }

  public Group getGroup(String groupID) {
    return groupDB.searchGroupByID(groupID);
  }

  public GroupRole getGroupRole(String groupID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    if(group != null)
      return group.getUserRole(userID);
    return GroupRole.GUEST;
  }

  public List<String> getGroupMembers(String groupID) {
    return groupDB.searchGroupByID(groupID).getGroupMembersIDs();
  }

  public void respondToJoinRequest(String groupID, String adminID,String userID, boolean approve) {
    Group group = groupDB.searchGroupByID(groupID);
    if(group.getUserRole(adminID) == GroupRole.ADMIN || group.getUserRole(adminID) == GroupRole.PRIMARY_ADMIN){
      if(group.getPendingMembersIDs().contains(userID)){
        if(approve){
          group.getGroupMembersIDs().add(userID);
        }
        group.getPendingMembersIDs().remove(userID);
        groupDB.updateGroup(group);
      }
      else{
        throw new RuntimeException("User did not send a request");
      }
    }
    else{
      throw new RuntimeException("Only admins can respond to requests.");
    }
  }

  public void promoteToAdmin(String groupID, String adminID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    if(group.getUserRole(adminID) == GroupRole.PRIMARY_ADMIN){
      if(group.getUserRole(userID) == GroupRole.GROUP_MEMBER){
        group.getGroupMembersIDs().remove(userID);
        group.getGroupAdminsIDs().add(userID);
        groupDB.updateGroup(group);
      }
      else
        throw new RuntimeException("User is not a member, cannot promote to admin.");
    }
    else
      throw new RuntimeException("Only primary admin can promote members to admins.");
  }

  public void demoteAdmin(String groupID, String adminID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    if(group.getUserRole(adminID) == GroupRole.PRIMARY_ADMIN){
      if(group.getUserRole(userID) == GroupRole.ADMIN){
        group.getGroupAdminsIDs().remove(userID);
        group.getGroupMembersIDs().add(userID);
        groupDB.updateGroup(group);
      }
      else
        throw new RuntimeException("User is not an admin, cannot demote to member.");
    }
    else
      throw new RuntimeException("Only primary admin can demote admins.");
  }

  public void leaveGroup(String groupID, String userID) {
    Group group = groupDB.searchGroupByID(groupID);
    if(group.getGroupMembersIDs().contains(userID)){
      group.removeUser(userID);
      groupDB.updateGroup(group);
    }
    else
      throw new RuntimeException("User is not a member, cannot leave.");
  }

  public void removeMember(String groupID, String adminID, String userID){
    Group group = groupDB.searchGroupByID(groupID);
    if(group.getUserRole(adminID) == GroupRole.PRIMARY_ADMIN ||
    group.getUserRole(adminID) == GroupRole.ADMIN){
      if(group.getUserRole(userID) == GroupRole.GROUP_MEMBER){
        group.removeUser(userID);
        groupDB.updateGroup(group);
      }
      else
        throw new RuntimeException("User is not a member, cannot be removed.");
    }
    else
      throw new RuntimeException("Only admins can remove members.");
  }
}
