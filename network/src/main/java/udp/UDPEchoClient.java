package udp;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;
import java.net.DatagramPacket;
import java.io.IOException;
import java.net.InetSocketAddress;

public class UDPEchoClient {
    private static final String Server_IP = "8080";
    public static void main(String[] args) {
        Scanner scanner = null;
        DatagramSocket socket = null;
        
        try {
            // 1. 스캐너 생성
            scanner = new Scanner(System.in);
            
            // 2. 소켓 생성
            socket = new DatagramSocket();

            while (true) {
                System.out.println(">>");
                String message = scanner.nextLine();

                if ("quit".equals(message)) {
                    break;
                }

                // 송신
                byte[] sndData = message.getBytes("UTF-8");
                DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, new InetSocketAddress(Server_IP, UDPEchoServer.PORT));
                socket.send(sndPacket);

                // 수신
                DatagramPacket rcvPacket = new DatagramPacket(new byte[UDPEchoServer.BUFFER_SIZE], UDPEchoServer.BUFFER_SIZE);
                socket.receive(rcvPacket); //blocking

                byte[] rcvData = rcvPacket.getData();
                int offset = rcvPacket.getLength();
                message = new String(rcvData, 0, offset);

                System.out.println("<" + message);
            }
        } catch (SocketException e) {
            System.out.println("[UDP Echo Client] error : " + e);
        } catch (IOException e) {
            System.out.println("[UDP Echo Client] error : " + e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
