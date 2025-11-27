// Question 5: Exception Propagation
// Write a program with three methods: methodA(), methodB(), and methodC(). methodC() should throw an ArithmeticException. Let the exception propagate through methodB() to methodA(), where it should be caught and handled. Demonstrate exception propagation in the call stack.

public class Question5 {

    public static void methodA() {
        try {
            methodB();
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public static void methodB() {
        methodC();
    }
    public static void methodC() throws ArithmeticException {
        int a = 10/0;
    }

    public static void main(String[] args) {
        methodA();
    }
}
