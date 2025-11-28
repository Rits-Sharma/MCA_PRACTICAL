// Question 4: Finally Block Demonstration
// Create a program that opens a file for reading using FileInputStream. Handle FileNotFoundException and ensure that the file stream is properly closed in the finally block. Demonstrate that the finally block executes regardless of whether an exception occurs or not.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Question4 {
    public static void main(String[] args) {

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("Question.java");

            int data = fileInputStream.read();
            System.out.println("First byte read: " + data);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nExecuting finally block.");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    System.out.println("FileInputStream closed successfully.");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("FileInputStream is not opened.");
            }
        }
    }
}

