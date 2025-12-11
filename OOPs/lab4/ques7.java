// Write a class Parent with a method display(), and a subclass Child with a constructor that uses super() to call the parent class constructor. Use both super.display() and this.display() in the child class.

class Parent{
    void display(){
        System.out.println("Parent class");
    }
}

class Child extends Parent{
    Child(){
        super();
    }
    @Override
    void display(){;
        System.out.println("Child class");
    }

    void show(){
        super.display();
        this.display();
    }
}



public class ques7 {
    public static void main(String[] args) {
        Child c = new Child();
        c.show();
    }
}
