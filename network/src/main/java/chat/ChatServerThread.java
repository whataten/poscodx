package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;
import java.util.List;

public class ChatServerThread extends Thread {
    Socket socket = null;
    List<PrintWriter> printWriters = null;
    String nickName = null;
    PrintWriter printWriter = null;

    public ChatServerThread(Socket socket, List<PrintWriter> printWriters) {
        this.socket = socket;
        this.printWriters = printWriters;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));) {
            boolean quit = false;
            this.printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            while (!quit) {
                var data = br.readLine();
                String[] datas = null;

                if ("".equals(data) || data == null) {
                    datas = new String[] {"QUIT"};
                } else {
                    datas = data.split(":");
                }

                String statement = switch (datas[0]) {
                    case "JOIN":
                        this.nickName = decoding(datas[1]);
                        this.printWriters.add(this.printWriter);
                        yield (nickName + "님이 입장하였습니다.");

                    case "MSG":
                        yield (nickName + " : " + decoding(datas[1]));

                    case "QUIT":
                        quit = true;
                        this.printWriters.remove(this.printWriter);
                        yield (nickName + "님이 퇴장하였습니다.");

                    default:
                        throw new IllegalArgumentException("Unexpected value: " + datas[0]);
                };

                broadcast(statement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void broadcast(String statement) {
        for (var printWriter : printWriters) {
            printWriter.println(statement);
        }
    }

    private String decoding(String str) {
        return new String(Base64.getDecoder().decode(str));
    }
}
