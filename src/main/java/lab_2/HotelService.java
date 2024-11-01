package lab_2;

import lab_1.HotelRoom;
import lab_1.enums.RoomType;

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
                .sorted(HotelRoomComparators.BY_CAPACITY)
                .collect(Collectors.toList());
    }

    public static List<HotelRoom> findRoomsAboveCapacity(List<HotelRoom> rooms, int minCapacity) {
        return rooms.stream()
                .filter(room -> room.getCapacity() > minCapacity)
                .collect(Collectors.toList());
    }
}

