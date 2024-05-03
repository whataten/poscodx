package chat;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

public class ChatServer {

    private static final String ENABLED_IP = "0.0.0.0";
    private static final int ENABLED_PORT = 5000;
    private static final int BACK_LOG = 10;
    private static List<PrintWriter> printWriters = new Vector<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket();) {
            serverSocket.bind(new InetSocketAddress(ENABLED_IP, ENABLED_PORT), BACK_LOG);

            while (true) {
                var socket = serverSocket.accept();
                System.out.println("connected : " + socket.getRemoteSocketAddress());
                new ChatServerThread(socket, printWriters).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
