// Question 3: Multiple Catch Blocks
// Write a program that creates an array of 5 integers and asks the user for an index to display. Handle ArrayIndexOutOfBoundsException for invalid indices and InputMismatchException for non-integer input using multiple catch blocks.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        try {
            System.out.println("Enter elements in array: ");
            for (int i = 0; i < 5; i++) {
                arr[i] = sc.nextInt();
            }

            int index;

            System.out.println("Enter index to display element: ");
            index = sc.nextInt();

            System.out.println("Element at index " + index + " is " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index! Please enter a value between 0 and 4.");
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }    
}
