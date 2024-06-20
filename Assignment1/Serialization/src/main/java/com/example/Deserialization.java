package main.java.com.example;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserialization {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the input file name as a command line argument.");
            return;
        }

        String inputFileName = args[0];


        // Deserialize the list of Student objects from the specified file
        try (FileInputStream fis = new FileInputStream(inputFileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            List<Student> students = (List<Student>) ois.readObject();
            System.out.println("Deserialization successful. Data read from " + inputFileName);

            // Print the deserialized list of Student objects
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}