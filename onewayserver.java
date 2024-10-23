import java.io.*;
import java.net.*;
public class onewayserver {
  public static void main(String[] args) throws IOException{
      ServerSocket serverSocket = new ServerSocket(8881);
      System.out.println("Server started, Waiting for the connection...");
      Socket socket = serverSocket.accept();
      System.out.println("Client connected");
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      String message;
      while(true){
          message = in.readLine();
          if(message.equals("exit")){
              System.out.println("Client disconnected");
              break;
          }
          System.out.println("Message Received: "+message);
          out.println(message);
      }
      serverSocket.close();
      socket.close();
  }
}




