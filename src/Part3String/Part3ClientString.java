package Part3String;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Part3ClientString {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 33333);
        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String input = "";

        System.out.println("Please enter a command from the following list: \n" +
                "- upper [string] = returns upperCase value of the argument inputted. \n" +
                "- double [int] = returns double the value of the integer inputted \n" +
                "- getFirstName [firstname] [surname] = returns firstname when firstname and surname is inputted \n" +
                "- square [int] = returns square value of the integer inputted \n" +
                "- exit = exits the program");


        while(!input.equals("exit")) {
            input = sc.nextLine();
            pw.println(input);
            pw.flush();
            String str = bf.readLine();
            System.out.println("server: " + str);
        }
        socket.close();
    }
}