package main.java.com.example;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the output file name as a command line argument.");
            return;
        }

        String outputFileName = args[0];

        // Create Address objects
        Address address1 = new Address("City1", "State1", 123456, "Country1");
        Address address2 = new Address("City2", "State2", 234567, "Country2");
        Address address3 = new Address("City3", "State3", 345678, "Country3");
        Address address4 = new Address("City4", "State4", 456789, "Country4");

        // Create Student objects
        Student student1 = new Student("John", "2000-01-01", address1);
        Student student2 = new Student("Jane", "2001-02-02", address2);
        Student student3 = new Student("Jim", "2002-03-03", address3);
        Student student4 = new Student("Jill", "2003-04-04", address4);


        // Create a list of Student objects
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        // Serialize the list of Student objects to the specified file
        try (FileOutputStream fos = new FileOutputStream(outputFileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(students);
            System.out.println("Serialization successful. Data saved to " + outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}