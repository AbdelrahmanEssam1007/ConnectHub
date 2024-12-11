package backend.groups;

import backend.content.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Group {

  private String groupID;
  private String groupName;
  private String groupDescription;
  private String groupPhoto;
  private Map<String, GroupRole> groupMembers;
  private ArrayList<Content> posts;

  public Group(){
    this.groupMembers = new HashMap<>();
    this.posts = new ArrayList<>();
  }

  public String getGroupID() {
    return groupID;
  }

  public void setGroupID(String groupID) {
    this.groupID = groupID;
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

  public ArrayList<Content> getPosts() {
    return posts;
  }

  public void setPosts(ArrayList<Content> posts) {
    this.posts = posts;
  }
}
