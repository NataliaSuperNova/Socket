package Part3String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Part3ServerString {
    public static String upperCase(String s) { return s.toUpperCase(); }

    public static int doubleInt(int s) {
        return s*2;
    }

    public static String getFirstName(String f, String s) {
        return f;
    }

    public static int squareInt(int s) { return s*s; }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(33333); // wait for a connection
        while (true) {
            Socket connectionSocket = serverSocket.accept();
            InputStreamReader in = new InputStreamReader(connectionSocket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            PrintWriter pw = new PrintWriter(connectionSocket.getOutputStream());
            System.out.println("Client Connected");
            boolean running = true;
            while (running) {
                String str = bf.readLine();
                String input[] = str.split(" ");
                switch (input[0]) {
                    case "upper":
                        if (input.length == 2) {
                            String message = input[1];
                            pw.println(upperCase(message));
                        } else {
                            pw.println("The upper function takes exactly one argument!");
                        }
                        break;

                    case "double":
                        if (input.length == 2) {
                            try {
                                int doubleValue = Integer.parseInt(input[1]);
                                pw.println(doubleInt(doubleValue));
                            } catch (NumberFormatException e) {
                                pw.println("Error: Please enter an integer to use this function.");
                            }
                        } else {
                            pw.println("The double function takes exactly one argument!");
                        }
                        break;

                    case "getFirstName":
                        if (input.length == 3) {
                            pw.println(getFirstName(input[1], input[2]));
                        } else {
                            pw.println("The getFirstName function takes exactly two arguments!");
                        }
                        break;

                    case "square":
                        if (input.length == 2) {
                            try {
                                int sqrValue = Integer.parseInt(input[1]);
                                pw.println(squareInt(sqrValue));
                            } catch (NumberFormatException e) {
                                pw.println("Error: Please enter an integer to use this function.");
                            }
                        } else {
                            pw.println("The square function takes exactly one argument!\"");
                        }
                        break;

                    case "exit":
                        pw.println("Exiting Server.");
                        running = false;
                        break;

                    default:
                        pw.println("Invalid command entered.");
                }
                pw.flush();
            }
        }
    }
}
