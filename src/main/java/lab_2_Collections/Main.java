package lab_2_Collections;

import lab_1_Objects.HotelRoom;
import lab_1_Objects.enums.RoomFeature;
import lab_1_Objects.enums.RoomType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<HotelRoom> rooms = new ArrayList<>();

        rooms.add(new HotelRoom.Builder()
                .setNumber("101")
                .setType(RoomType.DELUXE)
                .setFeatures(Arrays.asList(RoomFeature.MOUNTAIN_VIEW, RoomFeature.QUEEN_BED, RoomFeature.KITCHENETTE))
                .setCapacity(1)
                .build());

        rooms.add(new HotelRoom.Builder()
                .setNumber("102")
                .setType(RoomType.SUITE)
                .setFeatures(Arrays.asList(RoomFeature.MOUNTAIN_VIEW, RoomFeature.QUEEN_BED, RoomFeature.KITCHENETTE))
                .setCapacity(2)
                .build());

        List<HotelRoom> suites = HotelService.filterRoomsByType(rooms, RoomType.SUITE);
        System.out.println("Suites: " + suites.get(0).toString());

        List<HotelRoom> sortedByCapacity = HotelService.sortRoomsByCapacity(rooms);
        System.out.println("Rooms sorted by capacity: " + sortedByCapacity);

        List<HotelRoom> highCapacityRooms = HotelService.findRoomsAboveCapacity(rooms, 1);
        System.out.println("Rooms with capacity above 1: " + highCapacityRooms);
    }
}