// 3. Design a Student class where each student has a unique ID. Use a static variable to maintain a counter for the number of students created. Create a static method to print the next available student ID.

class Student {
    static int ID = 1;
    int studentID;
    public Student() {
        studentID = ID;
        ID++;
    }

    static void print() {
        System.out.println("Next available ID : " + ID);
    }
}

public class Question3 {
    public static void main(String[] args) {
        Student s = new Student();
        Student s2 = new Student();
        System.out.println("Student 1 id: " + s.studentID);
        System.out.println("Student 2 id: " + s2.studentID);
        Student.print();
    }
}
