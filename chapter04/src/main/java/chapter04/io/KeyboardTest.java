package chapter04.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {           
            // 1. 기반 스트림 (표준 입력, stdin, System.in)
            // 2. 보조 스트림01 (byte|byte|byte -> char)
            InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
            // 3. 보조 스트림02 (char|char|char\n -> "charcharchar")
            br = new BufferedReader(isr);

            //4. 처리
            String line = null;
            while((line = br.readLine()) != null) {
                if("quit".equals(line)) {
                    break;
                }
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("error:" + e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
