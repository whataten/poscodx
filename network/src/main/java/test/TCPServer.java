package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 1. Server Socket 생성
            serverSocket = new ServerSocket();

            // 2. 바인딩(binding)
            // Socket에 InetSocketAddress(InetAddress(IPAddress) + Port)를 바인딩한다.
            // IPAddress: 0.0.0.0: 특정 호스트 IP를 바인딩 하지 않는다.

            // 백로그 : 작업을 놓치지 않기 위해 큐에 넣어놓는데 이 큐의 크기
            serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);

            // 3. accept
            var socket = serverSocket.accept(); // blocking

            try {
                var inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
                int remotePort = inetRemoteSocketAddress.getPort();
                System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");

                // 4. IO Stream 받아오기
                InputStream is = socket.getInputStream(); // byte 단위
                OutputStream os = socket.getOutputStream();

                while(true) {
                    // 5. 데이터 읽기
                    byte[] buffer = new byte[256];
                    int readByteCount = is.read(buffer); // blocking

                    if (readByteCount == -1) {
                        // 클라이언트가 정상적으로 종료(close() 호출)
                        System.out.println("[server] closed by client");
                        break;
                    }

                    String data = new String(buffer, 0, readByteCount, "utf-8");
                    System.out.println("[server] received: " + data);

                    // 6. 데이터 쓰기
                    os.write(data.getBytes("utf-8"));


                }
            } catch (SocketException e) {
                System.out.println("[server] suddenly closed by client");
            } catch (IOException e) {
                System.out.println("[server] error: " + e);
            }
                finally {
                try {
                    if (socket != null && !socket.isClosed()) {
                        socket.close();
                    }
                } catch (Exception e) {
                    System.out.println("[server] error: " + e);
                }
            }

        } catch (IOException e) {
            System.out.println("[server] error: " + e);
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
