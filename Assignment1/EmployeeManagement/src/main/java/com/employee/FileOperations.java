package main.java.com.employee;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    public static final String FILE_PATH = "src/resources/employee.txt";

    public static List<Employee> readEmployeesFromFile(){
        List<Employee> employees = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while((line = reader.readLine()) != null){
                employees.add(Employee.fromString(line));
            }
        }
        catch(IOException e){
            e.printStackTrace();;
        }
        return employees;
    }

    public static void writeEmployeesToFile(List<Employee> employees){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
            for(Employee employee : employees){
                writer.write(employee.toString());
                writer.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
