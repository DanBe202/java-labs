package classesLab;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a reservation made by a client for a specific room in a hotel.
 * Includes details about the room number, client, check-in and check-out dates, and payment status.
 */
public class Reservation {
    private int roomNumber;
    private Client client;
    private Date enterDate;
    private Date departureDate;
    private Boolean isPaid;

    /**
     * Constructs a new Reservation object with the specified details.
     *
     * @param roomNumber the number of the room reserved
     * @param client the Client who made the reservation
     * @param enterDate the date when the client will check in
     * @param departureDate the date when the client will check out
     * @param isPaid indicates whether the reservation has been paid for
     */
    public Reservation(int roomNumber, Client client, Date enterDate, Date departureDate, Boolean isPaid) {
        this.roomNumber = roomNumber;
        this.client = client;
        this.enterDate = enterDate;
        this.departureDate = departureDate;
        this.isPaid = isPaid;
    }

    /**
     * Returns the number of the room reserved.
     *
     * @return the room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns the Client who made the reservation.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Returns the check-in date for the reservation.
     *
     * @return the check-in date
     */
    public Date getEnterDate() {
        return enterDate;
    }

    /**
     * Returns the check-out date for the reservation.
     *
     * @return the check-out date
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * Returns whether the reservation has been paid for.
     *
     * @return {@code true} if the reservation is paid, {@code false} otherwise
     */
    public Boolean getIsPaid() {
        return isPaid;
    }

    /**
     * Returns a string representation of the reservation, including room number, client details,
     * check-in and check-out dates, and payment status.
     *
     * @return a string containing reservation details
     */
    @Override
    public String toString() {
        return "Reservation{" +
                "roomNumber=" + roomNumber +
                ", client=" + client +
                ", enterDate=" + enterDate +
                ", departureDate=" + departureDate +
                ", isPaid=" + isPaid +
                '}';
    }

    /**
     * Compares this Reservation object to another object for equality.
     * Two Reservation objects are considered equal if they have the same room number, client,
     * check-in and check-out dates, and payment status.
     *
     * @param o the object to compare to
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return roomNumber == that.roomNumber &&
                client.equals(that.client) &&
                enterDate.equals(that.enterDate) &&
                departureDate.equals(that.departureDate) &&
                isPaid.equals(that.isPaid);
    }

    /**
     * Returns the hash code value for this Reservation object.
     * The hash code is computed based on the room number, client, check-in and check-out dates,
     * and payment status.
     *
     * @return the hash code of the reservation
     */
    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, client, enterDate, departureDate, isPaid);
    }
}
