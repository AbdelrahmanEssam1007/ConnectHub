package utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class TimeUtils {

    public static String getTimeAgo(LocalDateTime dateTime) {
        // Current date-time
        LocalDateTime now = LocalDateTime.now();

        // Calculate the duration between the given date-time and now
        Duration duration = Duration.between(dateTime, now);

        if (duration.isNegative())
            return "In the future"; // Handle cases where the given time is in the future

        // Check and return the appropriate time unit
        long seconds = duration.getSeconds();
        if (seconds < 60)
            return seconds + " second" + (seconds == 1 ? "" : "s") + " ago";

        long minutes = duration.toMinutes();
        if (minutes < 60)
            return minutes + " minute" + (minutes == 1 ? "" : "s") + " ago";

        long hours = duration.toHours();
        if (hours < 24)
            return hours + " hour" + (hours == 1 ? "" : "s") + " ago";

        long days = duration.toDays();
        if (days < 7)
            return days + " day" + (days == 1 ? "" : "s") + " ago";

        long weeks = days / 7;
        if (weeks < 4)
            return weeks + " week" + (weeks == 1 ? "" : "s") + " ago";

        long months = weeks / 4;
        if (months < 12)
            return months + " month" + (months == 1 ? "" : "s") + " ago";

        long years = months / 12;
        return years + " year" + (years == 1 ? "" : "s") + " ago";
    }

}
