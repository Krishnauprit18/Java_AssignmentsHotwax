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
        Address address1 = new Address("Indore", "MP", 123456, "India");
        Address address2 = new Address("Bhopal", "MP", 234567, "India");
        Address address3 = new Address("Nagpur", "Maharashtra", 345678, "India");
        Address address4 = new Address("Jaipur", "Rajasthan", 456789, "India");

        // Create Student objects
        Student student1 = new Student("Krishna", "2004-01-01", address1);
        Student student2 = new Student("Avijit", "2005-01-02", address2);
        Student student3 = new Student("Aditya", "2007-03-09", address3);
        Student student4 = new Student("Sarthak", "2006-04-05", address4);


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