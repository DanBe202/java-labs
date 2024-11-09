package lab_3_Serialaze;

import lab_1_Objects.Client;
import lab_1_Objects.Hotel;
import lab_1_Objects.HotelRoom;
import lab_1_Objects.Reservation;
import lab_1_Objects.enums.PaymentStates;
import lab_1_Objects.enums.RoomFeature;
import lab_1_Objects.enums.RoomType;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void  main(String[] args) throws IOException {

        Client client1 = new Client(1, "John", "Doe", "1", LocalDate.of(2020, 5, 15));
        Client client2 = new Client(2, "Jane", "Smith", "2", LocalDate.of(2024, 10, 20));

        HotelRoom room101 = new HotelRoom.Builder()
                .setId(1)
                .setNumber("101")
                .setType(RoomType.DELUXE)
                .setCapacity(2)
                .setHotelId(1)
                .setFeatures(Arrays.asList(RoomFeature.OCEAN_VIEW, RoomFeature.KING_BED, RoomFeature.MINI_BAR))
                .setReservations(List.of())
                .build();

        HotelRoom room102 = new HotelRoom.Builder()
                .setId(2)
                .setNumber("102")
                .setType(RoomType.SUITE)
                .setCapacity(4)
                .setHotelId(1)
                .setFeatures(Arrays.asList(RoomFeature.MOUNTAIN_VIEW, RoomFeature.QUEEN_BED, RoomFeature.KITCHENETTE))
                .setReservations(List.of())
                .build();

        Reservation reservation1 = new Reservation(
                1,
                room101,
                client1,
                LocalDate.of(2024, 1, 10),
                LocalDate.of(2024, 1, 15),
                PaymentStates.PAYED
        );

        Reservation reservation2 = new Reservation(
                2,
                room102,
                client2,
                LocalDate.of(2024, 2, 5),
                LocalDate.of(2024, 2, 10),
                PaymentStates.PAYED
        );

        room101.setReservations(Arrays.asList(reservation1));
        room102.setReservations(Arrays.asList(reservation2));

        List<HotelRoom> roomList = new ArrayList<>();
        roomList.add(room101);
        roomList.add(room102);

        Hotel hotel = new Hotel(1, "The grand blue", roomList);

//        // JSON
//        Serializer<Hotel> jsonSerializer = new JsonSerializer<>();
//        String jsonData = jsonSerializer.serialize(hotel);
//        System.out.println("JSON: " + jsonData);
//
//        Hotel deserializedHotel = jsonSerializer.deserialize(jsonData, Hotel.class);
//        System.out.println("Deserialized:" + deserializedHotel);
//
//        jsonSerializer.writeToFile(hotel, new File("hotel.json"));
//        Hotel hotelFromJson = jsonSerializer.readFromFile(new File("hotel.json"), Hotel.class);
//        System.out.println("Deserialized from JSON: " + hotelFromJson);

        // XML
//        Serializer<Hotel> xmlSerializer = new XmlSerializer<>();
//        String xmlData = xmlSerializer.serialize(hotel);
//        System.out.println("XML: " + xmlData);
//
//        xmlSerializer.writeToFile(hotel, new File("hotel.xml"));
//        Hotel hotelFromXml = xmlSerializer.readFromFile(new File("hotel.xml"), Hotel.class);
//        System.out.println("Deserialized from XML: " + hotelFromXml);
//
//        // YAML
        Serializer<Hotel> yamlSerializer = new YamlSerializer<>();
//        String yamlData = yamlSerializer.serialize(hotel);
//        System.out.println("YAML: " + yamlData);
//
//        yamlSerializer.writeToFile(hotel, new File("hotel.yaml"));
        Hotel hotelFromYaml = yamlSerializer.readFromFile(new File("hotel.yaml"), Hotel.class);
        System.out.println("Deserialized from YAML: " + hotelFromYaml);
    }
}
