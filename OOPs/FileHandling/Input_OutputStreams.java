package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Input_OutputStreams {
    public static void main(String[] args) {
        File file = new File("FileHandling/inputText.txt");
        FileInputStream fis = null;
        byte[] bytes = new byte[(int)file.length()];
        try {
            fis = new FileInputStream(file);
            fis.read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File out = new File("FileHandling/outputText.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(out);
            fos.write(bytes);
            fos.flush();
            System.out.println("Data written successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
