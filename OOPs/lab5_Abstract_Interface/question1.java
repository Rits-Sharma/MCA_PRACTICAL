// 1. Write a Java class Student that has multiple constructors. One constructor should accept student name and ID, while another should accept student name, ID, and grade. Implement constructor overloading and ensure the constructors call each other using this().

class Student{
    String name;
    int ID;
    char grade;
    
    Student(String name, int ID){
        this(name, ID,'A');
    }
    Student(String name, int ID, char grade){
        this.name = name;
        this.ID = ID;
        this.grade = grade;
    }

    void display(){
        System.out.println("Name : " + name + ", Id : " + ID + ", Grades : " + grade);
    }
}

public class question1 {
    public static void main(String[] args) {
        Student s = new Student("Ram", 101);
        Student s2 = new Student("Rahul", 102, 'B');
        s.display();
        s2.display();
    }
}
