package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {
    public static void main(String[] args) {
        try {
            var inetAddress = InetAddress.getLocalHost();

            var hostName = inetAddress.getHostName();
            var hostIpAddress = inetAddress.getHostAddress();

            System.out.println(hostName);
            System.out.println(hostIpAddress);

            byte[] ipAddresses = inetAddress.getAddress();
            for(var ipAddress : ipAddresses) {
                System.out.println(ipAddress & 0x000000ff);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
