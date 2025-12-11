// Question 9: Exception Chaining
// Create a program that demonstrates exception chaining. Catch a FileNotFoundException, then throw a custom DataProcessingException with the original exception as the cause. Show how to retrieve the chained exception using getCause() method.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class DataProcessingException extends Exception {
    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Question9 {

    public static void processFile(String fileName) throws DataProcessingException {
        FileInputStream fis = null;
        try {
            // This will throw FileNotFoundException if file does not exist
            fis = new FileInputStream(fileName);

        } catch (FileNotFoundException fnf) {
            System.out.println("Caught FileNotFoundException in processFile().");
            System.out.println("Now wrapping it inside DataProcessingException...");

            // Throw custom exception with original cause
            throw new DataProcessingException("Error processing the file: " + fileName, fnf);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    System.out.println("FileInputStream closed successfully.");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            // Call method with non-existing file to trigger exception
            processFile("missing_file.txt");

        } catch (DataProcessingException dpe) {
            System.out.println("\nCaught DataProcessingException in main():");
            System.out.println("Message: " + dpe.getMessage());

            // Retrieve the original cause
            Throwable cause = dpe.getCause();
            System.out.println("\nChained Exception (Cause): " + cause);
        }
    }
}
