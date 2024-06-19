package main.java.com.employee;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleMenu {
    private EmployeeManager employeeManager;
    private Scanner scanner;

    public ConsoleMenu(){
        this.employeeManager = new EmployeeManager();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        while(true){
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Search Employees");
            System.out.println("4. Sort Employees");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    searchEmployees();
                    break;
                case 4:
                    sortEmployees();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again...");
            }
        }
    }

    public void addEmployee(){
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter email address: ");
        String emailAddress = scanner.nextLine();

        System.out.println("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter date of birth: ");
        String Strdob = scanner.nextLine();
        LocalDate dob = LocalDate.parse(Strdob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Employee employee = new Employee(name, emailAddress, age, dob);
        employeeManager.addEmployees(employee);

        System.out.println("Employee added successfully");
    }

    public void deleteEmployee(){
        System.out.println("Enter employee email address: ");
        String email = scanner.nextLine();

        employeeManager.deleteEmployees(email);
        System.out.println("Employee deleted successfully");
    }

    public void searchEmployees(){
        System.out.println("Enter query to search: ");
        String query = scanner.nextLine();

        List<Employee> results = employeeManager.searchEmployees(query);

        System.out.println("Search Results: ");
        for(Employee e: results){
            System.out.println(e);
        }
    }

    public void sortEmployees(){
        System.out.println("Enter field to sort (name, age, dateOfBirth): ");
        String orderBy = scanner.nextLine();

        System.out.println("Enter direction (asc, dsc): ");
        String direction = scanner.nextLine();

        boolean ascending = direction.equalsIgnoreCase("asc");

        List<Employee> sortedList = employeeManager.sortEmplyees(orderBy, ascending);

        System.out.println("Sorted Employees: ");
        for(Employee e: sortedList){
            System.out.println(e);
        }
    }
}
