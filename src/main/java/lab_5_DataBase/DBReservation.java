package lab_5_DataBase;

import lab_1_Objects.Reservation;
import lab_1_Objects.enums.PaymentStates;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBReservation extends DBAbstract<Reservation> {
    private final DBRoom roomsDB;
    private final DBClient clientDB;

    public DBReservation() {
        roomsDB = new DBRoom();
        clientDB = new DBClient();
    }

    public List<Reservation> getAll() {
        try (var connection = getConnection();
             var statement = connection.createStatement();
             var dbReservations = statement.executeQuery(
                     "SELECT *" +
                             " FROM reservation")) {
            List<Reservation> clients = new ArrayList<>();
            while (dbReservations.next()) {
                Reservation client = new Reservation(
                        dbReservations.getInt("id"),
                        roomsDB.getOne(dbReservations.getInt("room_id")),
                        clientDB.getOne(dbReservations.getInt("client")),
                        LocalDate.parse(dbReservations.getString("enter_date")),
                        LocalDate.parse(dbReservations.getString("departure_date")),
                        PaymentStates.fromString(dbReservations.getString("payment"))
                );
                clients.add(client);
            }
            return clients;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public Reservation getOne(int id) {
        try (var connection = getConnection();
             var statement = connection.createStatement();
             var dbReservation = statement.executeQuery(
                     "SELECT *" +
                             " FROM reservation" +
                             " WHERE id = " + id)) {
            return new Reservation(
                    dbReservation.getInt("id"),
                    new DBRoom().getOne(dbReservation.getInt("room_id")),
                    new DBClient().getOne(dbReservation.getInt("client")),
                    LocalDate.parse(dbReservation.getString("enter_date")),
                    LocalDate.parse(dbReservation.getString("departure_date")),
                    PaymentStates.fromString(dbReservation.getString("payment"))
            );

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void insert(Reservation reservation) {
        try (var connection = getConnection();
             var insert = connection.prepareStatement(
                     "INSERT INTO reservation(room_id," +
                             " client," +
                             " enter_date," +
                             " departure_date," +
                             " payment)" +
                             " VALUES(?,?,?,?,?)")) {
            insert.setInt(1, reservation.getRoom().getId());
            insert.setInt(2, reservation.getClient().getId());
            insert.setString(3, reservation.getEnterDate().toString());
            insert.setString(4, reservation.getDepartureDate().toString());
            insert.setString(5, reservation.getPayment().toString());
            insert.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void update(Reservation reservation) {
        try (var connection = getConnection();
             var update = connection.prepareStatement(
                     "UPDATE reservation" +
                             " SET room_id = ?," +
                             " client = ?," +
                             " enter_date = ?," +
                             " departure_date = ?," +
                             " payment = ?" +
                             " WHERE id = " + reservation.getId())) {
            update.setInt(1, reservation.getRoom().getId());
            update.setInt(2, reservation.getClient().getId());
            update.setString(3, reservation.getEnterDate().toString());
            update.setString(4, reservation.getDepartureDate().toString());
            update.setString(5, reservation.getPayment().toString());
            update.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void delete(int id) {
        try (var conn = getConnection();
             var statement = conn.prepareStatement("DELETE FROM reservation WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
//        DBReservation reservationsDB = new DBReservation();
//        List<Reservation> reservations = reservationsDB.getAll();
//
//        System.out.println(reservations);
//
//        Reservation updatedReservation = reservations.getLast()
//                .setPayment(PaymentStates.PAYED);
//
//        reservationsDB.update(updatedReservation);
//
//        Reservation newReservation = new Reservation(
//                reservations.getLast().getId(),
//                new DBRooms().getOne(3),
//                new DBClient().getOne(3),
//                LocalDate.now(),
//                LocalDate.now().plusDays(2),
//                PaymentStates.UNPAID
//        );

//        reservationsDB.insert(newReservation);

        System.out.println(new DBReservation().getOne(2));
    }
}
