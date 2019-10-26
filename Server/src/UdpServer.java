import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class UdpServer {

	public static void main(String[] args) throws SocketException, IOException {
		DatagramSocket socket = new DatagramSocket(23456);
		byte[] buffer = new byte[512];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		socket.receive(packet);
		String receivedMessage = new String(buffer, 0, buffer.length);
		System.out.println(receivedMessage);
		
		byte[] messageToSend = receivedMessage.toUpperCase().getBytes();
		DatagramPacket toSendPacket = new DatagramPacket(messageToSend, messageToSend.length, packet.getAddress(), packet.getPort());
		socket.send(toSendPacket);
		
		socket.receive(packet);
		int receivedNumber = ByteBuffer.wrap(buffer).getInt()*2;
		System.out.println(receivedNumber);
		
		byte[] intMessage = ByteBuffer.allocate(4).putInt(receivedNumber).array();
		DatagramPacket intPacket = new DatagramPacket(intMessage, intMessage.length, packet.getAddress(), packet.getPort());
		socket.send(intPacket);
		
		socket.close();
		
	}
}
