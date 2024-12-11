package backend.groups;

import java.util.ArrayList;

public class GroupDB {

  public ArrayList<Group> getGroups() {
    return new ArrayList<>();
  }

  public Group createGroup(String name, String description) {
    return new Group();
  }
}
