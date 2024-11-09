package lab_1_Objects.enums;

public enum RoomFeature {
    OCEAN_VIEW,
    KING_BED,
    MINI_BAR,
    MOUNTAIN_VIEW,
    QUEEN_BED,
    KITCHENETTE;

    public static RoomFeature fromString(String value) {
        try {
            return RoomFeature.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("No constant with text " + value + " found in RoomFeature");
            return null;
        }
    }
}
