// Write a class Person with a constructor that accepts name and age. Create a subclass Employee that accepts name, age, and salary, and use super() to initialize the name and age.

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}

class Employee extends Person{
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }
    public void displayInfo() {
        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Salary: "+ salary);
    }
}

public class ques5 {
    public static void main(String[] args) {
        Employee emp = new Employee("Rahul", 25, 55980.0);
        emp.displayInfo();
    }
}
