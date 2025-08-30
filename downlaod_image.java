import java.io.*;
import java.net.*;
public class downlaod_image {
    public static void main(String[] args) throws IOException {
        String Imageurl="https://stimg.cardekho.com/images/carexteriorimages/930x620/Lamborghini/Huracan-EVO/10643/1690010999692/front-left-side-47.jpg";
        String fileLocation = "Lamborghini_1.jpg";
        URL url = new URL(Imageurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        int responseCode = conn.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK){
            InputStream inputStream = conn.getInputStream();
            FileOutputStream fos = new FileOutputStream(fileLocation);
            byte[] buffer = new byte[1024];
            int bytesRead = -1;
            while((bytesRead = inputStream.read(buffer)) != -1){
                fos.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            fos.close();
            System.out.println("Image downloaded successfully "+fileLocation);
        }  
            
        else{
            System.out.println("Image download failed");
        } 
        conn.disconnect();
    }
}











