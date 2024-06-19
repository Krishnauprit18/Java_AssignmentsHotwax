# Assignment 1

Problem Statement - 3

Write a program to implement searching and sorting operations on Employee class objects.

Create a class Employee with following properties. The class should follow javabean standards..
Name
Email Address
Age
Date Of Birth
Start with a large amount of comma separated data stored in a text file (employees.txt) and provide menu options on console like below -
Add
If selected/entered, provide following menu options for creating an employee -
Name
Email Address
Age
DOB
Pressing enter should create a record in the file and file should be updated.

Delete
If selected, prompt to enter the employee ID that needs to be deleted. If employee ID exists, delete it from the TXT file.
Search
If selected, prompt for the following -
Query (text to search)
Sort (Order By) 
Direction (ascending or descending)
Pressing enter should search based on the criteria and display the result on the console.
Use appropriate Collection classes wherever necessary and in order to perform faster search, load up all data in the Collection and perform searching/sorting operations on the Collection instead of File.


Features:-
1. Add Employee: Add a new employee to the system.
2. Delete Employee: Remove an existing employee from the system.
3. Search Employees: Search for employees by name or email address.
4. Sort Employees: Sort employees by name, age, or date of birth.
5. Persist Data: Employee data is stored in a text file (employees.txt).

Workflow:-
1. Initialization:
 - The main class initializes the console menu.
 - The console Menu initialized EmployeeManager, which loads employee data from employees.txt using FileOperations.
 
 2. Menu Display:
  - The ConsoleMenu displays the menu with options to add, delete, search, sort, Exit.
 
 3. Add Employee:
  - User selected addEmployee.
  - Console promts user for employee details (name, age, date of birth, email).
  - An employee object is created and added to the list in EmployeeManager.
  - The list is saved to the file using FileOperations.
 
 4. DeleteEmployee:
  - User selects deleEmployee.
  - The console ask user for employee's email address to delete that employee.
  - EmployeeManager delete the employee from the list if the email matches.
  - The update list is saved to the file using FileOperations.
  
 5. SearchEmployees:
  - User selects searchEmployees.
  - The console ask user to enter the search query (name, age, etc...).
  - EmployeeManager searches the list for matching employees by the entered query.
  - If a match was found the emaployee details was displayed.
  
 6. SortEmployees:
  - User selects sortEmployees.
  - The console ask user to enter promt for sorted field (name, age, DOB) and direction (ascending, descending).
  - EmployeeManager sorts the list based on the specified field and direction.
  - The sorted list is displayed.
 
 7. Exit:
  - User selects Exit
  - The program ternimates.
  
  Sample employees.txt file:-
  
  Rahul Yadav,18,12/09/2005
  reshma singh,19,23/08/2004
  roshan,17,15/04/2006
  
How to Run:
 - Create the directory structure as shown above.
 - Place the Java files in the appropriate package directory (com/employee).
 - Place the employees.txt file in the resources directory.
 - Open the project in IntelliJ IDEA.
 - Run the Main class to start the application.
    
Notes:
 - The application uses LocalDate for handling dates. Make sure to input dates in the format dd/MM/yyyy.
 - The employees.txt file should be in the src/resources directory for the application to read and write employee data.
 - The search functionality is case insensitive and matches any part of the name or the start of the email address.
