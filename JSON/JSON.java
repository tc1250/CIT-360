
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tcchr
 */
public class JSON {

    public static void main(String[] args) {
        //I'm going to show some JSON use, especially object ->JSON and JSON-> object again. 
        //I'm integrating with HTTPUrlConnection to grab actual JSON files from the web
        //I found jsontest.com that will return JSON files on request, so that's where I'm going to get these for the demonstration

        //the JSONObject and the JSONPaser objects
        JSONObject jsob = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            //URL to connect to, this is programmed to send back a simple JSON with the requester IP address in it
            URL url = new URL("http://ip.jsontest.com");
            //Open the URL
            System.out.println("Opening the HTTPUrlConnection...");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //using the HTTP GET request
            System.out.println("Sending GET request to " + url.toString());

            //This just converts the binary InputStream into readable characters
            System.out.println("Converting the return stream into readable characters...");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputString;

            //iterating over the return stream, this one is a single line, but it could be much longer
            System.out.println("Writing the stream to a JSON object...");
            while ((inputString = in.readLine()) != null) {
                try {
                    //using the JSONParser object to parse the JSON in the input stream, then add it to the JSONObject
                    jsob = (JSONObject) parser.parse(inputString);

                    //simple error catching
                } catch (ParseException p) {
                    System.out.println(p);
                }
            }
            //displaying my results using the JSON toString() method
            System.out.println("Printed contents of the received JSON information:");
            System.out.println(jsob.toJSONString());

            //always disconnect the http connection when the program is done
            connection.disconnect();
            // Simple error catching  
        } catch (IOException e) {
            System.out.println(e);
        }

        //I will now write the JSON to a file, because the website won't accept me writing JSON back to it...
        //Attempting to write the file to the user desktop, this is for use on a Windows machine, so this may not work if you are on a different OS
        System.out.println("\nWriting the file to your desktop (for Windows users, can't say where it will go for Mac or Linux users...)");
        try (FileWriter file = new FileWriter(System.getProperty("user.home") + "/Desktop/JSONTest.json")) {
            file.write(jsob.toJSONString());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("In the abscence of a program ending exception, this indicates success of writing the JSON to file.");

        //And we could read it again here, just to make sure it didn't get garbled in the writing thereof
        try {
            //Read the file into a new JSONObject
            System.out.println("\nReading the JSON file back into the program...");
            JSONObject readJSON = (JSONObject) parser.parse(new FileReader(System.getProperty("user.home") + "/Desktop/JSONTest.json"));
            //Printing the IP field of the JSON object
            System.out.println("Printing just the IP field of the JSON object...");
            System.out.println(readJSON.get("ip"));
        } catch (IOException | ParseException e) {
            System.out.println(e);
        }
    }
}
