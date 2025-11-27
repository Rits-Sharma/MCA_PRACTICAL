// 7. Design a class Employee that generates a unique employee ID using a static variable. Each time a new employee is created, the ID should increment.

class Employee {
    static int ID = 1;
    int empID;

    public Employee() {
        empID = ID;
        ID++;
    }

    void display() {
        System.out.println("Employee ID: " + empID);
    }
}

public class Question7 {
    public static void main(String[] args) {
        Employee e = new Employee();
        Employee e1 = new Employee();
        e.display();
        e1.display();
    }
}
