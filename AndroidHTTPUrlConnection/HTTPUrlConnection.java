import java.net.*;
import java.io.*;

/**
 *
 * @author tcchr
 */
public class HTTPUrlConnection {
   public static void main(String[] args){
       // Using try-catch to open HTTPUrlConnection in case of bad URL or no data returned
       //System.out.println("Testing");
       try{
           //URL to connect to
           URL url = new URL("https://www.lds.org");
           //Open the URL
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           //Use an IO stream to get data from the connection
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