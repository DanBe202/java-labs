package lab_5_DataBase;

import lab_1_Objects.HotelRoom;
import lab_1_Objects.enums.RoomFeature;
import lab_1_Objects.enums.RoomType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBRooms extends DBCrud<HotelRoom>{
    private static DBRooms instance;

    private DBRooms() {}

    public static DBRooms getInstance() {
        if (instance == null) {
            instance = new DBRooms();
        }
        return instance;
    }

    public List<HotelRoom> getAll() {
        try (var connection = DriverManager.getConnection(DBRooms.path);
             var statement = connection.createStatement();
             var dbRooms = statement.executeQuery(
                     "SELECT *" +
                             " FROM room")) {
            List<HotelRoom> rooms = new ArrayList<>();
            while (dbRooms.next()) {
                HotelRoom room = new HotelRoom.Builder()
                        .setId(dbRooms.getInt("id"))
                        .setHotelId(dbRooms.getInt("hotel_id"))
                        .setNumber(dbRooms.getString("number"))
                        .setCapacity(dbRooms.getInt("capacity"))
                        .setFeatures(dbRooms.getString("features"))
                        .setType(RoomType.fromString(dbRooms.getString("type"))).build();
                rooms.add(room);
            }
            return rooms;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public HotelRoom getOne(int id) {
        try (var connection = DriverManager.getConnection(DBRooms.path);
             var statement = connection.createStatement();
             var dbRoom = statement.executeQuery(
                     "SELECT *" +
                             " FROM room" +
                             " where id = " + id)) {
            return new HotelRoom.Builder()
                    .setId(dbRoom.getInt("id"))
                    .setHotelId(dbRoom.getInt("hotel_id"))
                    .setNumber(dbRoom.getString("number"))
                    .setCapacity(dbRoom.getInt("capacity"))
                    .setFeatures(dbRoom.getString("features"))
                    .setType(RoomType.fromString(dbRoom.getString("type"))).build();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void insert(HotelRoom room) {
        try (var connection = DriverManager.getConnection(DBRooms.path);
             var insert = connection.prepareStatement(
                     "INSERT INTO room(hotel_id," +
                             " number," +
                             " type," +
                             " capacity," +
                             " features) " +
                             "VALUES(?,?,?,?,?)")) {
            insert.setInt(1, room.getHotelId());
            insert.setString(2, room.getNumber());
            insert.setString(3, room.getTypeString());
            insert.setDouble(4, room.getCapacity());
            insert.setString(5, room.getFeaturesString());
            insert.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void update(HotelRoom room) {
        try (var connection = DriverManager.getConnection(DBRooms.path);
             var update = connection.prepareStatement(
                     "UPDATE room " +
                             "SET number = ?," +
                             " type = ?," +
                             " capacity = ?," +
                             " features = ? " +
                             "WHERE id = " + room.getId())) {
            update.setString(1, room.getNumber());
            update.setString(2, room.getTypeString());
            update.setDouble(3, room.getCapacity());
            update.setString(4, room.getFeaturesString());
            update.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void delete(int id) {
        try (var conn = DriverManager.getConnection(DBRooms.path);
             var statement = conn.prepareStatement("DELETE FROM room WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        List<HotelRoom> rooms = DBRooms.getInstance().getAll();

        HotelRoom updatedRoom = rooms.getLast()
                .setCapacity(5);

        DBRooms.getInstance().update(updatedRoom);

        HotelRoom room105 = new HotelRoom.Builder()
                .setId(rooms.getLast().getId())
                .setNumber("106")
                .setType(RoomType.SUITE)
                .setCapacity(2)
                .setHotelId(1)
                .setFeatures(Arrays.asList(RoomFeature.MINI_BAR))
                .setReservations(List.of())
                .build();

        DBRooms.getInstance().insert(room105);

        System.out.println(DBRooms.getInstance().getAll());
    }
}
