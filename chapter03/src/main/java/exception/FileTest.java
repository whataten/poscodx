package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream("hello.txt");
            int data = fis.read();
        } catch (FileNotFoundException e) {
            System.out.println("error: " + e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
