package FileHandling;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try {
            File file1 = new File("FileHandling/inputText.txt");
            File file2 = new File("FileHandling/outputText.txt");
            if (file1.createNewFile()) System.out.println("File " + file1.getName() + " has been created successfully.");
            else System.out.println("File already exists: " + file1.getAbsolutePath());
            if (file1.createNewFile()) System.out.println("File " + file2.getName() + " has been created successfully.");
            else System.out.println("File already exists: " + file2.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("An unexpected error is occurred.");
            e.printStackTrace();
        }
    }    
}
