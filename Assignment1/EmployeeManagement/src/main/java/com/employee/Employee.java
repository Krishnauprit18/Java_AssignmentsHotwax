package main.java.com.employee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String name;
    private String emailAddress;
    private int age;
    private LocalDate dateOfBirth;

    public Employee(String name, String emailAddress, int age, LocalDate dateOfBirth){
        this.name = name;
        this.emailAddress = emailAddress;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return name + "," + emailAddress + "," + age + "," + dateOfBirth.format(formatter);
    }

    public static Employee fromString(String str){
        String[] parts = str.split(",");
        String name = parts[0];
        String emailAddress = parts[1];
        int age = Integer.parseInt(parts[2]);
        LocalDate dateOfBirth = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return new Employee(name, emailAddress, age, dateOfBirth);
    }
}
