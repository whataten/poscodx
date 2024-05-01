package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {
        Scanner scanner = null;
        Socket socket = null;

        try {
            scanner = new Scanner(System.in);
            socket = new Socket();

            socket.connect(new InetSocketAddress(SERVER_IP, 5000));

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // socket close 하면 자동으로 다 닫힘
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8"), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));

            while (true) {
                System.out.print(">>");
                String line = scanner.nextLine();
                if ("exit".equals(line)) {
                    break;
                }

                pw.println(line);
                String data = br.readLine(); // blocking 서버가 줄 때까지
                if (data == null) {
                    log("suddenly closed by server");
                    break;
                }
                System.out.println("<<" + data);
            }

        } catch (IOException e) {
            log("error: " + e);
        } finally {
            try {
                scanner.close();
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void log(String message) {
        System.out.println("[Echo Client] : " + message);
    }
}
