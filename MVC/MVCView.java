import java.lang.reflect.Field;
import java.time.LocalDate;
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
public class MVCView {
    protected String displayMessage;
    Scanner keyboard = new Scanner(System.in);
    
    public MVCView(String message) {
        this.displayMessage = message;
    }
    
    public boolean doAction(String value){
        switch(value.toUpperCase()){
            case "A":
                this.callAddPersonHandler();
                break;
            case "R":
                this.callRetrievePerson();
                break;
            default:
                System.out.println("\n That's not one of the options, please try again.");
                break;
        }
        return false; 
    }
    
    public void display() {
        boolean done = false;
        do {
            //prompt for input
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) {
                return;
            }

            done = this.doAction(value);
        } while (!done);
    }

    public String getInput() {

        boolean valid = false;
        String selection = null;
        try {
            while (!valid) {

                System.out.println("\n" + this.displayMessage + "\n");
                selection = this.keyboard.next();

                if (selection.length() < 1) {
                    System.out.println("\nInvalid selection. Try again");
                    continue;
                }
                break;
            }
        } catch (Exception ex) {
            System.out.println("Error reading input: " + ex.getMessage());
            System.out.println("\n" + this.displayMessage + "\n");
        }

        return selection;
    }

    private void callAddPersonHandler() {
        //get input for the person variables
        String firstName;
        String lastName;
        String position;
        LocalDate birthday;
        
        System.out.println("Please enter the first name of the person you would like to add: ");
        firstName = this.keyboard.next();
        System.out.println("Please enter the last name of the person you would like to add: ");
        lastName = this.keyboard.next();
        System.out.println("Please enter the position of the person you would like to add: ");
        position = this.keyboard.next();
        System.out.println("Please enter the birthdate as 'yyyy-mm-dd': ");
        birthday = LocalDate.parse(this.keyboard.next());
        
        PersonClass person = new PersonClass();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setBirthday(birthday);
        person.setPosition(position);
        
        MVCApplicationController.handleRequest("add", person);
    }

    private void callRetrievePerson() {
        System.out.println("Please enter the first name of the person to recall: ");
        String firstName = this.keyboard.next();
        Object person = MVCMain.recallPerson(firstName);
        
        System.out.println(person);
        
    }
}
