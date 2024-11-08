package lab_2_Collections;

import lab_1_Objects.HotelRoom;
import lab_1_Objects.enums.RoomType;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelService {
    public static List<HotelRoom> filterRoomsByType(List<HotelRoom> rooms, RoomType type) {
        return rooms.stream()
                .filter(room -> room.getType().equals(type))
                .collect(Collectors.toList());
    }

    public static List<HotelRoom> sortRoomsByCapacity(List<HotelRoom> rooms) {
        return rooms.stream()
                .sorted(Comparator.comparingInt(HotelRoom::getCapacity))
                .collect(Collectors.toList());
    }

    public static List<HotelRoom> findRoomsAboveCapacity(List<HotelRoom> rooms, int minCapacity) {
        return rooms.stream()
                .filter(room -> room.getCapacity() > minCapacity)
                .collect(Collectors.toList());
    }
}

