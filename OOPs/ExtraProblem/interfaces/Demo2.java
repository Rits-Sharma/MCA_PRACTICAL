package interfaces;

interface A {
    void methodA();
}
class B {
    public void methodA() {
        System.out.println("Method A from class B");
    }
}

class C extends B implements A {  
}

public class Demo2 {
    public static void main(String[] args) {
        A a = new C();
        a.methodA();
    }
}
