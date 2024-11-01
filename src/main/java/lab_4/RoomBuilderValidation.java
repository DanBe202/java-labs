package lab_4;

import lab_1.enums.RoomType;
import lab_1.enums.RoomFeature;
import java.util.List;

public class RoomBuilderValidation {
    public static void validateNumber(String number) {
        if (number == null || number.isEmpty() || !number.matches("^[A-Z0-9]+$")) {
            throw new IllegalArgumentException("Invalid room number: '" + number + "'. Room number must be non-empty and contain only uppercase letters and numbers.");
        }
    }

    public static void validateType(RoomType type) {
        if (type == null) {
            throw new IllegalArgumentException("Room type cannot be null.");
        }
    }

    public static void validateCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity: " + capacity + ". Capacity must be greater than zero.");
        }
    }

    public static void validateFeatures(List<RoomFeature> features) {
        if (features == null || features.isEmpty()) {
            throw new IllegalArgumentException("Room features cannot be null or empty.");
        }
    }
}

