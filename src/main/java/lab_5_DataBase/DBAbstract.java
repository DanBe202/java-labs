package lab_5_DataBase;

import java.util.List;

public abstract class DBAbstract<T> {
    protected static final String path = "jdbc:sqlite:hotel.db";

    public abstract List<T> getAll();

    public abstract T getOne(int id);

    public abstract void insert(T o);

    public abstract void update(T o);

    public abstract void delete(int id);
}
