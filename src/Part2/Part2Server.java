package Part2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Part2Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(22222);

        DatagramPacket recievedDatagramPacket;
        DatagramPacket outwardDatagramPacket;
        byte[] receivedByte = new byte[2048];

        while (true) {
            recievedDatagramPacket = new DatagramPacket(receivedByte, receivedByte.length);
            socket.receive(recievedDatagramPacket);

            String upperCaseMessage = new String(recievedDatagramPacket.getData()).trim().toUpperCase();
            System.out.println(upperCaseMessage);
            byte[] outwardByte = upperCaseMessage.getBytes();
            outwardDatagramPacket = new DatagramPacket(outwardByte, outwardByte.length, recievedDatagramPacket.getAddress(), recievedDatagramPacket.getPort());
            socket.send(outwardDatagramPacket);
        }
    }
}