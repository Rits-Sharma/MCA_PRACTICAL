// 4. Design a class Order that keeps track of total orders placed using a static variable totalOrders. Use a static block to initialize the variable and static methods to increment and display the total orders.

class Order {
    static int totalOrders;
    static {
        totalOrders = 0;
    }
    public Order() {
        increment();
    }
    static void increment() {
        totalOrders++;
    }
    
    static void display() {
        System.out.println("Total order: " + totalOrders);
    }
}

public class Question4 {
    public static void main(String[] args) {
        Order o = new Order();
        Order o2 = new Order();
        Order o5 = new Order();
        Order.display();
    }
}
