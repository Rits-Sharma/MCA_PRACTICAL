import java.util.Scanner;

public class SquareRoot {
    public static double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        if (number == 0) {
            return 0;
        }
        // Initial guess (can be any positive value)
        double guess = number / 2.0;
        double epsilon = 1e-6;  // Precision of the result

        // Iteratively apply Newton's method
        while (Math.abs(guess * guess - number) > epsilon) {
            guess = (guess + number / guess) / 2.0;
        }
        return guess;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number;
        System.out.print("Enter a number: ");
        number = sc.nextDouble();
        double result = sqrt(number);
        System.out.println("The square root of " + number + " is approximately: " + result);
        sc.close();
    }
}
