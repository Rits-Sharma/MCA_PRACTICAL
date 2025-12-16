// Write a class Student with fields name and age. Create a constructor that uses the 'this' keyword to distinguish between instance variables and parameters.

class Student{
    // Fields (instance variables)
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        // Using 'this' to refer to instance variables
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }

}

public class ques1 {
    // Main method to test the class
    public static void main(String[] args) {
        Student s1 = new Student("Rajesh", 15);
        s1.displayInfo();
    }
}
