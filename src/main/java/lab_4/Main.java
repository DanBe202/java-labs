package lab_4;

import lab_1.HotelRoom;
import lab_1.enums.RoomFeature;
import lab_1.enums.RoomType;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void  main(String[] args) {
        HotelRoom room101 = new HotelRoom.Builder()
                .setNumber("A101")
                .setType(RoomType.DELUXE)
                .setCapacity(2)
                .setFeatures(Arrays.asList(RoomFeature.OCEAN_VIEW, RoomFeature.KING_BED, RoomFeature.MINI_BAR))
                .setReservations(List.of())
                .build();

        HotelRoom room102 = new HotelRoom.Builder()
                .setNumber("A10-2")
                .setType(RoomType.SUITE)
                .setCapacity(4)
                .setFeatures(Arrays.asList(RoomFeature.MOUNTAIN_VIEW, RoomFeature.QUEEN_BED, RoomFeature.KITCHENETTE))
                .setReservations(List.of())
                .build();
    }
}
