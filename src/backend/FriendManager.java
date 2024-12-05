package backend;

import java.util.List;

public class FriendManager {
  private User user;
  private Profile userProfile;
//  private UserDB userDB; integrate db later

  public FriendManager(User user) {
    this.user = user;
    this.userProfile = user.getProfile();
//    this.userDB = new UserDB();
  }

  // Send a friend request to another user
  public void sendFriendRequest(User targetUser) {
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
  public void acceptFriendRequest(User senderUser) { // will be called by passing UserDB.getInstance ().searchUserByUserName (jlist.getindex) or smth like that
    Profile senderProfile = senderUser.getProfile();

    if (!userProfile.getPending().contains(senderUser.getUserId())) {
      System.out.println("No friend request from this user.");
      return;
    }

    userProfile.getPending().remove(senderUser.getUserId());
    userProfile.getFriends().add(senderUser.getUserId());
    senderProfile.getFriends().add(user.getUserId());
  }

  // Decline a friend request
  public void declineFriendRequest(User senderUser) {
    Profile senderProfile = senderUser.getProfile();

    if (!userProfile.getPending().contains(senderUser.getUserId())) {
      System.out.println("No friend request from this user.");
      return;
    }

    userProfile.getPending().remove(senderUser.getUserId());
    senderProfile.getPending().remove(user.getUserId());
  }

  // Block a user
  public void blockUser(User targetUser) {
    Profile targetProfile = targetUser.getProfile();
    String targetId = targetUser.getUserId();
    if (userProfile.getBlocked().contains(targetId)) {
      System.out.println("User is already blocked.");
      return;
    }

    userProfile.getBlocked().add(targetId);
    userProfile.getFriends().remove(targetId);
    userProfile.getPending().remove(targetId);
    targetProfile.getFriends().remove(user.getUserId());
    targetProfile.getPending().remove(user.getUserId());
    
    System.out.println("User has been blocked.");
  }

  // Unblock a user
  public void unblockUser(User targetUser) {
    String targetId = targetUser.getUserId();
    if (!userProfile.getBlocked().contains(targetId)) {
      System.out.println("User is not blocked.");
      return;
    }

    userProfile.getBlocked().remove(targetId);
    System.out.println("User has been unblocked.");
  }
}
