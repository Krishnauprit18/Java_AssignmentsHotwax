package main.java;

/**
 * Abstract class representing a geometric shape.
 */
abstract class Shape{

    /**
     * Calculates the area of the shape.
     * @return The area of the shape
     */
    abstract double calculateArea();

    /**
     * Calculates the Perimeter of the shape.
     * @return The perimeter of the shape
     */
    abstract double calculatePerimeter();

    /**
     * Calculates the Circumference of Circle.
     * @return The Circumference of the circle
     */
    abstract double calculateCircumference();

    /**
     * Calculates the Volume of the shape.
     * Only applicable for 3-D shapes
     * @return The volume of the shape
     */
    abstract double calculateVolume();
}