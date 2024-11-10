import java.io.*;
import java.net.*;

public class stopWait_server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("server Started, Waiting for connection...");
        Socket socket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        String receivedData;
        while(true) {
            receivedData = br.readLine();
            System.out.println("Received data: "+receivedData);
            if(receivedData.equals("exit")) {
                System.out.println("client disconnected");
                break;
            }
            System.out.println("Sending Acknowledgement...");
            pw.println("ACK");
        }
        br.close();
        pw.close();
        serverSocket.close();
        socket.close();
    }

}
