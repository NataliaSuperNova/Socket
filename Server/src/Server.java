import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		try {
		ServerSocket serverSocket = new ServerSocket(23456);
		Socket connectionSocket = serverSocket.accept(); // wait for a connection
		
		System.out.println("client connected");
		
		InputStreamReader in = new InputStreamReader(connectionSocket.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		System.out.println("client:" + str);
		
		PrintWriter pw = new PrintWriter(connectionSocket.getOutputStream());
		pw.println(str.toUpperCase());
		pw.flush();
		
		
		
		
		serverSocket.close();
		} catch (IOException e) {
			System.err.println("error");
		}
	}
	
}

