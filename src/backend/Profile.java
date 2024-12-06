package backend;

import java.util.ArrayList;
import java.util.List;

public class Profile {

  private List<String> friends;
  private List<String> blocked;
  private List<String> pending;
  private String profilePhoto;
  private String coverPhoto;
  private String bio;

  public Profile() {
    this.friends = new ArrayList<>();
    this.blocked = new ArrayList<>();
    this.pending = new ArrayList<>();
    //set UID, state friend, pendingr, pendings, blocked
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
