import java.util.*;
import java.io.*;
import java.net.*;

public class twowayclient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8888);
        System.out.println("Connected to the Server");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);
        String server_msg, client_msg;
        while(true){
            System.out.println("Client(type your message)");
            client_msg = sc.nextLine();
            out.println(client_msg);
            if(client_msg.equals("exit")){
                System.out.println("CLient Disconnected ");
                break;
            }
            server_msg = in.readLine();
            System.out.println("Server Message: "+server_msg);
            if(server_msg.equals("exit")){
                System.out.println("Server Disconnected");
                break;
            }
        }
        in.close();
        out.close();
        socket.close();

    }
}
