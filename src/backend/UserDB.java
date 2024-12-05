package backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.FileNames;
import utils.JSONFileReader;
import utils.JSONFileWriter;

public class UserDB {

  private List<User> users;
  private static final UserDB USERDB = new UserDB();

  private UserDB() {
      try {
          this.setUsers(JSONFileReader.readJson(FileNames.USERS.getFileName(), User.class));
      } catch (IOException ex) {
          Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public static UserDB getInstance () {
      return USERDB;
  }

  public List<User> getUsers() {
    return new ArrayList<>(users);
  }

  public void SaveDB() {
      try {
        JSONFileWriter.writeJson(FileNames.USERS.getFileName(), users);
      } catch (IOException ex) {
          Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public void addUser(User user) {
    users.add(user);
  }

  public User searchUserByEmail(String email) {
    for (User user : users) {
      if (user.getEmail().equals(email)) {
        return user;
      }
    }
    return null;
  }

  public User searchUserByUserName(String userName) {
    for (User user : users) {
      if (user.getUserName().equals(userName)) {
        return user;
      }
    }
    return null;
  }

  public User searchUserByUserId(String userId) {
    for (User user : users) {
      if (user.getUserId().equals(userId)) {
        return user;
      }
    }
    return null;
  }

}
