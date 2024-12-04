package utils;

import java.util.UUID;

public class UserIDGenerator {
    public static String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
