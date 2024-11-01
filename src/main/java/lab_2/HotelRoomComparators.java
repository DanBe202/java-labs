package lab_2;

import lab_1.HotelRoom;

import java.util.Comparator;

public class HotelRoomComparators {
    public static final Comparator<HotelRoom> BY_CAPACITY = Comparator.comparingInt(HotelRoom::getCapacity);
}

