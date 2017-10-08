
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
public class MVCMain {
    private static HashMap personMap = new HashMap();
    public static void addToPerson(PersonClass person){
        personMap.put(person.getFirstName(), person);
    }
    public static Object recallPerson(String name){
        return personMap.get(name);
    }   
    public static void main(String[] args) {
        MVCView mvcView = new MVCView("Welcome to the person storage and retrieval system."+
                                    "\nHere you may enter data for a person to store them "+
                                    "\nand then retrieve them later. Press A to (A)dd a "+
                                    "\nperson, R to (R)etrieve a person, or Q to (Q)uit.");
        mvcView.display();
    }
}
