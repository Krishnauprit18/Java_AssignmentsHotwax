package main.java.com.example;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable {
    private String firstName;
    private Date dateOfBirth; // Changed from String to Date
    private Address address;
    private static final long serialVersionUID = 1L;


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
}