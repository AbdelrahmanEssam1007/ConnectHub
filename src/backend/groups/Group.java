package backend.groups;

import backend.User;
import backend.content.Content;
import utils.IDGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {

  private String groupID;
  private String groupName;
  private String groupDescription;
  private String groupPhoto;
  private String groupPrimaryAdminID;
  private List<String> groupMembersIDs;
  private List<String> groupAdminsIDs;
  private List<String> pendingMembersIDs;

  public Group(){}

  public Group(String groupName, String groupDescription, String groupPhoto) {
    this.groupID = IDGenerator.generateUserId();
    this.groupName = groupName;
    this.groupDescription = groupDescription;
    this.groupPhoto = groupPhoto;
    this.groupMembersIDs = new ArrayList<>();
    this.groupAdminsIDs = new ArrayList<>();
  }

  public String getGroupID() {
    return groupID;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getGroupDescription() {
    return groupDescription;
  }

  public void setGroupDescription(String groupDescription) {
    this.groupDescription = groupDescription;
  }

  public String getGroupPhoto() {
    return groupPhoto;
  }

  public void setGroupPhoto(String groupPhoto) {
    this.groupPhoto = groupPhoto;
  }

  public String getGroupPrimaryAdminID() {
    return groupPrimaryAdminID;
  }

  public void setGroupPrimaryAdminID(String groupPrimaryAdminID) {
    this.groupPrimaryAdminID = groupPrimaryAdminID;
  }

  public List<String> getGroupMembersIDs() {
    return groupMembersIDs;
  }

  public void setGroupMembersIDs(List<String> groupMembersIDs) {
    this.groupMembersIDs = groupMembersIDs;
  }

  public List<String> getGroupAdminsIDs() {
    return groupAdminsIDs;
  }

  public void setGroupAdminsIDs(List<String> groupAdminsIDs) {
    this.groupAdminsIDs = groupAdminsIDs;
  }

  public List<String> getPendingMembersIDs() {
    return pendingMembersIDs;
  }

  public void setPendingMembersIDs(List<String> pendingMembersIDs) {
    this.pendingMembersIDs = pendingMembersIDs;
  }

  public GroupRole getUserRole(String userID){
    if(groupMembersIDs.contains(userID))
      return GroupRole.GROUP_MEMBER;
    else if(groupAdminsIDs.contains(userID))
      return GroupRole.ADMIN;
    else if(groupPrimaryAdminID.contains(userID))
      return GroupRole.PRIMARY_ADMIN;
    else if(pendingMembersIDs.contains(userID))
      return GroupRole.PENDING_MEMBER;
    else
      return GroupRole.GUEST;
  }

  public void removeUser(String userID){
    groupMembersIDs.remove(userID);
    groupAdminsIDs.remove(userID);
    pendingMembersIDs.remove(userID);
  }

  @Override
  public String toString() {
    return groupName;
  }
}
