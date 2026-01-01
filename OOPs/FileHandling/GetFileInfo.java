package FileHandling;

import java.io.File;

public class GetFileInfo {
    public static void main(String[] args) {
        File file = new File("FileHandling/inputText.txt");
        if (file.exists()) {
            System.out.println("File " + file.getName() + " located at: " + file.getAbsolutePath());
            System.out.println("Is file writeable: " + file.canWrite() + ", is readable: " + file.canRead() + ", length: " + file.length());
        } else {
            System.out.println("File not found.");
        }
    }
}
