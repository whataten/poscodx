package chat;

import java.util.Scanner;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Base64;

public class ChatClient {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5000;
    private static final String QUIT = "cXVpdA==";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in); Socket socket = new Socket();) {

            // Connect with ChatServer
            socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

            // Decide Nick Name
            System.out.print("Enter your nick name : ");
            String nickName = encoding(scanner.nextLine());

            // Launch ChatClientThread
            var chatClientThread = new ChatClientThread(socket);
            chatClientThread.start();

            // Write Nick Name with JOIN
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            pw.println("JOIN:" + nickName);

            while (true) {
                System.out.print(">> ");
                String message = scanner.nextLine();

                if (QUIT.equals(encoding(message.toLowerCase()))) {
                    chatClientThread.interrupt();
                    pw.println("QUIT:");
                    break;
                }

                pw.println("MSG:" + encoding(message));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encoding(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
}
