interface Shape {
    void area();
    void perimeter();
    void displayInfo();
}
class Circle implements Shape {
    double radius;
    public Circle(double radius) { this.radius = radius; }
    public void area() {
        System.out.println("Area of circle: " + (3.14159 * radius * radius));
    }
    public void perimeter() {
        System.out.println("Circumference of circle: " + (2 * 3.14159 * radius));
    }
    public void displayInfo() {
        area(); perimeter();
    }
}
class Rectangle implements Shape {
    double length, width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public void area() {
        System.out.println("Area of rectangle: " + (length * width));
    }
    public void perimeter() {
        System.out.println("Perimeter of rectangle: " + (2 * (length + width)));
    }
    public void displayInfo() {
        area(); perimeter();
    }
}
public class ShapeCal {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(15, 10);
        r.displayInfo();
        Circle c = new Circle(7);
        c.displayInfo();
    }
}
