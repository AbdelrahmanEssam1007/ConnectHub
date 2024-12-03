package backend;

import utils.UserIDGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
  private String userId;
  private static int numID = 0;
  private String email;
  private String userName;
  private String password;
  private String dateOfBirth;
  private boolean status;

  public User() {
      this.userId = UserIDGenerator.generateUserId();
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

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public boolean getStatus() {
    return status;
  }

//  public void setUserId(String userId) {
//    this.userId = userId;
//  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

}

