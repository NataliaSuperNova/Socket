package Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Client {
    /*
        Throws an IOException if Server.Java is not running.
        Prompts the user for a string, sends it to the server and then displays the output to the user.
        Then prompts the user to enter an integer, validates input, sends it to the server and displays output.
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 11111);
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word or sentence you would like back in capitals.");
        printWriter.println(scanner.nextLine());
        printWriter.flush();
        String str = bufferedReader.readLine();
        System.out.println("Server: " + str);

        System.out.println("Enter a number you want doubled.");
        printWriter.println(scanner.nextLine());
        printWriter.flush();
        System.out.println("Server: " + bufferedReader.readLine());
        socket.close();
    }
}