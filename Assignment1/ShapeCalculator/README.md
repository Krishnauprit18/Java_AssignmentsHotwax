# Assignment - 1

Problem Statement - 2
Write a program that accepts user inputs as follows and perform certain operations and displays the results on the console. The program must keep running and must not exit.

The program is supposed to ask the shape (Circle, Reactange, etc) and calculate the area, perimeter and volume (if the shape selected is 3-D) and display the result. The program should make a pre-configured menu and display on the console on start up to present the various shape choices to the users
Depending on the shape entered by the user, the program must ask additional questions/input parameters from the user. For example, if Circle is entered, it must ask for the radius (r). If Triangle is entered, the program must ask for base (b) and height (h).
Again, use appropriate terminology for the shape in question. Distinguish between when to calculate what - Area, Circumference, Volume, Perimeter.
Once all information is entered, display the result to the user on the console.


Notes
Follow appropriate OOPs design principles to design this program.
Proper exception handling should be done. 
Dedicated Exception classes must be created and thrown. 

Code Workflow: 

I). Shape.java
 - The Abstract classes servers the blueprint for all geometric shapes.
 - The abstract methods are used to calculate the area, perimeter, circumference(for circle) and volume(for 3-D shapes).
 - The abstract methods include:- 
 1. calculateArea()
 2. calculatePerimeter()
 3. calculateCircumeference()
 4. calculateVolume()
 
II). Circle.java
 - This represents the circle shape and extends the shape class.
 - It has a constructor that initializes the radius field.
 - The calculateArea() method is overriden and calculate the area of circle.
 - The calculatePerimeter() method throws UnsupportedOperationException because circles donot have perimeter they have circumference.
 - The calculateCircumference() method is used to calculate the circumference of the circle.
 - the calculateVolume() method throws UnsupportedOperationException bacause volume is calculated for 3-D objects.

III). Square.java:
 - This represents the square shape and extends the shape class.
 - It has a constructor that initializes the side field.
 - All methods are used to provide the specific functionalities and exception handling.
 
 Rest all other shapes also show similar behaviour.
 
IV). InvalidDimensionException.java
 - This is thrown when the input dimension of the shape is invalid.
 - It extends Exception class making it checked Exception.
 - The constructor takes messages as its parameters and passes it to its superclass Exception class using super().

V). InvalidShapeException.java
 - This is thrown when an invalid shape is selected.
 - This is also a checked Excpetion.
 
VI). After creating shape object the program calls the displayResult method, passing the created shape object.
This method then calculates the area, perimeter, circumference and volume and displays the result.

VII). The program continues to loop until the user selectes 7 to exit the program.
