// 2. Create a class Employee with fields name, id, designation, and salary. Implement multiple constructors that initialize different combinations of these fields, and ensure that they chain to a primary constructor using the this() keyword.

class Employee{
    String name;
    int id;
    String designation;
    int salary;

    Employee(int id, String name){
        this(id,name, 15000);
    }
    Employee(int id, String name, int salary){
        this(id, name, salary, "Manager");
    }
    Employee(int id, String name, int salary, String designation){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation =designation;
    }

    void display(){
        System.out.println("Name : " + name);
        System.out.println("Id : " + id);
        System.out.println("Designation : " + designation);
        System.out.println("Salary : " + salary);
    }
}

public class question2 {
    public static void main(String[] args) {
        Employee emp = new Employee(25, "Ajay");
        emp.display();
    }
}
