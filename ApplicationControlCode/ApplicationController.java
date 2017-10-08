/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcchr
 */

import java.util.HashMap;
public class ApplicationController {
    //HashMap to store different handlers
    static HashMap<String,Handler> handlerMap = new HashMap<String,Handler>();
    
    //handles requests by getting the correct handler from the HashMap
    public static void handleRequest(String command, String name){
        Handler handler = handlerMap.get(command);

        if (handler != null){
            handler.handleIt(name);
        }
    }
    
    
    
    
}
