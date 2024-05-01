package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public class EchoServer {

    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket();

            serverSocket.bind(new InetSocketAddress("0.0.0.0", SERVER_PORT), 10);

            var socket = serverSocket.accept();

            try {
                var inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
                int remotePort = inetRemoteSocketAddress.getPort();
                log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();

                // socket close 하면 자동으로 다 닫힘
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8"), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));

                while (true) {
                    String data = br.readLine(); // blocking

                    if (data == null) {
                        log("closed by client");
                        break;
                    }

                    log("received: " + data);

                    pw.println(data);

                    // outputstreamwriter가 대신해줌
                    // os.write(data.getBytes("utf-8"));

                }
            } catch (SocketException e) {
                log("suddenly closed by client");
            } catch (IOException e) {
                log("error: " + e);
            } finally {
                try {
                    if (socket != null && !socket.isClosed()) {
                        socket.close();
                    }
                } catch (Exception e) {
                    log("error: " + e);
                }
            }

        } catch (IOException e) {
            log("error: " + e);
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    private static void log(String message) {
        System.out.println("[Echo Server] : " + message);
    }
}
