package lab_5_DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DBAbstract<T> {
    protected static final String path = "jdbc:sqlite:hotel.db";

    public Connection getConnection() {
        try {return DriverManager.getConnection(path);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public abstract List<T> getAll();

    public abstract T getOne(int id);

    public abstract void insert(T o);

    public abstract void update(T o);

    public abstract void delete(int id);
}
