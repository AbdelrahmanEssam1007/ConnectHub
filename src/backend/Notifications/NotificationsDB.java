package backend.Notifications;

import utils.Constants;
import utils.JSONFileReader;
import utils.JSONFileWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotificationsDB implements Constants {
    private List<Notification> notifications;
    private String userID;
    private static ArrayList<NotificationsDB> instances;

    public static NotificationsDB getInstance(String userID) {
        if (instances == null) {
            instances = new ArrayList<>();
        }
        for (NotificationsDB instance : instances) {
            if (instance.userID.equals(userID)) {
                return instance;
            }
        }
        // Handle if NOTIFICATIONS_DIRECTORY does not exist
        File destinationDir = new File(NOTIFICATIONS_DIRECTORY);
        if(!destinationDir.exists()){
            destinationDir.mkdir();
        }

        NotificationsDB instance = new NotificationsDB(userID);
        instances.add(instance);
        return instance;
    }

    private NotificationsDB(String userID) {
        this.userID = userID;
        try {
            this.setNotifications(JSONFileReader.readJson(NOTIFICATIONS_DIRECTORY + "noti_" + userID + ".json", Notification.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Notification> getNotifications() {
        refreshNotifications();
        return new ArrayList<>(notifications);
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
        saveDB();
        refreshNotifications();
    }

    public synchronized void removeNotification(Notification notification) throws IOException {
        notifications.remove(notification);
        JSONFileWriter.writeJson(NOTIFICATIONS_DIRECTORY + "noti_" + notification.getUserID() + ".json", notifications);
    }

    public void refreshNotifications() {
        try {
            this.setNotifications(JSONFileReader.readJson(NOTIFICATIONS_DIRECTORY + "noti_" + userID + ".json", Notification.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void updateNotification(Notification notification) {
        for (Notification noti : notifications) {
            if (noti.getNotificationID().equals(notification.getNotificationID())) {
                noti.setStatus(notification.getStatus());
                saveDB();
                refreshNotifications();
                return;
            }
        }
    }

    public Notification searchNotificationByNotificationID(String notificationID) {
        refreshNotifications();
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
