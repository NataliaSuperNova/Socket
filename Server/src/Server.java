import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		try {
		ServerSocket serverSocket = new ServerSocket(23456);
		Socket connectionSocket = serverSocket.accept(); // wait for a connection
		
		InputStream is = connectionSocket.getInputStream();
		Scanner sc = new Scanner(is);
		
		System.out.println(sc.nextLine());
		sc.close();
		
		serverSocket.close();
		} catch (IOException e) {
			System.err.println("error");
		}
		
	}
	
	public String getCapitals() {
		return "";
	}
}

