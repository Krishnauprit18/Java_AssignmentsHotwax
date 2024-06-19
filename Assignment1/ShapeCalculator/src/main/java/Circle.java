package main.java;

/**
 * Circle class representing a circle shape.
 */
class Circle extends Shape {
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    double calculateArea(){
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        throw new UnsupportedOperationException("Circle does not have a perimeter, it has a circumference.");
    }

    /**
     * Calculates the circumference of the circle.
     * @return The circumference of the circle.
     */
    @Override
    double calculateCircumference(){
        return 2 * Math.PI * radius;
    }

    @Override
    double calculateVolume(){
        throw new UnsupportedOperationException("Volume is calculated for 3-D shapes only");
    }
}