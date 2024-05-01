package chapter04.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {
    public static void main(String[] args) {
        File file = new File("/root/poscodx/chapter04/src/main/java/chapter04/phone.txt");
        // 1. 기반 스트림
        try (FileInputStream fis = new FileInputStream(file);) {
            if (!file.exists()) {
                System.out.println("file not found");
                return;
            }

            System.out.println("=== 파일정보 ===");
            System.out.println(file.getAbsolutePath());
            System.out.println(file.length() + "Bytes");
            Date d = new Date(file.lastModified());
            System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(d));

            System.out.println("=== 전화번호 ===");

            // 2. 보조 스트림02 (byte|byte|byte -> char)
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");

            // 3. 보조 스트림03 (char|char|char|\n -> "charcharchar")
            BufferedReader br = new BufferedReader(isr);

            String line = null;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "\t ");

                String token = "";
                int index = 0;
                while (st.hasMoreElements()) {
                    token = st.nextToken();
                    
                    if (index == 0) {
                        System.out.print(token + ":");
                    } else if (index == 1) {
                        System.out.print(token + "-");
                    } else if (index == 2) {
                        System.out.print(token + "-");
                    } else {
                        System.out.print(token + "\n");
                    }
                    index++;
                }

            }

            fis.read();
        } catch (IOException e) {
            System.out.println("error:" + e);
        }
    }
}
