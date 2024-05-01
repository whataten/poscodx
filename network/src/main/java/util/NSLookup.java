package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

    private String dn = "";

    public NSLookup(String dn) {
        this.dn = dn;
    }

    public void nslookup(String dn) {
        try {
            var ips = InetAddress.getAllByName(dn);
            for (var ip : ips) {
                System.out.println(ip.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
