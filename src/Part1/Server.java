package Part1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(11111);
        while (true) {
            Socket connectionSocket = serverSocket.accept(); // wait for a connection
            System.out.println("Client Connected");
            InputStreamReader inputStreamReader = new InputStreamReader(connectionSocket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            String str = bufferedReader.readLine();
            System.out.println("Client:" + str);
            PrintWriter pw = new PrintWriter(connectionSocket.getOutputStream());
            pw.println(str.toUpperCase());
            pw.flush();


            String clientNum = bufferedReader.readLine();
            System.out.println(clientNum);
            try {
                Long num = Long.parseLong(clientNum);
                pw.println(num*2);
                pw.flush();
            } catch (NumberFormatException e) {
                pw.println("Invalid input entered. Please enter an integer.");
                pw.flush();
            }
        }
    }
}