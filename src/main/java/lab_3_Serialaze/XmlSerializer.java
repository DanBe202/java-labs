package lab_3_Serialaze;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;


public class XmlSerializer<T> implements Serializer<T> {
    private final XmlMapper xmlMapper = new XmlMapper();

    public XmlSerializer() {
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.setDateFormat(new java.text.SimpleDateFormat("yyyy-MM-dd"));
        xmlMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @Override
    public String serialize(T entity) throws IOException {
        return xmlMapper.writeValueAsString(entity);
    }

    @Override
    public T deserialize(String data, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(data, clazz);
    }

    @Override
    public void writeToFile(T entity, File file) throws IOException {
        xmlMapper.writeValue(file, entity);
    }

    @Override
    public T readFromFile(File file, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(file, clazz);
    }
}