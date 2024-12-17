package backend.Notifications;

import backend.UserDB;
import frontend.notifications.Item;
import frontend.notifications.Notifications;
import utils.Constants;
import utils.TimeUtils;

import java.awt.*;

public class NotificationsService extends Thread implements Constants {

    private TrayIcon trayIcon;
    private String userID;
    private NotificationsDB notificationsDB;
    private Notifications notificationsPanel;
    private UserDB userDB;

    public NotificationsService(String userID, Notifications notifications) {
        this.userID = userID;
        notificationsDB = NotificationsDB.getInstance(userID);
        notificationsPanel = notifications;
        userDB = UserDB.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            try {
                // TODO: Refresh user page
                Thread.sleep(5000);//10000
                // Read the file and create a notification
//                if(notificationsDB.getNotifications().isEmpty()) {
////                    System.out.println("No notifications");
//                }
//                else {
////                    System.out.println("Notifications found");
//                }
                notificationsDB = NotificationsDB.getInstance(userID);
                notificationsPanel.clearNoti();
                notificationsDB.refreshNotifications();
                for (Notification notification : notificationsDB.getNotifications()) {
                    if(notification.getStatus().equals("new")) {
                        // Add new notification
                        notification.setStatus("shown");
                        notificationsDB.updateNotification(notification);
                        if (trayIcon == null) {
                            SystemTray tray = SystemTray.getSystemTray();
                            Image image = Toolkit.getDefaultToolkit().createImage(userDB.searchUserByUserId(notification.getSenderUserID()).getProfile().getProfilePhoto());
                            trayIcon = new TrayIcon(image, "Notifications");
                            trayIcon.setImageAutoSize(true);
                            trayIcon.setToolTip("Notifications");
                            try {
                                tray.add(trayIcon);
                            } catch (AWTException e) {
                                System.out.println("TrayIcon could not be added.");
                                return;
                            }
                        }
                        trayIcon.displayMessage(userDB.searchUserByUserId(notification.getSenderUserID()).getUserName(), notification.getMessage(), TrayIcon.MessageType.INFO);
                        notificationsPanel.addNoti(new Item(notification, TimeUtils.getTimeAgo(notification.getDate())));
                    } else if (notification.getStatus().equals("shown")) {
                        // Update notification
                        notificationsPanel.addNoti(new Item(notification, TimeUtils.getTimeAgo(notification.getDate())));
                    } else if (notification.getStatus().equals("responded")) {
                        // remove notification
                    } else {
                        //System.out.println("Notification already read");
                    }
                }
                notificationsPanel.revalidate();
                notificationsPanel.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
