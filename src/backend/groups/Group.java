package backend.groups;

import backend.content.Content;
import utils.IDGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Group {

  private String groupID;
  private String groupName;
  private String groupDescription;
  private String groupPhoto;
  private Map<String, GroupRole> groupMembers;

  public Group(){}

  public Group(String groupName, String groupDescription, String groupPhoto) {
    this.groupID = IDGenerator.generateUserId();
    this.groupName = groupName;
    this.groupDescription = groupDescription;
    this.groupPhoto = groupPhoto;
    this.groupMembers = new HashMap<>();
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

  public Map<String, GroupRole> getGroupMembers() {
    return groupMembers;
  }

  public void setGroupMembers(Map<String, GroupRole> groupMembers) {
    this.groupMembers = groupMembers;
  }
}
