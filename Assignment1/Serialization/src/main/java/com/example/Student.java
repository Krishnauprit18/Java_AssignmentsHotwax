package main.java.com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable {
    private String firstName;
    private Date dateOfBirth; // Changed from String to Date
    private Address address;
    private static final long serialVersionUID = 1L; // Serialization version UID
    private static final long OLD_SERIAL_VERSION_UID = 5461053639669178509L;


        // Date format pattern
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    // Constructor to initialize fields
    public Student(String firstName, String dateOfBirth, Address address) {
        this.firstName = firstName;
        this.address = address;
        try {
            // Parse the string date to Date object
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            this.dateOfBirth = sdf.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // toString method to display student information
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", dateOfBirth='" + sdf.format(dateOfBirth) + '\'' +
                ", address=" + address +
                '}';
    }

    // Custom serialization handling for backward compatibility
    private void writeObject(ObjectOutputStream out) throws IOException {
        // Write the default serialization
        out.defaultWriteObject();

        // Write the old serialVersionUID
        out.writeLong(OLD_SERIAL_VERSION_UID);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Read the default serialization
        in.defaultReadObject();

        // Read the old serialVersionUID
        long oldSerialVersionUID = in.readLong();

        // Handle old format data if necessary
        if (oldSerialVersionUID == OLD_SERIAL_VERSION_UID) {
            // Additional logic to handle old format data if required
            System.out.println("Handling old format data...");
        }
    }
}