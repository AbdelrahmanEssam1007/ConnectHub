package backend;

import java.time.LocalDate;

public class User {
  private String userId;
  private String email;

  private String userName;
  private String password;
  private LocalDate dateOfBirth;
  private UserStatus status;
  // will probably use hashmaps for friend lookup
  // will probably use hashmaps for blocked lookup
  //  private String profilePicture;
  //  private String coverPicture;  might be a good idea to move these into a profile management class
  //  private String bio;


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

  public UserStatus getStatus() {
    return status;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

  public void setStatus(UserStatus status) {
    this.status = status;
  }
}

