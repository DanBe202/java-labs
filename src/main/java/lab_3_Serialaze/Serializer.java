package lab_3_Serialaze;

import java.io.File;
import java.io.IOException;

public interface Serializer<T> {
    String serialize(T entity) throws IOException;

    T deserialize(String data, Class<T> clazz) throws IOException;

    void writeToFile(T entity, File file) throws IOException;

    T readFromFile(File file, Class<T> clazz) throws IOException;
}

