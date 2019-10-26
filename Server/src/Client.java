import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 24356);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a word or sentence you would like back in capitals..");

        String makeCaps = sc.nextLine();

        pw.println(makeCaps);
        pw.flush();


        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);


        String str = bf.readLine();
        System.out.println("server:" + str);

        System.out.println("and now enter a number you want doubled..");
        int doubleMe = sc.nextInt();
        os.write(doubleMe);

        System.out.println("server:" + bf.readLine());
        sc.close();
        socket.close();
    }
}
