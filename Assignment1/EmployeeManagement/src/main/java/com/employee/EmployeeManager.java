package main.java.com.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager(){
        this.employees = FileOperations.readEmployeesFromFile();
    }

    public void addEmployees(Employee employee){
        employees.add(employee);
        saveEmployees();
    }

    public void deleteEmployees(String employeeID){
        employees = employees.stream()
                .filter(e -> !e.getEmailAddress().equals(employeeID))
                .collect(Collectors.toList());
        saveEmployees();
    }

    public List<Employee> searchEmployees(String query){
        return employees.stream()
                .filter(e -> e.getName().contains(query) || e.getEmailAddress().contains(query))
                .collect(Collectors.toList());
    }

    public List<Employee> sortEmplyees(String orderBy, boolean ascending){
        List<Employee> sortedList = new ArrayList<>(employees);
        Comparator<Employee> comparator;

        switch(orderBy.toLowerCase()){
            case "name":
                comparator = Comparator.comparing(Employee::getName);
                break;
            case "age":
                comparator = Comparator.comparing(Employee::getAge);
                break;
            case "dateOfBirth":
                comparator = Comparator.comparing(Employee::getDateOfBirth);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort field: " + orderBy);
        }

        if(!ascending){
            comparator = comparator.reversed();
        }

        sortedList.sort(comparator);
        return sortedList;
    }

    public void saveEmployees(){
        FileOperations.writeEmployeesToFile(employees);
    }
}


