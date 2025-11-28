// Question 6: Try-with-Resources
// Implement a program that uses try-with-resources to automatically manage a FileInputStream and FileOutputStream. The program should copy content from one file to another. Handle IOException and demonstrate that resources are automatically closed.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Question6 {
    public static void main(String[] args) {

        String sourceFile = "input1.txt";
        String destinationFile = "output.txt";

        System.out.println("Starting the file copy operation...\n");

        // Try-with-resources ensures automatic closing of streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int data;

            System.out.println("Copying data...");
            while ((data = fis.read()) != -1) {  // read byte by byte
                fos.write(data);
            }

            System.out.println("\nCopy completed successfully!");

        } catch (IOException e) {
            System.out.println("\nAn IOException occurred!");
            System.out.println("Error Message: " + e.getMessage());
            // System.out.println("Stack Trace:");
            // e.printStackTrace();
        }

        // At this point the resources ARE already closed automatically
        System.out.println("Both FileInputStream and FileOutputStream have been closed automatically.");
    }
}
