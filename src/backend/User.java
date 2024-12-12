package backend;

import utils.IDGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
  private String userId;
  private String email;
  private String userName;
  private String password;
  private LocalDate dateOfBirth;
  private boolean status;
  private Profile profile;
  private List<String> groupIDS = new ArrayList<>();

  public User() {
      this.userId = IDGenerator.generateUserId();
      profile = new Profile();
  }

  public List<String> getGroupIDS() {
    return groupIDS;
  }

  public void setGroupIDS(List<String> groupIDS) {
    this.groupIDS = groupIDS;
  }

  public void addGroupID(String groupID){
    this.groupIDS.add(groupID);
  }

  public String getUserId() {
    return userId;
  }

  public String getEmail() {
    return email;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public boolean getStatus() {
    return status;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }
}

