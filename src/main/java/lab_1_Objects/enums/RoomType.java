package lab_1_Objects.enums;

public enum RoomType {
    DELUXE,
    SUITE;

    public static RoomType fromString(String value) {
        try {
            return RoomType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("No constant with text " + value + " found in RoomType");
            return null;
        }
    }
}
