package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

    public static void main(String[] args) {

        Scanner scanner = null;
        scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            var url = scanner.nextLine();
            if ("exit".equals(url)){
                scanner.close();
                break;
            }

            nslookup(url);
        }
    }

    public static void nslookup(String dn) {
        try {
            var ips = InetAddress.getAllByName(dn);
            for (var ip : ips) {
                System.out.println(dn + ":" + ip.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
