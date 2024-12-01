package backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileWriter {
    public <T>void writeJson(String filePath, List<T> dataList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        File file = new File(filePath);
        objectWriter.writeValue(file, dataList);
    }
}
