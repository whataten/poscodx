package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientThread extends Thread {

    BufferedReader br = null;
    Socket socket = null;

    public ChatClientThread(Socket socket) {
        try {
            this.socket = socket;
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (socket.isClosed()) {
                    break;
                }
                String data = br.readLine();
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
