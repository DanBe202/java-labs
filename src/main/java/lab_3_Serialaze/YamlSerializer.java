package lab_3_Serialaze;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class YamlSerializer<T> implements Serializer<T> {
    private final YAMLMapper yamlMapper = new YAMLMapper();

    public YamlSerializer() {
        yamlMapper.registerModule(new JavaTimeModule());
        yamlMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }


    @Override
    public String serialize(T entity) throws IOException {
        return yamlMapper.writeValueAsString(entity);
    }

    @Override
    public T deserialize(String data, Class<T> clazz) throws IOException {
        return yamlMapper.readValue(data, clazz);
    }

    @Override
    public void writeToFile(T entity, File file) throws IOException {
        yamlMapper.writeValue(file, entity);
    }

    @Override
    public T readFromFile(File file, Class<T> clazz) throws IOException {
        return yamlMapper.readValue(file, clazz);
    }
}
