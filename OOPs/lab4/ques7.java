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
