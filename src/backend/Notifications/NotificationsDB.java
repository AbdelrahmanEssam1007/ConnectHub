package backend.Notifications;

import utils.JSONFileReader;
import utils.JSONFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotificationsDB {
    private List<Notification> notifications;
    private String userID;
    // TODO: implement singleton pattern (multiple instances)
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
        NotificationsDB instance = new NotificationsDB(userID);
        instances.add(instance);
        return instance;
    }

    private NotificationsDB(String userID) {
        this.userID = userID;
        try {
            this.setNotifications(JSONFileReader.readJson("noti_" + userID + ".json", Notification.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Notification> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public synchronized void addNotification(Notification notification) throws IOException {
        notifications.add(notification);
        JSONFileWriter.writeJson("noti_" + notification.getUserID() + ".json", notifications);
    }

    public synchronized void removeNotification(Notification notification) throws IOException {
        notifications.remove(notification);
        JSONFileWriter.writeJson("noti_" + notification.getUserID() + ".json", notifications);
    }

    public void refreshNotifications(Notification notification) throws IOException {
        this.setNotifications(JSONFileReader.readJson("noti_" + userID + ".json", Notification.class));
    }

    public synchronized void updateNotification(Notification notification) {
        for (Notification noti : notifications) {
            if (noti.getNotificationID().equals(notification.getNotificationID())) {
                noti.setStatus(notification.getStatus());
                saveDB();
                return;
            }
        }
    }

    public synchronized void saveDB() {
        try {
            JSONFileWriter.writeJson("noti_" + userID + ".json", notifications);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
