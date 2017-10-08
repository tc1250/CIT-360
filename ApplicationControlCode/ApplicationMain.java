
import java.lang.System;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcchr
 */
public class ApplicationMain {
    public static String getDisplayMessage() {
        return ApplicationMain.displayMessage;
    }

    public static void setDisplayMessage(String displayMessage) {
        ApplicationMain.displayMessage = displayMessage;
    }
    //defaulted the message to an error message, if the handler fails to set the message, I'll see this
    static String displayMessage = "Test String: if you see this, something didn't go right";
            
    public static void main(String[] args) {
            
            Scanner input = new Scanner(System.in);
            boolean valid = false;
            
            //creating a handler for the hello control
            HelloHandler theHelloHandler = new HelloHandler();
            ApplicationController.handlerMap.put("hello",theHelloHandler);
            
            //greeting
            System.out.println("Welcome to the application controller test");
            //the application, get input and display message unless the E is typed, then exit
            try{
                while(!valid){
                    System.out.println("Enter your first name: ");
                    System.out.println("Or type (E) to exit");
                    String userInput = input.next();

                    switch(userInput){
                        case "E": return;
                        case "e": return;    
                        default: ApplicationController.handleRequest("hello",userInput);
                            break;
                    }
                    //the hendler sets a welcome message, if it fails, we'll see the default error message text
                    System.out.println(displayMessage);

                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }


    }

    
    
       
}
 