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
