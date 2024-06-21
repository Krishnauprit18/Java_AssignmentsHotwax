package main.java;

/**
 * Triangle class representing a triangle shape.
 */
class Triangle extends Shape{
    private final double base;
    private final double height;

    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea(){
        return 0.5 * base * height;
    }

    @Override
    double calculatePerimeter(){
        throw new UnsupportedOperationException("Perimeter calculation requires all 3 sides");
    }

    @Override
    double calculateCircumference(){
        throw new UnsupportedOperationException("Triangle doesn't have circumference");
    }

    @Override
    double calculateVolume(){
        throw new UnsupportedOperationException("Volume is calculated for 3-D shapes only");
    }
}