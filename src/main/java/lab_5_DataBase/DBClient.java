package lab_5_DataBase;

import lab_1_Objects.Client;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBClient extends DBAbstract<Client> {
    private static DBClient instance;

    private DBClient() {}

    public static DBClient getInstance() {
        if (instance == null) {
            instance = new DBClient();
        }
        return instance;
    }

    public List<Client> getAll() {
        try (var connection = DriverManager.getConnection(DBClient.path);
             var statement = connection.createStatement();
             var dbClients = statement.executeQuery(
                     "SELECT *" +
                             " FROM client")) {
            List<Client> clients = new ArrayList<>();
            while (dbClients.next()) {
                Client client = new Client(
                        dbClients.getInt("id"),
                        dbClients.getString("first_name"),
                        dbClients.getString("last_name"),
                        dbClients.getString("passport_id"),
                        LocalDate.parse(dbClients.getString("date_of_birth"))
                );
                clients.add(client);
            }
            return clients;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public Client getOne(int id) {
        try (var connection = DriverManager.getConnection(DBClient.path);
             var statement = connection.createStatement();
             var dbClient = statement.executeQuery(
                     "SELECT *" +
                             " FROM сlient" +
                             " where id = " + id)) {
            return new Client(
                    dbClient.getInt("id"),
                    dbClient.getString("first_name"),
                    dbClient.getString("last_name"),
                    dbClient.getString("passportId"),
                    LocalDate.parse(dbClient.getString("date_of_birth"))
            );

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void insert(Client client) {
        try (var connection = DriverManager.getConnection(DBClient.path);
             var insert = connection.prepareStatement(
                     "INSERT INTO client(first_name," +
                             " last_name," +
                             " passport_id," +
                             " date_of_birth) " +
                             "VALUES(?,?,?,?)")) {
            insert.setString(1, client.getFirstName());
            insert.setString(2, client.getLastName());
            insert.setString(3, client.getPassportId());
            insert.setString(4, client.getDateOfBirth().toString());
            insert.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void update(Client client) {
        try (var connection = DriverManager.getConnection(DBClient.path);
             var update = connection.prepareStatement(
                     "UPDATE client" +
                             " SET first_name = ?," +
                             " last_name = ?," +
                             " passport_id = ?," +
                             " date_of_birth = ?" +
                             "WHERE id = " + client.getId())) {
            update.setString(1, client.getFirstName());
            update.setString(2, client.getLastName());
            update.setString(3, client.getPassportId());
            update.setString(4, client.getDateOfBirth().toString());
            update.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void delete(int id) {
        try (var conn = DriverManager.getConnection(DBClient.path);
             var statement = conn.prepareStatement("DELETE FROM client WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        List<Client> clients = DBClient.getInstance().getAll();

        Client updatedClient = clients.getLast()
                .setPassportId("4");

        DBClient.getInstance().update(updatedClient);

        Client newClient = new Client(
                clients.getLast().getId(),
                "Max",
                "Markevich",
                "3",
                LocalDate.of(2005, 04, 25)
        );

        DBClient.getInstance().insert(newClient);

        System.out.println(clients);
    }
}
