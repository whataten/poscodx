package chapter04.io;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {
    public static void main(String[] args) {
        try (Reader in = new FileReader("poscodx/chapter04/src/main/java/chapter04/io/text.txt");
            InputStream is = new FileInputStream("poscodx/chapter04/src/main/java/chapter04/io/text.txt")) {

            int count = 0;
            int data = -1;
            while((data = in.read()) != -1) {
                System.out.print((char)data);
                count++;
            }
            System.out.println();
            System.out.println("count:" + count);


            count = 0;
            while((data = is.read()) != -1) {
                System.out.print((char)data);
                count++;
            }
            System.out.println();
            System.out.println("count:" + count);

        } catch (IOException e) {
            System.out.println("file not found:" + e);
        }
    }
}
