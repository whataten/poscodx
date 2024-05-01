package chapter04.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
    public static void main(String[] args) {
        BufferedOutputStream bos = null;
        
        try {
            // 기반 스트림
            FileOutputStream fos = new FileOutputStream("hello.txt");

            // 보조 스트림
            bos = new BufferedOutputStream(fos); 

            // for (int i = 97; i <= 122; i++) {
            for (int i = 'a'; i <= 'z'; i++) {
                bos.write(i);

            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found:" + e);
        } catch (IOException e) {
            System.out.println("error:" + e);
        } finally {
            try {
                if(bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
