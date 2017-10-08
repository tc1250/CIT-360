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
public class MVCApplicationController {
    //HashMap to store different handlers
    static HashMap<String,MVCHandler> handlerMap = new HashMap<String,MVCHandler>();
    
    static{
        PersonHandler personHandler = new PersonHandler();
        MVCApplicationController.handlerMap.put("add",personHandler);
    }
    
    
    //handles requests by getting the correct handler from the HashMap
    static void handleRequest(String command, PersonClass person) {
        MVCHandler handler = handlerMap.get(command);

        if (handler != null){
            handler.handleIt(person);
        }
    }
    
    
    
    
}
