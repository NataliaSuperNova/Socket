import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 23456);

			PrintWriter pw = new PrintWriter(socket.getOutputStream()); 
			pw.println("This is your message back in capital letters");
			pw.flush();
			
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			BufferedReader bf = new BufferedReader(in);
			
			String str = bf.readLine();
			System.out.println("server:" + str);
			
		}catch (IOException e) {
			System.err.println("this is the client error");
		}
		

	}

}
