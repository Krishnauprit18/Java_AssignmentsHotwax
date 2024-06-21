package main.java;

/**
 * Circle Rectangle representing a rectangle shape.
 */
class Rectangle extends Shape {
    private final double length;
    private final double width;

    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea(){
        return length * width;
    }

    @Override
    double calculatePerimeter(){
        return 2 * (length + width);
    }

    @Override
    double calculateCircumference(){
        throw new UnsupportedOperationException("Rectangle doesn't have circumference");
    }

    @Override
    double calculateVolume(){
        throw new UnsupportedOperationException("Volume is calculated for 3-D shapes only");
    }
}