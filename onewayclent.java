import java.util.*;
import java.net.*;
import java.io.*;
public class onewayclent {
    public static void main(String[] args) throws IOException {
       Socket socket = new Socket("localhost", 8881);
       System.out.println("Connected to server");
       BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
       Scanner sc = new Scanner(System.in);
       while(true) {
           System.out.println("Enter the message to be sent: ");
           String message = sc.nextLine();
           out.println(message);
           if(message.equals("exit")) {
               System.out.println("client disconnected");
               break;
           }
           System.out.println("Server echo backed: "+in.readLine());
       }
    }
}