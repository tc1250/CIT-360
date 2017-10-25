import java.net.*;
import java.io.*;

/**
 *
 * @author tcchr
 */
public class HTTPUrlConnection {
    
    private final static String USER_AGENT = "Mozilla/5.0";
    
   public static void main(String[] args){
       // Using try-catch to open HTTPUrlConnection in case of bad URL or no data returned
       //System.out.println("Testing");
       try{
           //URL to connect to
           URL url = new URL("https://www.lds.org");
           //Open the URL
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           
           //HTTP usage
           //setting request type
           connection.setRequestMethod("GET");
           // request header
           connection.setRequestProperty("User-Agent", USER_AGENT);
           
           //using just the HTTP GET request
           System.out.println("Sending GET request to " + url.toString());
           System.out.println("Response Code: " + connection.getResponseCode());
           
           //URLConnection Usage
           //Use an IO stream to get data from the connection - InputStreamReader converts from bytes to characters, and BufferedReader converts from chars to strings
           BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           
           String inputString;
           //while information comes from the stream, print it to the screen, we could be doing anything with this data, storing it, displaying it (if we had a GUI)
           // but for this demo, I'm just printing it
           while((inputString = in.readLine()) != null){
               System.out.println(inputString);
           }    
                     
           
       }catch(Exception e){
           //Print the exception if we have a bad URL
           System.out.println(e);
       }
           
   } 
}
