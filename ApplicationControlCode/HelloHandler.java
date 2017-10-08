
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcchr
 */
public class HelloHandler implements Handler{

    @Override
    public void handleIt(String name) { 
        //Takes the data from the view screen and turns it into a message, really simple, but demonstrates the concept
        ApplicationMain.setDisplayMessage("Hello "+name+", nice to meet you.");
    }

    
}
