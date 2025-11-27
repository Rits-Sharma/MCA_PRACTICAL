// Question 8: Nested Try-Catch
// Write a program with nested try-catch blocks. The outer block should handle NumberFormatException and the inner block should handle ArithmeticException. Demonstrate how exceptions are handled in nested scenarios and show the flow of execution.

public class Question8 {
    public static void main(String[] args) {
        try {
            try {
                int n, m;
                n = Integer.parseInt("abc");
                m = 1/0;
                System.out.println(m);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + " occured in inner try-catch block.");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " occured in outer try-catch block.");    
        }
    }
}
