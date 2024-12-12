package backend.Notifications;

import utils.IDGenerator;

import java.time.LocalDateTime;
import java.util.Date;

public class Notification {
    private String notificationID;
    private String message;
    private String userID;
    private String senderUserID;
    private String status;
    private LocalDateTime date;
    private String type;

    public Notification(String message, String userID, String senderUserID, String status, LocalDateTime date, String type) {
        this.notificationID = IDGenerator.generateUserId();
        this.message = message;
        this.userID = userID;
        this.senderUserID = senderUserID;
        this.status = status;
        this.date = date;
        this.type = type;
    }

    public Notification() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setSenderUserID(String targetUserID) {
        this.senderUserID = targetUserID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public String getUserID() {
        return userID;
    }

    public String getSenderUserID() {
        return senderUserID;
    }

    public String getNotificationID() {
        return notificationID;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
