// 5. Create a class Course that has a static variable totalCourses. Each time a course is created, the static variable should be incremented. Create a static method that prints the total number of courses offered by the university.

class Course {
    static int totalCourses = 0;

    public Course() {
        totalCourses++;
    }
    static void print() {
        System.out.println("No of course: " + totalCourses);
    }
}

public class Question5 {
    public static void main(String[] args) {
        Course c = new Course();
        Course c2 = new Course();
        Course.print();
    }
}
