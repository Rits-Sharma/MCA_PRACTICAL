// Question 1: Basic Exception Handling
// Write a Java program that reads two integers from the user and performs division. Handle ArithmeticException when dividing by zero and InputMismatchException when invalid input is provided. Display appropriate error messages for each scenario.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        try {
            System.out.print(("Enter two numbers: "));
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a + " divided by " + b + " then " + (a / b));
            
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println(e);
        } finally {
            sc.close();
        }
    }
}
