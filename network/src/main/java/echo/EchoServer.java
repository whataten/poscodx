package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class EchoServer {

    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket();

            serverSocket.bind(new InetSocketAddress("0.0.0.0", SERVER_PORT), 10);
            while(true) {
                var socket = serverSocket.accept();
                new EchoRequestHandler(socket).start();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void log(String message) {
        System.out.println("[Echo Server] : " + message);
    }
}
