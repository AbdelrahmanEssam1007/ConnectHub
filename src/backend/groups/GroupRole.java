package backend.groups;

public enum GroupRole {
    PRIMARY_ADMIN("Primary Admin"),
    ADMIN("Admin"),
    GROUP_MEMBER("Group Member"),
    PENDING_MEMBER("Pending Member");
    private final String role;

    GroupRole(String role) {
        this.role = role;
    }

  public String getRole() {
        return role;
  }
}
