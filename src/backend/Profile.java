package backend;

import backend.groups.Group;
import backend.groups.GroupRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {

  private List<String> friends;
  private List<String> blocked;
  private List<String> pending;
  private Map<String, GroupRole> groups;
  private String profilePhoto;
  private String coverPhoto;
  private String bio;

  public Profile() {
    this.friends = new ArrayList<>();
    this.blocked = new ArrayList<>();
    this.pending = new ArrayList<>();
    this.groups = new HashMap<>();
  }

  public Map<String, GroupRole> getGroups() {
    return groups;
  }

  public void setGroups(Map<String, GroupRole> groups) {
    this.groups = groups;
  }

  public List<String> getFriends() {
    return friends;
  }

  public void setFriends(List<String> friends) {
    this.friends = friends;
  }

  public List<String> getBlocked() {
    return blocked;
  }

  public void setBlocked(List<String> blocked) {
    this.blocked = blocked;
  }

  public List<String> getPending() {
    return pending;
  }

  public void setPending(List<String> pending) {
    this.pending = pending;
  }

  public String getProfilePhoto() {
    return profilePhoto;
  }

  public void setProfilePhoto(String profilePhoto) {
    this.profilePhoto = profilePhoto;
  }

  public String getCoverPhoto() {
    return coverPhoto;
  }

  public void setCoverPhoto(String coverPhoto) {
    this.coverPhoto = coverPhoto;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }
}
