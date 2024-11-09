package lab_2_Collections;

import lab_1_Objects.HotelRoom;
import lab_1_Objects.enums.RoomType;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelRoomService {
    List<HotelRoom> rooms;

    public HotelRoomService(List<HotelRoom> rooms) {
        this.rooms = rooms;
    }

    public List<HotelRoom> filterRoomsByType(RoomType type) {
        return this.rooms.stream()
                .filter(room -> room.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<HotelRoom> sortRoomsByCapacity() {
        return this.rooms.stream()
                .sorted(Comparator.comparingInt(HotelRoom::getCapacity))
                .collect(Collectors.toList());
    }

    public List<HotelRoom> findRoomsAboveCapacity(int minCapacity) {
        return this.rooms.stream()
                .filter(room -> room.getCapacity() > minCapacity)
                .collect(Collectors.toList());
    }

    public List<HotelRoom> sorted() {
        return this.rooms.stream().sorted().toList();
    }
}

