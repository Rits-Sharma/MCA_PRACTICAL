// Question 7: Throw and Throws
// Create a method validatePassword() that takes a password string and throws a custom WeakPasswordException if the password length is less than 8 characters. Use the throw keyword to throw the exception and declare it in the method signature using throws. Write a main method to test this functionality.

import java.util.Scanner;

class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

public class Question7 {

    public static void validatePassword(String password) throws WeakPasswordException{
        if(password.length() < 8) {
            throw new WeakPasswordException(password + "'s length is less than 8, it should be atleast 8 characters.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass1;
        System.out.print("Enter a password: ");
        pass1 = sc.next();

        try {
            validatePassword(pass1);
            System.out.println(pass1 + " Password is strong.");
        } catch (WeakPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }    
}
