/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcchr
 */
public class PersonHandler implements MVCHandler {
    
    
    
    @Override
    public void handleIt(PersonClass person) {
        MVCMain.addToPerson(person);
    }
    
}
