package backend.groups;

import utils.FileNames;
import utils.JSONFileReader;
import utils.JSONFileWriter;

import java.util.ArrayList;
import java.util.List;

public class GroupDB {

  List<Group> groups;
  private static final GroupDB GROUPDB = new GroupDB();

  GroupDB() {
    groups = new ArrayList<>();
    readFromDB();
  }

  public static GroupDB getInstance() {
    return GROUPDB;
  }

  public void readFromDB(){
    try {
      groups.clear();
      List<Group> allGroups = JSONFileReader.readJson(FileNames.GROUPS.getFileName(), Group.class);
      groups.addAll(allGroups);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void saveToDB(){
    try {
      JSONFileWriter.writeJson(FileNames.GROUPS.getFileName(), groups);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void createGroup(Group group) {
    groups.add(group);
    saveToDB();
  }

  public void deleteGroup(Group group) {
    groups.remove(group);
    saveToDB();
  }

  public Group searchGroupByID(String groupID) {
    for (Group group : groups) {
      if (group.getGroupID().equals(groupID)) {
        return group;
      }
    }
    return null;
  }

  public Group searchGroupByName(String groupName) {
    for (Group group : groups) {
      if (group.getGroupName().equals(groupName)) {
        return group;
      }
    }
    return null;
  }

  public void updateGroup(Group group) {
    for (Group g : groups) {
      if (g.getGroupID().equals(group.getGroupID())) {
        g.setGroupName(group.getGroupName());
        g.setGroupDescription(group.getGroupDescription());
        g.setGroupPhoto(group.getGroupPhoto());
        g.setGroupPrimaryAdminID(group.getGroupPrimaryAdminID());
        g.setGroupAdminsIDs(group.getGroupAdminsIDs());
        g.setGroupMembersIDs(group.getGroupMembersIDs());
      }
    }
   saveToDB();
  }

  public ArrayList<Group> getGroups() {
    return new ArrayList<>(groups);
  }

}
