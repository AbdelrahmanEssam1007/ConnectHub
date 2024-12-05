package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONFileWriter {
    public static <T>void writeJson(String filePath, List<T> dataList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        File file = new File(filePath);
        // TODO: handle file not created
        objectWriter.writeValue(file, dataList);
    }
}
