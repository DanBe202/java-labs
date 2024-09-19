package classesLab;

import java.util.Arrays;

/**
 * Represents a hotel room with details about room number, type, capacity, features, and reservations.
 */
public class HotelRoom {
    private int roomNumber;
    private String roomType;
    private int capacity;
    private String features;
    private Reservation[] reservations;

    /**
     * Constructs a new HotelRoom object using the Builder.
     *
     * @param builder the Builder object containing the values for the room
     */
    private HotelRoom(Builder builder) {
        this.roomNumber = builder.roomNumber;
        this.roomType = builder.roomType;
        this.capacity = builder.capacity;
        this.features = builder.features;
        this.reservations = builder.reservations;
    }

    /**
     * Returns the room number.
     *
     * @return the room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }


    /**
     * Returns the room type.
     *
     * @return the room type
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Returns the capacity of the room (i.e., how many people it can accommodate).
     *
     * @return the room capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the room's features (e.g., sea view, balcony, air conditioning).
     *
     * @return the room features
     */
    public String getFeatures() {
        return features;
    }

    /**
     * Returns the reservations associated with the room.
     *
     * @return an array of Reservation objects for the room
     */
    public Reservation[] getReservations() {
        return reservations;
    }

    /**
     * Sets the reservations for the room.
     *
     * @param reservations an array of Reservation objects to be assigned to the room
     */
    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }

    /**
     * The builder class used to create HotelRoom objects.
     */
    public static class Builder {
        private int roomNumber;
        private String roomType;
        private int capacity;
        private String features;
        private Reservation[] reservations;

        /**
         * Sets the room number.
         *
         * @param roomNumber the room number to be set
         * @return the Builder object
         */
        public Builder setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        /**
         * Sets the room type.
         *
         * @param roomType the room type to be set
         * @return the Builder object
         */
        public Builder setRoomType(String roomType) {
            this.roomType = roomType;
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
         * Sets the room features.
         *
         * @param features the features of the room
         * @return the Builder object
         */
        public Builder setFeatures(String features) {
            this.features = features;
            return this;
        }

        /**
         * Sets the reservations for the room.
         *
         * @param reservations the array of Reservation objects to be set
         * @return the Builder object
         */
        public Builder setReservations(Reservation[] reservations) {
            this.reservations = reservations;
            return this;
        }

        /**
         * Builds a new HotelRoom object using the current Builder settings.
         *
         * @return a new HotelRoom object
         */
        public HotelRoom build() {
            return new HotelRoom(this);
        }
    }

    /**
     * Returns a string containing information about the room, including its number, type, capacity, features, and reservations.
     *
     * @return a string representation of the room
     */
    @Override
    public String toString() {
        return "HotelRoom{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", capacity=" + capacity +
                ", features='" + features + '\'' +
                ", reservations=" + Arrays.toString(reservations) +
                '}';
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
        return roomNumber == hotelRoom.roomNumber &&
                capacity == hotelRoom.capacity &&
                roomType.equals(hotelRoom.roomType) &&
                features.equals(hotelRoom.features) &&
                Arrays.equals(reservations, hotelRoom.reservations);
    }

    /**
     * Returns a hash code value for the HotelRoom.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int result = roomType.hashCode();
        result = 31 * result + roomNumber;
        result = 31 * result + capacity;
        result = 31 * result + features.hashCode();
        result = 31 * result + Arrays.hashCode(reservations);
        return result;
    }
}
