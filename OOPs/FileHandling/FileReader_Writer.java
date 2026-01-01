package FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReader_Writer {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream("FileHandling/inputText.txt");
            fout = new FileOutputStream("FileHandling/outputText.txt");
            int c;
            while ((c = fin.read()) != -1) {
                fout.write(c);
            }
            System.out.println("File written successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fin != null)
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fout != null)
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
