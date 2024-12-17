package backend.Notifications;

import utils.Constants;
import utils.JSONFileReader;
import utils.JSONFileWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotificationsDB implements Constants {
    private List<Notification> notifications;
    private String userID;
    private static HashMap<String, NotificationsDB> instances;

    // Flag to check if notifications are modified
    private boolean isModified;

    public static synchronized NotificationsDB getInstance(String userID) {
        if (instances == null) {
            instances = new HashMap<>();
        }
        if (instances.containsKey(userID)) {
            return instances.get(userID);
        }

        // Handle if NOTIFICATIONS_DIRECTORY does not exist
        File destinationDir = new File(NOTIFICATIONS_DIRECTORY);
        if (!destinationDir.exists()) {
            destinationDir.mkdir();
        }

        NotificationsDB instance = new NotificationsDB(userID);
        instances.put(userID, instance);
        return instance;
    }

    private NotificationsDB(String userID) {
        this.userID = userID;
        this.isModified = true;
        try {
            this.setNotifications(JSONFileReader.readJson(NOTIFICATIONS_DIRECTORY + "noti_" + userID + ".json", Notification.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized ArrayList<Notification> getNotifications() {
        if (isModified) {
            refreshNotifications();
        }
        return new ArrayList<>(notifications);
    }

    public synchronized void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
        this.isModified = true;
    }

    public synchronized void addNotification(Notification notification) {
        refreshNotifications();
        notifications.add(notification);
        isModified = true;
        saveDB();
    }

    public synchronized void removeNotification(Notification notification) throws IOException {
        notifications.remove(notification);
        isModified = true;
        saveDB();
    }

    public synchronized void refreshNotifications() {
        try {
            notifications.clear();
            this.setNotifications(JSONFileReader.readJson(NOTIFICATIONS_DIRECTORY + "noti_" + userID + ".json", Notification.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void updateNotification(Notification notification) {
        for (Notification noti : notifications) {
            if (noti.getNotificationID().equals(notification.getNotificationID())) {
                noti.setStatus(notification.getStatus());
                isModified = true;
                break;
            }
        }
        saveDB();
    }

    public Notification searchNotificationByNotificationID(String notificationID) {
        if (isModified) {
            refreshNotifications();
        }
        for (Notification notification : notifications) {
            if (notification.getNotificationID().equals(notificationID)) {
                return notification;
            }
        }
        return null;
    }

    public synchronized void saveDB() {
        try {
            JSONFileWriter.writeJson(NOTIFICATIONS_DIRECTORY + "noti_" + userID + ".json", notifications);
            isModified = false; // Reset flag after saving
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
