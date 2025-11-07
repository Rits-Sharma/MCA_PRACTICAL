/*
 * 7. Create an interface Shape that has methods double area() and double perimeter(). Implement this interface in two classes: Circle and Rectangle. The Circle class should calculate the area and perimeter using the radius, and the Rectangle class should use the length and width.
 */

interface shape{
    double area();
    double perimeter();
}

class Circle implements shape{
    int radius;
    public Circle(int radius){
        this.radius = radius;
    }
    public double area(){
        double area = 3.14 * radius * radius;
        return area;
    }
    public double perimeter(){
        double perimeter = 2 * 3.14 * radius;
        return perimeter;
    }
    void display(){
        System.out.println(area());
    }
}
class Rectangle implements shape{
    int length,width;
    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }
    public double area(){
        double area = length * width;
        return area;
    }
    public double perimeter(){
        double perimeter = 2 * (length + width);
        return perimeter;
    }
}


public class question7 {
    public static void main(String[] args) {
        shape Circle = new Circle(7);
        System.out.println(Circle.area());
        shape Rectangle = new Rectangle(25, 85);
        System.out.println(Rectangle.perimeter());
    }
}
