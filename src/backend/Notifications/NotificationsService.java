package backend.Notifications;

import backend.UserDB;
import frontend.Item;
import frontend.Notifications;
import utils.Constants;
import utils.TimeUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

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
                if(notificationsDB.getNotifications().isEmpty()) {
//                    System.out.println("No notifications");
                }
                else {
//                    System.out.println("Notifications found");
                }
                SystemTray tray = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
                trayIcon = new TrayIcon(image, "Notifications");
                trayIcon.setImageAutoSize(true);
                trayIcon.setToolTip("Notifications");
                try{
                    tray.add(trayIcon);
                } catch (AWTException e) {
                    System.out.println("TrayIcon could not be added.");
                    return;
                }
                notificationsPanel.clearNoti();
                for (Notification notification : notificationsDB.getNotifications()) {
                    // TODO: Delete notification after responding
                    // TODO: Update notification status
                    if(notification.getStatus().equals("new")) {
//                        System.out.println("Adding new notification");
                        notification.setStatus("shown");
                        notificationsDB.updateNotification(notification);
                        trayIcon.displayMessage(userDB.searchUserByUserId(notification.getSenderUserID()).getUserName(), notification.getMessage(), TrayIcon.MessageType.INFO);
                        notificationsPanel.addNoti(new Item(new ImageIcon(Constants.DEFAULT_PFP),
                                userDB.searchUserByUserId(notification.getSenderUserID()).getUserName(),
                                userDB.searchUserByUserId(notification.getUserID()).getUserName(),
                                notification.getMessage(),
                                TimeUtils.getTimeAgo(notification.getDate()),
                                notification.getType()));
                    } else if (notification.getStatus().equals("shown")) {
//                        System.out.println("Updating shown notification");
                        // get current time and set notification time to time ago
                        notificationsPanel.addNoti(new Item(new ImageIcon(Constants.DEFAULT_PFP),
                                userDB.searchUserByUserId(notification.getSenderUserID()).getUserName(),
                                userDB.searchUserByUserId(notification.getUserID()).getUserName(),
                                notification.getMessage(),
                                TimeUtils.getTimeAgo(notification.getDate()),
                                notification.getType()));
                    } else if (notification.getStatus().equals("responded")) {
                        // remove notification
                    } else {
//                        System.out.println("Notification already read");
                    }
                }
                notificationsPanel.revalidate();
                notificationsPanel.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("Checking for notifications...");
        }
    }
}
