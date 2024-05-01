package chapter04.io;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {
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
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String name = scanner.next();
                String phone1 = scanner.next();
                String phone2 = scanner.next();
                String phone3 = scanner.next();
                System.out.println(name + ":" + phone1 +"-" +phone2 +"-"+phone3);
            }
        } catch (Exception e) {
            System.out.println("error:" + e);
        }
    }
}
