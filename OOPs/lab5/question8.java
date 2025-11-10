/*
 * 8. Create two interfaces Flying and Swimming, each with a method void fly() and void swim() respectively. Create a class Duck that implements both interfaces and overrides both methods. Write a test class that demonstrates the Duck's ability to both fly and swim.
 */

interface Flying{
    void fly();
}

interface Swimming{
    void swim();
}

class Duck implements Flying, Swimming{
    public void fly(){
        System.out.println("Duck can fly.");
    }
    public void swim(){
        System.out.println("Ducks can swim.");
    }
}

class test{
    void swim(Swimming s){
        s.swim();
    }
    void fly(Flying f){
        f.fly();
    }
}

public class question8 {
    public static void main(String[] args) {
        Duck d = new Duck();
        test t = new test();
        t.swim(d);
        t.fly(d);
    }
}
