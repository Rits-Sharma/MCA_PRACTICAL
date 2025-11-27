// Question 2: Custom Exception Class
// Create a custom exception class InvalidAgeException that is thrown when an age value is less than 0 or greater than 150. Write a program that takes age as input and throws this custom exception with appropriate messages for invalid age values.

import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    };
}


public class Question2{
    public static void main(String[] args) throws InvalidAgeException{
        Scanner sc = new Scanner(System.in);
        int age;

        try {
            System.out.print("Enter your age betwwn 0 and 150: ");
            age = sc.nextInt();
            if (age < 0 || age > 150) {
                throw new InvalidAgeException("Age " + age + " is not between 0 and 150");
            } else {
                System.out.println("Your age is " + age);
            }
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
