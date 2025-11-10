// package assignment;

class Person{
    String name;
    int age;

    public Person(String name, int age){
        // this.name = name;
        this.age = age;
        this.name = name;
    }

    /* public String getName(){
    //     return name;
    // }

    // public int getAge(){
    //     return age;
    // }*/
}

class Employee extends Person{
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: "+ salary);
    }
}

public class ques5 {
    public static void main(String[] args) {
        Employee emp = new Employee("Rahul", 25, 55980.0);
        emp.displayInfo();
    }
}
