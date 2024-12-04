package backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

  private List<User> users;

  public UserDB() {
    users = new ArrayList<>();
  }

  public List<User> getUsers() {
    return new ArrayList<>(users);
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
