package FileHandling;

import java.io.File;

public class DeleteAFile {
    public static void main(String[] args) {
        File file1 = new File("FileHandling/inputText.txt");
        File file2 = new File("FileHandling/outputText.txt");
        if(file1.delete()) System.out.println(file1.getName() + " deleted successfully.");
        if(file2.delete()) System.out.println(file2.getName() + " deleted successfully.");
        else System.out.println("Failed to delete the file.");
    }
}
