package chapter04.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("poscodx/chapter04/src/main/java/chapter04/io/example.png");
                OutputStream os = new FileOutputStream(
                        "poscodx/chapter04/src/main/java/chapter04/io/example.copy.png")) {

            int data = -1;
            while ((data = is.read()) != -1) {
                os.write(data);
            }

        } catch (IOException e) {
            System.out.println("file not found:" + e);
        }
    }
}
