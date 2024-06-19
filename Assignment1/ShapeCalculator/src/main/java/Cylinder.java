package main.java;

/**
 * Cylinder class representing a cylinder shape.
 */
class Cylinder extends Shape{

    private double radius;
    private double height;

    Cylinder(double radius, double height){
        this.radius = radius;
        this.height = height;
    }

    @Override
    double calculateArea(){
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    double calculatePerimeter(){
        throw new UnsupportedOperationException("Cylinder doesn't have perimeter");
    }

    @Override
    double calculateCircumference() {
        throw new UnsupportedOperationException("Cylinder doesn't have circumference");
    }

    @Override
    double calculateVolume(){
        return Math.PI * radius * radius * height;
    }
}