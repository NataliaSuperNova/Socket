package Part3Object;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Part3ClientObject {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 44444);
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());


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
            String tokenizedString[] = input.split(" ");
            messageObject message = new messageObject(tokenizedString);
            objectOutputStream.writeObject(message);
            try {
                messageObject recievedMessage = (messageObject) objectInputStream.readObject();
                System.out.println("server: " + recievedMessage.getResult());
            } catch (ClassNotFoundException e) {
                System.out.println("Unexpected Error: " + e);
            }
        }
        socket.close();
    }
}

