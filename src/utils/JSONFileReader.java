package utils;

import backend.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONFileReader {
    public static <T> List<T> readJson(String filePath, Class<T> CLASS) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return List.of();
        }
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, CLASS));
    }

    public static User searchUserByEmail(String email, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>() {
        });
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public static User searchUserByUserName(String userName, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>() {
        });
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}
