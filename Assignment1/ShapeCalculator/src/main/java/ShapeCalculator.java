package main.java;

/**
 * Main class to calculate area, perimeter and volume of different shapes.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select the shape to calculate area, perimeter, volume for:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Square");
            System.out.println("5. Sphere");
            System.out.println("6. Cylinder");
            System.out.println("7. Exit");

            System.out.println("Enter your choice: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7");
                scanner.nextInt();
                continue;
            }

            if (choice == 7) {
                System.out.println("Exiting the program...");
                break;
            }

            Shape shape = null;
            switch (choice) {
                case 1:
                    shape = createCircle(scanner);
                    break;
                case 2:
                    shape = createRectangle(scanner);
                    break;
                case 3:
                    shape = createTriangle(scanner);
                    break;
                case 4:
                    shape = createSquare(scanner);
                    break;
                case 5:
                    shape = screateSphere(scanner);
                    break;
                case 6:
                    shape = createCylinder(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter valid choice");
                    break;
            }

            if (shape != null) {
                displayResults(shape);
            }
        }
        scanner.close();
    }

    public static Circle createCircle(Scanner scanner) {
        try {
            System.out.println("Enter radius: ");
            double radius = scanner.nextDouble();

            if (radius <= 0) {
                throw new InvalidDimensionException("Radius must be positive");
            }
            return new Circle(radius);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number");
            scanner.next();
            return null;
        } catch (InvalidDimensionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Rectangle createRectangle(Scanner scanner) {
        try {
            System.out.println("Enter the length of rectangle: ");
            double length = scanner.nextDouble();

            System.out.println("Enter the width of rectangle: ");
            double width = scanner.nextDouble();

            if (length <= 0 || width <= 0) {
                throw new InvalidDimensionException("Length and Width must be positive");
            }
            return new Rectangle(length, width);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers");
            scanner.next();
            return null;
        } catch (InvalidDimensionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Triangle createTriangle(Scanner scanner) {
        try {
            System.out.println("Enter the base of Triangle: ");
            double base = scanner.nextDouble();

            System.out.println("Enter the height of Triangle: ");
            double height = scanner.nextDouble();

            if (base <= 0 || height <= 0) {
                throw new InvalidDimensionException("Base and Height must be positive");
            }
            return new Triangle(base, height);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers");
            scanner.next();
            return null;
        } catch (InvalidDimensionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Square createSquare(Scanner scanner) {
        try {
            System.out.println("Enter the side of Square: ");
            double side = scanner.nextDouble();

            if (side <= 0) {
                throw new InvalidDimensionException("Side must be a positive number");
            }
            return new Square(side);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid number");
            scanner.next();
            return null;
        } catch (InvalidDimensionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Sphere screateSphere(Scanner scanner) {
        try {
            System.out.println("Enter radius of Sphere: ");
            double radius = scanner.nextDouble();

            if (radius <= 0) {
                throw new InvalidDimensionException("Radius must be a positive number");
            }
            return new Sphere(radius);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number");
            scanner.next();
            return null;
        } catch (InvalidDimensionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Cylinder createCylinder(Scanner scanner) {
        try {
            System.out.println("Enter the radius of the cylinder: ");
            double radius = scanner.nextDouble();

            System.out.println("Enter height of cylinder: ");
            double height = scanner.nextDouble();

            if (radius <= 0 || height <= 0) {
                throw new InvalidDimensionException("Radius and Height must be positive");
            }
            return new Cylinder(radius, height);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers");
            scanner.next();
            return null;
        } catch (InvalidDimensionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void displayResults(Shape shape) {
        System.out.println("Area: " + shape.calculateArea());
        try {
            if (shape instanceof Circle) {
                System.out.println("Circumference: " + ((Circle) shape).calculateCircumference());
            } else {
                System.out.println("Perimeter: " + shape.calculatePerimeter());
            }
        } catch (UnsupportedOperationException e) {
            // Do nothing as some shapes don't have a perimeter
        }
        try {
            System.out.println("Volume: " + shape.calculateVolume());
        } catch (UnsupportedOperationException e) {
            // Do nothing as some shapes don't have volume
        }
    }
}