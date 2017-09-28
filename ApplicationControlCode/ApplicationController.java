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
    //the HashMap where 
    private HashMap<String,Handler> handlerMap = new HashMap();
    // this request takes a string and the HashMap, then passes 
    public void handleRequest(String command,HashMap<String,Object> data){
        Handler aCommandHandler = handlerMap.get(command);
        if(aCommandHandler !=null){
            aCommandHandler.handleIt(data);
        }
    }
    
    public void mapCommand(String aCommand, Handler acHandler){
        handlerMap.put(aCommand, acHandler);
    }
    
}
