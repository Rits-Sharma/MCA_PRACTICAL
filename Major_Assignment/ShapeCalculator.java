import java.util.Scanner;

interface Shape {
    double area();
    double perimeter();
}

class Circle implements Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14159 * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * 3.14159 * radius;
    }
}

class Rectangle implements Shape {
    double length, width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

class Triangle implements Shape {
    double sA, sB, sC;
    public Triangle(double sA, double sB, double sC) {
        this.sA = sA;
        this.sB = sB;
        this.sC = sC;
    }
    public boolean isValidTriangle() {
        return (sA + sB > sC && sA + sC > sB && sB + sC > sA);
    }

    @Override
    public double area() {
        if(!isValidTriangle()) {
            System.out.println("Invalid triangle sides.");
            return 0;
        }
        double s = (sA + sB + sC) / 2;
        return Math.sqrt(s * (s - sA) * (s - sB) * (s - sC));
    }

    @Override
    public double perimeter() {
        if(!isValidTriangle()) {
            return 0;
        }
        return (sA + sB + sC);
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Choose Shape:");
            System.out.println("1. Circle\n2. Rectangle\n3. Triangle\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            Shape shape = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    shape = new Circle(r);
                    break;

                case 2:
                    System.out.print("Enter length and width: ");
                    double l = sc.nextDouble();
                    double w = sc.nextDouble();
                    shape = new Rectangle(l, w);
                    break;

                case 3:
                    System.out.print("Enter side A,B and C: ");
                    double a = sc.nextDouble();
                    double b = sc.nextDouble();
                    double c = sc.nextDouble();
                    shape = new Triangle(a, b, c);
                    break;
                
                case 0:
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            if(shape != null) {
                displayInfo(shape);
            }
        }while(choice != 0);
        sc.close();
    }   

    public static void displayInfo(Shape shape) {
        double area = shape.area();
        double perimeter = shape.perimeter();
        if(area == 0 || perimeter == 0) return;
        String shapeType;
        if (shape instanceof Circle) shapeType = "Circle";
        else if (shape instanceof Rectangle) shapeType = "Rectangle";
        else shapeType = "Triangle";
        System.out.println(shapeType + " - Area: " + area + ", Perimeter: " + perimeter);
    }

}

