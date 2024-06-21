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
        String queryLowerCase = query.toLowerCase();
        return employees.stream()
                .filter(e -> {
                    String fullnameLowerCase = e.getName().toLowerCase();
                    String[] parts = fullnameLowerCase.split("\\s+");

                    for(String part : parts){
                        if(part.startsWith(queryLowerCase)){
                            return true;
                        }
                    }
                    return e.getEmailAddress().toLowerCase().startsWith(queryLowerCase);
                })
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
            case "dateofbirth":
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


