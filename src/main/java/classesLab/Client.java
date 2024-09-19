package classesLab;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a client with personal details including their name, document status, and date of birth.
 */
public class Client {
    private String firstName;
    private String lastName;
    private Boolean documents;
    private Date dateOfBirth;

    /**
     * Constructs a new Client object with the specified details.
     *
     * @param firstName the first name of the client
     * @param lastName the last name of the client
     * @param documents the document status of the client (e.g., whether documents are provided)
     * @param dateOfBirth the date of birth of the client
     */
    public Client(String firstName, String lastName, Boolean documents, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documents = documents;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns a string representation of the client, including their first name, last name, document status, and date of birth.
     *
     * @return a string containing the client's details
     */
    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", documents=" + documents +
                ", dateOfBirth=" + dateOfBirth +
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
        return firstName.equals(client.firstName) &&
                lastName.equals(client.lastName) &&
                documents.equals(client.documents) &&
                dateOfBirth.equals(client.dateOfBirth);
    }

    /**
     * Returns the hash code value for this Client object.
     * The hash code is computed based on the client's first name, last name, document status, and date of birth.
     *
     * @return the hash code of the client
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, documents, dateOfBirth);
    }

    /**
     * Returns the first name of the client.
     *
     * @return the first name of the client
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the client.
     *
     * @return the last name of the client
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Returns the date of birth of the client.
     *
     * @return the date of birth of the client
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Returns the document status of the client.
     *
     * @return {@code true} if the client has provided documents, {@code false} otherwise
     */
    public boolean getDocuments() {
        return documents;
    }
}
