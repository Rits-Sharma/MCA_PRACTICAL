class Human{
    String name;
    public Human() {
        System.out.println("Default constructor called");
    }

    public Human(String name) {
        this.name = name;
        System.out.println("Parameterized constructor called");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
    }
}

class Student extends Human{
    int roll;

    public Student(){
        super();
        // System.out.println("Default constructor of Student called");
    }

    public Student(String name, int roll){
        super(name);
        this.roll = roll;
        // System.out.println("Parameterized constructor of Student called");
    }

    public void displayStudentInfo() {
        super.displayInfo(); // call Human's method
        System.out.println("Roll: " + roll);
    }
}

public class ques10 {
    public static void main(String[] args) {
        Student s = new Student();
        s.displayStudentInfo();
        System.out.println();
        Student s2 = new Student("Aditya", 1);
        s2.displayStudentInfo();
    }
}
