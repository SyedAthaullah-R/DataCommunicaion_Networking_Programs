import java.io.*;
import java.util.*;
import java.net.*;

public class stopWait_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8888);
        System.out.println("Connected to Server");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String frame,ack;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter your Message:");
            frame = sc.nextLine();
            out.println(frame);
            if (frame.equals("exit")){
                System.out.println("Server stopped");
                break;
            }
            try{
                ack = in.readLine();
                socket.setSoTimeout(5000);
                if(ack.equals("ACK") && ack != null){
                    System.out.println("ACK Received");
                }
            }
            catch(SocketTimeoutException e){
                System.out.println("No Acknowledgment Received, Resending the Frame Data");
                out.println(frame);
            }
        }
        in.close();
        out.close();
        sc.close();
        socket.close();
    }

    }

