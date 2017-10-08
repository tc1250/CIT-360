/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcchr
 */
public class RunnableClass implements Runnable{

    @Override
    public void run() {
        int count=0;
        try{
            while(count<10){
                System.out.println("Hello from thread "+Thread.currentThread().getName()+", the count is " + count);
                count++;
                Thread.sleep(250);
            }
            
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
                
    }    
}
