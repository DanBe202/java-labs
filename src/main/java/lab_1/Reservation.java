package lab_1;

import lab_1.enums.PaymentStates;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a reservation made by a client for a specific room in a hotel.
 * Includes details about the room number, client, check-in and check-out dates, and payment status.
 */
public class Reservation {
    private final HotelRoom room;
    private final Client client;
    private final LocalDate enterDate;
    private final LocalDate departureDate;
    private final PaymentStates payment;

    /**
     * Constructs a new Reservation object with the specified details.
     *
     * @param room the reserved room
     * @param client the Client who made the reservation
     * @param enterDate the date when the client will check in
     * @param departureDate the date when the client will check out
     * @param payment indicates whether the reservation has been paid for
     */
    public Reservation(HotelRoom room, Client client, LocalDate enterDate, LocalDate departureDate, PaymentStates payment) {
        this.room = room;
        this.client = client;
        this.enterDate = enterDate;
        this.departureDate = departureDate;
        this.payment = payment;
    }

    /**
     * Returns the number of the room reserved.
     *
     * @return the room number
     */
    public HotelRoom getRoomNumber() {
        return this.room;
    }

    /**
     * Returns the Client who made the reservation.
     *
     * @return the client
     */
    public Client getClient() {
        return this.client;
    }

    /**
     * Returns the check-in date for the reservation.
     *
     * @return the check-in date
     */
    public LocalDate getEnterDate() {
        return this.enterDate;
    }

    /**
     * Returns the check-out date for the reservation.
     *
     * @return the check-out date
     */
    public LocalDate getDepartureDate() {
        return this.departureDate;
    }

    /**
     * Returns whether the reservation has been paid for.
     *
     * @return {@code true} if the reservation is paid, {@code false} otherwise
     */
    public PaymentStates getPayment() {
        return this.payment;
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
                "room=" + this.room.getNumber() +
                ", client=" + this.client +
                ", enterDate=" + this.enterDate +
                ", departureDate=" + this.departureDate +
                ", paymentStatus=" + this.payment +
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
        return this.room == that.room &&
                this.client.equals(that.client) &&
                this.enterDate.equals(that.enterDate) &&
                this.departureDate.equals(that.departureDate) &&
                this.payment.equals(that.payment);
    }

    /**
     * Returns the hash code value for this Reservation object.
     * The hash code is computed based on the room number, client, check-in and check-out dates.
     *
     * @return the hash code of the reservation
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.room, this.client, this.enterDate, this.departureDate);
    }
}
