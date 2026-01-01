package FileHandling;

import java.io.FileWriter;

public class WriteToFile {
    public static void main(String[] args) {
        try {
            FileWriter file = new FileWriter("FileHandling/inputText.txt");
            file.write("Hello from writeToFile.java file program.");
            file.close();
            System.out.println("Content is written successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
