package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) {
        File file = new File("FileHandling/inputText.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String fileData = scanner.nextLine();
                System.out.println(fileData);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
