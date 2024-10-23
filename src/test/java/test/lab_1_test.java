package test;

import lab_1.Client;
import lab_1.Hotel;
import lab_1.HotelRoom;
import lab_1.Reservation;
import lab_1.enums.PaymentStates;
import lab_1.enums.RoomFeature;
import lab_1.enums.RoomType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.Arrays;

public class lab_1_test {

    private HotelRoom room101;
    private HotelRoom room102;
    private Client client1;
    private Client client2;
    private Reservation reservation1;
    private Reservation reservation2;

    @BeforeMethod
    public void setUp() {
        client1 = new Client("John", "Doe", "1", LocalDate.of(1985, 5, 15));
        client2 = new Client("Jane", "Smith", "2", LocalDate.of(1990, 10, 20));

        room101 = new HotelRoom.Builder()
                .setNumber("101")
                .setType(RoomType.DELUXE)
                .setCapacity(2)
                .setFeatures(Arrays.asList(RoomFeature.OCEAN_VIEW, RoomFeature.KING_BED, RoomFeature.MINI_BAR))
                .setReservations(Arrays.asList(reservation2))
                .build();

        room102 = new HotelRoom.Builder()
                .setNumber("102")
                .setType(RoomType.SUITE)
                .setCapacity(4)
                .setFeatures(Arrays.asList(RoomFeature.MOUNTAIN_VIEW, RoomFeature.QUEEN_BED, RoomFeature.KITCHENETTE))
                .setReservations(Arrays.asList(reservation2))
                .build();

        reservation1 = new Reservation(
                room101,
                client1,
                LocalDate.of(2024, 1, 10),
                LocalDate.of(2024, 1, 15),
                PaymentStates.PAYED
        );

        reservation2 = new Reservation(
                room102,
                client2,
                LocalDate.of(2024, 2, 5),
                LocalDate.of(2024, 2, 10),
                PaymentStates.PAYED
        );
    }

    @Test
    public void testHotelRoomConstructor() {
        SoftAssert sa = new SoftAssert();

        sa.assertEquals(room101.getNumber(),
                "101",
                "Room number should be initialized correctly."
        );
        sa.assertEquals(room101.getCapacity(),
                2,
                "Capacity should be initialized correctly."
        );
        sa.assertEquals(room101.getType(),
                RoomType.DELUXE,
                "Room type should be initialized correctly."
        );
        sa.assertEquals(room101.getFeatures(),
                Arrays.asList(RoomFeature.OCEAN_VIEW,
                        RoomFeature.KING_BED,
                        RoomFeature.MINI_BAR),
                "Features should be initialized correctly."
        );
        sa.assertAll();
    }

    @Test
    public void testClientConstructor() {
        SoftAssert sa = new SoftAssert();

        sa.assertEquals(client1.getFirstName(),
                "John",
                "First name should be initialized correctly."
        );
        sa.assertEquals(client1.getLastName(),
                "Doe",
                "Last name should be initialized correctly."
        );
        sa.assertEquals(client1.getPassportId(),
                "1",
                "Documents should be initialized correctly."
        );
        sa.assertEquals(client1.getDateOfBirth(),
                LocalDate.of(1985, 5, 15),
                "Date of birth should be initialized correctly."
        );
        sa.assertAll();
    }

    @Test
    public void testReservationConstructor() {
        SoftAssert sa = new SoftAssert();

        sa.assertEquals(reservation1.getRoomNumber().getNumber(),
                "101",
                "Reservation should correctly store the room number."
        );
        sa.assertEquals(reservation1.getClient(),
                client1,
                "Reservation should correctly store the client."
        );
        sa.assertEquals(reservation1.getEnterDate(),
                LocalDate.of(2024, 1, 10),
                "Enter date should be initialized correctly."
        );
        sa.assertEquals(reservation1.getDepartureDate(),
                LocalDate.of(2024, 1, 15),
                "Departure date should be initialized correctly."
        );
        sa.assertEquals(reservation1.getPayment(),
                PaymentStates.PAYED,
                "Reservation should correctly store the payment status."
        );
        sa.assertAll();
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
        Client sameAsClient1 = new Client("John", "Doe", "1", LocalDate.of(1985, 5, 15));
        Assert.assertEquals(client1, sameAsClient1, "Clients with the same details should be equal");
    }

    @Test
    public void testReservationToString() {
        String expected = "Reservation{room=101, client=Client{firstName='John', lastName='Doe', passportId=1, dateOfBirth=" + LocalDate.of(1985, 5, 15) + "}, enterDate=" + LocalDate.of(2024, 1, 10) + ", departureDate=" + LocalDate.of(2024, 1, 15) + ", paymentStatus=PAYED}";
        Assert.assertEquals(reservation1.toString(), expected, "Reservation toString() should match expected output");
    }

    @Test
    public void testHotelToString() {
        Hotel hotel = new Hotel("The grand Blue", new HotelRoom[]{room101, room102});
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