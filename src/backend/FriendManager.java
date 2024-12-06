package backend;

import java.util.ArrayList;
import java.util.List;

public class FriendManager {
  
  private static FriendManager FRIEND_MANAGER = null;
  
  private User user;
  private Profile userProfile;
  private UserDB userDB;

  private FriendManager(User user) {
    this.user = user;
    this.userProfile = user.getProfile();
    this.userDB = UserDB.getInstance();
  }
  
  public synchronized static FriendManager getInstance(User user) {
    if (FRIEND_MANAGER == null) {
      return new FriendManager(user);
    }else if (FRIEND_MANAGER.user.getUserId() != user.getUserId()) {
      return new FriendManager(user);
    }
    return FRIEND_MANAGER;
  }

  // Send a friend request to another user
  public void sendFriendRequest(User targetUser) {
    Profile targetProfile = targetUser.getProfile();

    if (userProfile.getBlocked().contains(targetUser.getUserId())) {
      System.out.println("You cannot send a friend request to a user you have blocked.");
      throw new IllegalArgumentException("You cannot send a friend request to a user you have blocked.");
    }

    if (targetProfile.getBlocked().contains(user.getUserId())) {
      System.out.println("You cannot send a friend request to a user who has blocked you.");
      throw new IllegalArgumentException("You cannot send a friend request to a user who has blocked you.");
    }

    if (targetProfile.getPending().contains(user.getUserId())) {
      System.out.println("Friend request already sent.");
      throw new IllegalArgumentException("Friend request already sent.");
    }
    
    if (userProfile.getPending().contains(targetUser.getUserId())) {
        this.acceptFriendRequest(targetUser);
        return;
    }

    targetProfile.getPending().add(user.getUserId());
    System.out.println("Friend request sent successfully.");
    userDB.SaveDB();
  }

  // Accept a friend request
  public void acceptFriendRequest(User senderUser) { // will be called by passing UserDB.getInstance ().searchUserByUserName (jlist.getindex) or smth like that
    Profile senderProfile = senderUser.getProfile();

    if (!userProfile.getPending().contains(senderUser.getUserId())) {
      System.out.println("No friend request from this user.");
      return;
    }

    userProfile.getFriends().add(senderUser.getUserId());
    userProfile.getPending().remove(senderUser.getUserId());
    senderProfile.getPending().remove(user.getUserId()); // check to remove potential bug
    senderProfile.getFriends().add(user.getUserId());
    userDB.SaveDB();
  }

  // Decline a friend request
  public void declineFriendRequest(User senderUser) {
    Profile senderProfile = senderUser.getProfile();

    if (!userProfile.getPending().contains(senderUser.getUserId())) {
      System.out.println("No friend request from this user.");
      return;
    }

    userProfile.getPending().remove(senderUser.getUserId());
    userDB.SaveDB();
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
    userDB.SaveDB();
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
    userDB.SaveDB();
  }
  
  public void removeUserFriend (User targetUser) {
      this.userProfile.getFriends().remove(targetUser.getUserId());
      targetUser.getProfile().getFriends().remove(this.user.getUserId());

//      int i;
//      for (i = 0; i < userDB.getUsers().size(); i++) {
//        if (userDB.getUsers().get(i).getUserId().equals(targetUser.getUserId())) {
//          System.out.println("Index of targetUser: " + i);
//          break;
//        }
//      }
//      userDB.getUsers().get(i).getProfile().getFriends().remove(this.user.getUserId());
//      for (i = 0; i < userDB.getUsers().size(); i++) {
//        if (userDB.getUsers().get(i).getUserId().equals(this.user.getUserId())) {
//          System.out.println("Index of targetUser: " + i);
//          break;
//        }
//      }
//      userDB.getUsers().get(i).getProfile().getFriends().remove(targetUser.getUserId());

      userDB.SaveDB();
  }

  public void refresh(){
    userDB = UserDB.getInstance();
    userDB.refreshDB();
    user = userDB.searchUserByUserId(user.getUserId());
    userProfile = user.getProfile();
  }
}
