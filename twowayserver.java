import java.io.*;
import java.net.*;

public class twowayserver {
    public static void main(String[] args) throws IOException {
      ServerSocket serverSocket = new ServerSocket(8888);
      System.out.println("Server Started, Waiting for the connection");
      Socket socket = serverSocket.accept();
      System.out.println("Client Connected");
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
      String server_msg,client_msg;
      while(true) {
          client_msg = br.readLine();
          System.out.println("Client Message: "+client_msg);
          if(client_msg.equalsIgnoreCase("exit")) {
              System.out.println("Server Stopped");
              break;
          }
          System.out.println("Server(type your message: ");
          server_msg = br1.readLine();
          pw.println(server_msg);
          if(server_msg.equalsIgnoreCase("exit")) {
              System.out.println("Server Stopped");
              break;
          }
      }
      pw.close();
      br1.close();
      serverSocket.close();
      socket.close();
    }
}
