import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Part2Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(22222);
        DatagramPacket recievedDatagramPacket;
        DatagramPacket outwardDatagramPacket;

        String input = "";


        while (true) {
            byte[] receivedByte = new byte[2048];
            recievedDatagramPacket = new DatagramPacket(receivedByte, receivedByte.length);
            socket.receive(recievedDatagramPacket);

            input = new String(recievedDatagramPacket.getData()).trim();
            System.out.println("client: " + input);

            try {
                int i = Integer.parseInt(input);
                i = 2 * i;
                input = Integer.toString(i);
                System.out.println(input);

            } catch (NumberFormatException e) {
                input = input.toUpperCase();
                System.out.println(input);
            }

            byte[] outwardByte = input.getBytes();
            outwardDatagramPacket = new DatagramPacket(outwardByte, outwardByte.length, recievedDatagramPacket.getAddress(), recievedDatagramPacket.getPort());
            socket.send(outwardDatagramPacket);
        }
    }
}
