/*
 * 5. Write an abstract class Shape that has a parameterized constructor to initialize the color of the shape. Extend this class in Circle and Rectangle, which will have their own additional parameters (like radius, length, width). Ensure proper constructor calls using super().
 */

abstract class shape {
    String color;

    public shape(String color){
        this.color = color;
    }
    abstract void getInfo();
}

class Circle extends shape{
    int radius;
    public Circle(int radius, String color){
        super(color);
        this.radius = radius;
    }
    void getInfo(){
        System.out.println("Circle of color " + color + " with radius " + radius);
    }
}

class Rectangle extends shape{
    int length, width;
    public Rectangle(int length, int width, String color){
        super(color);
        this.length = length;
        this.width = width;
    }
    void getInfo(){
        System.out.println("Rectangle of color " + color + " with length " + length + " and width " + width);
    }
}

public class question5 {
    public static void main(String[] args) {
        shape circle = new Circle(7, "Red");
        circle.getInfo();
        shape Rectangle = new Rectangle(12, 15, "Blue");
        Rectangle.getInfo();
    }
}
