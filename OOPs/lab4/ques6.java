// In the class Vehicle with a method move(), create a subclass Car that overrides move().Use super.move() to call the superclass version inside the overridden method.

class Vehicle{
    void move(){
        System.out.println("Vehicle runs");
    }
}

class Car extends Vehicle{
    @Override
    void move(){
        super.move();
        System.out.println("car runs");
    }
}

public class ques6 {
    public static void main(String[] args) {
        Car c = new Car();
        c.move();
    }
}
