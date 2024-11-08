package lab_3_Serialaze;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;

public class JsonSerializer<T> implements Serializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonSerializer() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @Override
    public String serialize(T entity) throws IOException {
        return objectMapper.writeValueAsString(entity);
    }

    @Override
    public T deserialize(String data, Class<T> clazz) throws IOException {
        return objectMapper.readValue(data, clazz);
    }

    @Override
    public void writeToFile(T entity, File file) throws IOException {
        objectMapper.writeValue(file, entity);
    }

    @Override
    public T readFromFile(File file, Class<T> clazz) throws IOException {
        return objectMapper.readValue(file, clazz);
    }
}
