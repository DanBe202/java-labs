package lab_1_Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lab_1_Objects.enums.RoomFeature;
import lab_1_Objects.enums.RoomType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a hotel room with details about room number, type, capacity, features, and reservations.
 */
public class HotelRoom implements Comparable<HotelRoom> {
    private int id;
    private String number;
    private RoomType type;
    private int capacity;
    private int hotelId;
    private List<RoomFeature> features;
    private List<Reservation> reservations;

    public HotelRoom() {}

    /**
     * Constructs a new HotelRoom object using the Builder.
     *
     * @param builder the Builder object containing the values for the room
     */
    private HotelRoom(Builder builder) {
        this.id = builder.id;
        this.number = builder.number;
        this.type = builder.type;
        this.capacity = builder.capacity;
        this.features = builder.features;
        this.hotelId = builder.hotelId;
        this.reservations = builder.reservations;
    }

    public int getId() {
        return this.id;
    }

    /**
     * Returns the room number.
     *
     * @return the room number
     */
    public String getNumber() {
        return this.number;
    }

    public HotelRoom setNumber(String number) {
        this.number = number;
        return this;
    }

    public int getHotelId() {
        return hotelId;
    }

    public HotelRoom setHotelId(int hotelId) {
        this.hotelId = hotelId;
        return this;
    }

    /**
     * Returns the room type.
     *
     * @return the room type
     */
    public RoomType getType() {
        return this.type;
    }

    @JsonIgnore
    public String getTypeString() {
        return this.type.toString();
    }

    /**
     * Returns the capacity of the room (i.e., how many people it can accommodate).
     *
     * @return the room capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    public HotelRoom setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    /**
     * Returns the room's features (e.g., sea view, balcony, air conditioning).
     *
     * @return the room features
     */
    public List<RoomFeature> getFeatures() {
        return this.features;
    }

    @JsonIgnore
    public String getFeaturesString() {
        return this.features.toString().replace("[", "").replace("]", "");
    }

    /**
     * Returns the reservations associated with the room.
     *
     * @return a List of Reservation objects for the room
     */
    public List<Reservation> getReservations() {
        return this.reservations;
    }

    /**
     * Sets the reservations for the room.
     *
     * @param reservations an array of Reservation objects to be assigned to the room
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * The builder class used to create HotelRoom objects.
     */
    public static class Builder {
        private int id;
        private String number;
        private RoomType type;
        private int capacity;
        private int hotelId;
        private List<RoomFeature> features;
        private List<Reservation> reservations;

        /**
         * Sets the room id.
         *
         * @param id the room id to be set
         * @return the Builder object
         */
        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        /**
         * Sets the room type.
         *
         * @param type the room type to be set
         * @return the Builder object
         */
        public Builder setType(RoomType type) {
            this.type = type;
            return this;
        }
        /**
         * Sets the room capacity.
         *
         * @param capacity the capacity of the room
         * @return the Builder object
         */
        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }


        /**
         * Sets the room capacity.
         *
         * @param hotelId the id of the hotel
         * @return the Builder object
         */
        public Builder setHotelId(int hotelId) {
            this.hotelId = hotelId;
            return this;
        }

        /**
         * Sets the room features.
         *
         * @param featuresString the features of the room in String form
         * @return the Builder object
         */
        public Builder setFeatures(String featuresString) {
            if (featuresString != null && !featuresString.isEmpty()) {
                this.features = Arrays.stream(featuresString.split("\\s*,\\s*"))
                        .filter(feature -> feature != null && !feature.isEmpty())
                        .map(RoomFeature::fromString)
                        .collect(Collectors.toList());
            } else {
                this.features = List.of();
            }
            return this;
        }

        /**
         * Sets the room features.
         *
         * @param features the features of the room
         * @return the Builder object
         */
        public Builder setFeatures(List<RoomFeature> features) {
            this.features = features;
            return this;
        }

        /**
         * Sets the reservations for the room.
         *
         * @param reservations the array of Reservation objects to be set
         * @return the Builder object
         */
        public Builder setReservations(List<Reservation> reservations) {
            this.reservations = reservations;
            return this;
        }

        /**
         * Builds a new HotelRoom object using the current Builder settings.
         *
         * @return a new HotelRoom object
         */
        public HotelRoom build() {
            List<String> errors = validateFields();
            if (!errors.isEmpty()) {
                throw new IllegalArgumentException("Invalid field values: " + String.join("; ", errors));
            }
            return new HotelRoom(this);
        }

        private List<String> validateFields() {
            List<String> errors = new ArrayList<>();

            if (id <= 0) {
                errors.add("Invalid number: '" + number + "'. Must be non-empty and contain only uppercase letters and numbers.");
            }
            if (number == null || number.isEmpty() || !number.matches("^[A-Z0-9]+$")) {
                errors.add("Invalid number: '" + number + "'. Must be non-empty and contain only uppercase letters and numbers.");
            }
            if (type == null) {
                errors.add("Room type cannot be null.");
            }
            if (capacity <= 0) {
                errors.add("Invalid capacity: " + capacity + ". Must be greater than zero.");
            }
            if (features == null || features.isEmpty()) {
                errors.add("Room features cannot be null or empty.");
            }
            return errors;
        }
    }

    /**
     * Returns a string containing information about the room, including its number, type, capacity, features, and reservations.
     *
     * @return a string representation of the room
     */
    @Override
    public String toString() {
        String room = "HotelRoom{" +
                "id=" + this.id +
                ", roomNumber=" + this.number +
                ", roomType='" + this.type + '\'' +
                ", capacity=" + this.capacity +
                ", features='" + this.features;
        if (this.reservations != null) {
            room += "'\\'', reservations=" + this.reservations + '}';
            return room;
        }
        return room + '}';
    }

    /**
     * Compares this HotelRoom object to another object for equality.
     *
     * @param o the object to compare to
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoom hotelRoom = (HotelRoom) o;
        return this.number.equals(hotelRoom.number);
    }

    /**
     * Returns a hash code value for the HotelRoom.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int result = this.type.hashCode();
        result += this.number.hashCode();
        return result;
    }

    @Override
    public int compareTo(HotelRoom other) {
        return this.number.compareTo(other.number);
    }
}
