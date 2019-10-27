package Part3Object;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Part3ServerObject {
    public static String upperCase(String s) { return s.toUpperCase(); }

    public static int doubleInt(int s) {
        return s*2;
    }

    public static String getFirstName(String f, String s) {
        return f;
    }

    public static int squareInt(int s) { return s*s; }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(44444); // wait for a connection
        while (true) {
            Socket connectionSocket = serverSocket.accept();
            OutputStream outputStream = connectionSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(connectionSocket.getInputStream());

            System.out.println("Client Connected");
            boolean running = true;
            while (running) {
                try {
                    messageObject message = (messageObject) objectInputStream.readObject();
                    String command = message.getCommand();
                    String[] arguments = message.getArguments();
                    switch (command) {
                        case "upper":
                            if (arguments.length == 1) {
                                String argument = arguments[0];
                                message.setResult(upperCase(argument));
                            } else {
                                message.setResult("The upper function takes exactly one argument!");
                            }
                            break;

                        case "double":
                            if (arguments.length == 1) {
                                try {
                                    int doubleValue = Integer.parseInt(arguments[0]);
                                    message.setResult(String.valueOf(doubleInt(doubleValue)));
                                } catch (NumberFormatException e) {
                                    message.setResult("Error: Please enter an integer to use this function.");
                                }
                            } else {
                                message.setResult("The double function takes exactly one argument!");
                            }
                            break;

                        case "getFirstName":
                            if (arguments.length == 2) {
                                message.setResult(getFirstName(arguments[0], arguments[1]));
                            } else {
                                message.setResult("The getFirstName function takes exactly two arguments!");
                            }
                            break;

                        case "square":
                            if (arguments.length == 1) {
                                try {
                                    int sqrValue = Integer.parseInt(arguments[0]);
                                    message.setResult(String.valueOf(squareInt(sqrValue)));
                                } catch (NumberFormatException e) {
                                    message.setResult("Error: Please enter an integer to use this function.");
                                }
                            } else {
                                message.setResult("The square function takes exactly one argument!\"");
                            }
                            break;

                        case "exit":
                            message.setResult("Exiting Server.");
                            running = false;
                            break;

                        default:
                            message.setResult("Invalid command entered.");
                    }
                    objectOutputStream.writeObject(message);
                } catch (ClassNotFoundException e) {
                    String[] emptyArray = new String[0];
                    messageObject message = new messageObject(emptyArray);
                    message.setResult("Invalid command entered.");
                    objectOutputStream.writeObject(message);
                }
            }
        }
    }
}
