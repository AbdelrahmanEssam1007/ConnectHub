package utils;

import java.util.Date;

public class TimeUtils {
    public static String getTimeAgo(Date date) {
        // TODO: remove negative sign
        long diff = new Date().getTime() - date.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        if (diffDays > 0) {
            return diffDays + " day" + (diffDays > 1 ? "s" : "") + " ago";
        } else if (diffHours > 0) {
            return diffHours + " hour" + (diffHours > 1 ? "s" : "") + " ago";
        } else if (diffMinutes > 0) {
            return diffMinutes + " minute" + (diffMinutes > 1 ? "s" : "") + " ago";
        } else {
            return diffSeconds + " second" + (diffSeconds > 1 ? "s" : "") + " ago";
        }
    }
}
