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
import java.net.SocketException;

public class EchoRequestHandler extends Thread {

    private Socket socket;

    public EchoRequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            var inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
            int remotePort = inetRemoteSocketAddress.getPort();
            EchoServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // socket close 하면 자동으로 다 닫힘
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8"), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));

            while (true) {
                String data = br.readLine(); // blocking

                if (data == null) {
                    EchoServer.log("closed by client");
                    break;
                }

                EchoServer.log("received: " + data);

                pw.println(data);

                // outputstreamwriter가 대신해줌
                // os.write(data.getBytes("utf-8"));

            }
        } catch (SocketException e) {
            EchoServer.log("closed by client");
        } catch (IOException e) {
            EchoServer.log("error: " + e);
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (Exception e) {
                EchoServer.log("error: " + e);
            }
        }
    }
}
