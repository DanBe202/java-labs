package lab_1_Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a client with personal details including their name, document status, and date of birth.
 */
public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String passportId;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Client() {
    }

    /**
     * Constructs a new Client object with the specified details.
     *
     * @param firstName   the first name of the client
     * @param lastName    the last name of the client
     * @param passportId  the document status of the client (e.g., whether documents are provided)
     * @param dateOfBirth the date of birth of the client
     */
    public Client(int id, 
                  String firstName,
                  String lastName,
                  String passportId,
                  LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return this.id;
    }

    public Client setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the first name of the client.
     *
     * @return the first name of the client
     */
    public String getFirstName() {
        return this.firstName;
    }

    public Client setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    /**
     * Returns the last name of the client.
     *
     * @return the last name of the client
     */
    public String getLastName() {
        return this.lastName;
    }

    public Client setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Returns the date of birth of the client.
     *
     * @return the date of birth of the client
     */
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Client setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * Returns the document status of the client.
     *
     * @return {@code true} if the client has provided documents, {@code false} otherwise
     */
    public String getPassportId() {
        return this.passportId;
    }

    public Client setPassportId(String passportId) {
        this.passportId = passportId;
        return this;
    }

    /**
     * Returns a string representation of the client, including their first name, last name, document status, and date of birth.
     *
     * @return a string containing the client's details
     */
    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", passportId=" + this.passportId +
                ", dateOfBirth=" + this.dateOfBirth +
                '}';
    }

    /**
     * Compares this Client object to another object for equality.
     * Two Client objects are considered equal if they have the same first name, last name, document status, and date of birth.
     *
     * @param o the object to compare to
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return this.firstName.equals(client.firstName) &&
                this.lastName.equals(client.lastName) &&
                this.passportId.equals(client.passportId) &&
                this.dateOfBirth.equals(client.dateOfBirth);
    }

    /**
     * Returns the hash code value for this Client object.
     * The hash code is computed based on the client's first name, last name, document status, and date of birth.
     *
     * @return the hash code of the client
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName, this.passportId, this.dateOfBirth);
    }
}
