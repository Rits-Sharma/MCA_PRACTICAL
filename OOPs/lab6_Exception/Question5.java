// Question 5: Exception Propagation
// Write a program with three methods: methodA(), methodB(), and methodC(). methodC() should throw an ArithmeticException. Let the exception propagate through methodB() to methodA(), where it should be caught and handled. Demonstrate exception propagation in the call stack.

import java.util.Scanner;

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
        int m,n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        m =sc.nextInt();
        n =sc.nextInt();
        System.out.println(m + " / " + n + " = " + (m/n));
        sc.close();
    }

    public static void main(String[] args) {
        methodA();
    }
}
