package test;

import classesLab.Client;
import classesLab.Hotel;
import classesLab.HotelRoom;
import classesLab.Reservation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class ReservationSystemTests {

    private HotelRoom room101;
    private HotelRoom room102;
    private Client client1;
    private Client client2;
    private Reservation reservation1;
    private Reservation reservation2;

    @BeforeMethod
    public void setUp() {
        client1 = new Client("John", "Doe", true, new Date(1985, 5, 15));
        client2 = new Client("Jane", "Smith", true, new Date(1990, 10, 20));

        room101 = new HotelRoom.Builder()
                .setRoomNumber(101)
                .setRoomType("Deluxe")
                .setCapacity(2)
                .setFeatures("Ocean View, King Bed, Mini-Bar")
                .build();

        room102 = new HotelRoom.Builder()
                .setRoomNumber(102)
                .setRoomType("Suite")
                .setCapacity(4)
                .setFeatures("Mountain View, 2 Queen Beds, Kitchenette")
                .build();

        reservation1 = new Reservation(
                room101.getRoomNumber(),
                client1,
                new Date(2024, 1, 10),
                new Date(2024, 1, 15),
                true
        );

        reservation2 = new Reservation(
                room102.getRoomNumber(),
                client2,
                new Date(2024, 2, 5),
                new Date(2024, 2, 10),
                false
        );
    }

    @Test
    public void testHotelRoomConstructor() {
        Assert.assertEquals(room101.getRoomNumber(), 101, "Room number should be initialized correctly.");
        Assert.assertEquals(room101.getCapacity(), 2, "Capacity should be initialized correctly.");
        Assert.assertEquals(room101.getRoomType(), "Deluxe", "Room type should be initialized correctly.");
        Assert.assertEquals(room101.getFeatures(), "Ocean View, King Bed, Mini-Bar", "Features should be initialized correctly.");
    }

    @Test
    public void testClientConstructor() {
        Assert.assertEquals(client1.getFirstName(), "John", "First name should be initialized correctly.");
        Assert.assertEquals(client1.getLastName(), "Doe", "Last name should be initialized correctly.");
        Assert.assertTrue(client1.getDocuments(), "Documents should be initialized correctly.");
        Assert.assertEquals(client1.getDateOfBirth(), new Date(1985, 5, 15), "Date of birth should be initialized correctly.");
    }

    @Test
    public void testReservationConstructor() {
        Assert.assertEquals(reservation1.getRoomNumber(), 101, "Reservation should correctly store the room number.");
        Assert.assertEquals(reservation1.getClient(), client1, "Reservation should correctly store the client.");
        Assert.assertEquals(reservation1.getEnterDate(), new Date(2024, 1, 10), "Enter date should be initialized correctly.");
        Assert.assertEquals(reservation1.getDepartureDate(), new Date(2024, 1, 15), "Departure date should be initialized correctly.");
        Assert.assertTrue(reservation1.getIsPaid(), "Reservation should correctly store the payment status.");
    }

    @Test
    public void testHotelRoomEquality() {
        Assert.assertNotEquals(room101, room102, "Room 101 should not equal Room 102");
    }

    @Test
    public void testReservationEquality() {
        Assert.assertNotEquals(reservation1, reservation2, "Reservation 1 should not equal Reservation 2");
    }

    @Test
    public void testClientEquality() {
        Assert.assertNotEquals(client1, client2, "Client 1 should not equal Client 2");
        Client sameAsClient1 = new Client("John", "Doe", true, new Date(1985, 5, 15));
        Assert.assertEquals(client1, sameAsClient1, "Clients with the same details should be equal");
    }

    @Test
    public void testReservationToString() {
        String expected = "Reservation{roomNumber=101, client=Client{firstName='John', lastName='Doe', documents=true, dateOfBirth=" + new Date(1985, 5, 15) + "}, enterDate=" + new Date(2024, 1, 10) + ", departureDate=" + new Date(2024, 1, 15) + ", isPaid=true}";
        Assert.assertEquals(reservation1.toString(), expected, "Reservation toString() should match expected output");
    }

    @Test
    public void testHotelToString() {
        Hotel hotel = new Hotel(new HotelRoom[]{room101, room102});
        Assert.assertTrue(hotel.toString().contains("HotelRoom{roomNumber=101"));
        Assert.assertTrue(hotel.toString().contains("HotelRoom{roomNumber=102"));
    }

    @Test
    public void testHashCodeConsistency() {
        int room101HashCode = room101.hashCode();
        int room101HashCodeAgain = room101.hashCode();
        Assert.assertEquals(room101HashCode, room101HashCodeAgain, "HashCode should be consistent across multiple calls");

        int reservation1HashCode = reservation1.hashCode();
        int reservation1HashCodeAgain = reservation1.hashCode();
        Assert.assertEquals(reservation1HashCode, reservation1HashCodeAgain, "HashCode should be consistent across multiple calls");
    }
}