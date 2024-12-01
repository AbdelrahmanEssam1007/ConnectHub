package backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONFileReader {
    public <T> List<T> readJson(String filePath, Class<T> CLASS) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return List.of();
        }
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, CLASS));
    }

    public boolean doesEmailExist(String email, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return false;
        }
        List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>() {
        });
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
