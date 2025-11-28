// Question 8: Nested Try-Catch
// Write a program with nested try-catch blocks. The outer block should handle NumberFormatException and the inner block should handle ArithmeticException. Demonstrate how exceptions are handled in nested scenarios and show the flow of execution.

import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        int q, m1, n1;
        String m, n;
        Scanner sc = new Scanner(System.in);
        try {
            try {
                System.out.println("Enter number as dividend:");
                n = sc.next();
                n1 = Integer.parseInt(n);
                System.out.println("Enter number as divisor:");
                m = sc.next();
                m1 = Integer.parseInt(m);


                q = n1/m1;
                System.out.println(q);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + " occured in inner try-catch block.");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " occured in outer try-catch block.");    
        } finally {
            sc.close();
        }
    }
}
