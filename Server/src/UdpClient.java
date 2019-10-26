import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class UdpClient {
	public static void main(String[] args) throws SocketException, IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getLocalHost();
		byte[] stringMessage = "HelloWorld".getBytes();
		DatagramPacket stringPacket = new DatagramPacket(stringMessage, stringMessage.length, address, 23456);
		socket.send(stringPacket);
		
		byte[] receiver = new byte[512];
		DatagramPacket receiverPacket = new DatagramPacket(receiver, receiver.length);
		socket.receive(receiverPacket);
		String receivedMessage = new String(receiver, 0, receiver.length);
		System.out.println(receivedMessage);
		
		int i = 7;
		byte[] intMessage = ByteBuffer.allocate(4).putInt(i).array();
		DatagramPacket intPacket = new DatagramPacket(intMessage, intMessage.length, address, 23456);
		socket.send(intPacket);
		
		socket.receive(receiverPacket);
		int receivedNumber = ByteBuffer.wrap(receiver).getInt();
		System.out.println(receivedNumber);
		
		
		
		socket.close();
	}
}
