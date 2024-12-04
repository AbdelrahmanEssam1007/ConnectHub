package backend;

import java.util.List;

public class FriendManager {
  private User user;
  private UserDB userDB;

  public FriendManager(User user) {
    this.user = user;
    this.userDB = new UserDB();
  }

  // Send a friend request to another user
  public void sendFriendRequest(User targetUser) {
    Profile userProfile = user.getProfile();
    Profile targetProfile = targetUser.getProfile();

    if (userProfile.getBlocked().contains(targetUser.getUserId())) {
      System.out.println("You cannot send a friend request to a user you have blocked.");
      return;
    }


    if (targetProfile.getBlocked().contains(user.getUserId())) {
      System.out.println("You are blocked by this user.");
      return;
    }

    if (targetProfile.getPending().contains(user.getUserId())) {
      System.out.println("Friend request already sent.");
      return;
    }

    targetProfile.getPending().add(user.getUserId());
    System.out.println("Friend request sent successfully.");
  }

  // Accept a friend request
  public void acceptFriendRequest(String senderId) {
    List<String> pending = user.getProfile().getPending();
    if (!pending.contains(senderId)) {
      System.out.println("No friend request from this user.");
      return;
    }

    pending.remove(senderId);
    user.getProfile().getFriends().add(senderId);
    
    User targetUser = userDB.searchUserByUserId(senderId);
    
    targetUser.getProfile().getFriends().add(this.user.getUserId());
    
    System.out.println("Friend request accepted.");
  }

  // Decline a friend request
  public void declineFriendRequest(String senderId) {
    List<String> pending = user.getProfile().getPending();
    if (!pending.contains(senderId)) {
      System.out.println("No friend request from this user.");
      return;
    }

    pending.remove(senderId);
    System.out.println("Friend request declined.");
  }

  // Block a user
  public void blockUser(String targetId) {
    Profile profile = user.getProfile();
    if (profile.getBlocked().contains(targetId)) {
      System.out.println("User is already blocked.");
      return;
    }

    profile.getBlocked().add(targetId);
    profile.getFriends().remove(targetId);
    profile.getPending().remove(targetId);
    
    System.out.println("User has been blocked.");
  }

  // Unblock a user
  public void unblockUser(String targetId) {
    List<String> blocked = user.getProfile().getBlocked();
    if (!blocked.contains(targetId)) {
      System.out.println("User is not blocked.");
      return;
    }

    blocked.remove(targetId);
    
    System.out.println("User has been unblocked.");
  }
}
