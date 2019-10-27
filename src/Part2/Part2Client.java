import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Part2Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();


        System.out.println("Enter a word or sentence you would like back in capitals or enter a number you would like doubled");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String message = bufferedReader.readLine().trim();

        byte[] strInBytes = message.getBytes();
        DatagramPacket outwardDatagramPacket = new DatagramPacket(strInBytes, strInBytes.length, ip, 22222);
        socket.send(outwardDatagramPacket);

        byte[] receive = new byte[2048];
        DatagramPacket recievedDatagramPacket = new DatagramPacket(receive, receive.length);
        socket.receive(recievedDatagramPacket);
        String recievedMessage = new String(recievedDatagramPacket.getData());
        System.out.println("Server: " + recievedMessage.trim());
    }
}
