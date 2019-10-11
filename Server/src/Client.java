import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 23456);
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os); 
			pw.print("hello world");
			
			pw.close();
			socket.close();

			
		}catch (IOException e) {
			System.err.println("this is the client error");
		}
		

	}

}
