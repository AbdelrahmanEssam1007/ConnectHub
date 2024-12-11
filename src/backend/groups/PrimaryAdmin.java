package backend.groups;

public class PrimaryAdmin extends Admin {

  private static PrimaryAdmin PRIMARY_ADMIN = null;

  private PrimaryAdmin(){
    super();
  }

  public static PrimaryAdmin getInstance() {
    if (PRIMARY_ADMIN == null) {
      PRIMARY_ADMIN = new PrimaryAdmin();
    }
    return PRIMARY_ADMIN;
  }

  public void demoteAdmin(){
    // remove admin from group
  }

  public void promoteAdmin(){
    // add admin to group
  }

  public void deleteGroup(){
    // delete group
  }

}
