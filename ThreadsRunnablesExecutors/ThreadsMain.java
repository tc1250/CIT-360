
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcchr
 */
public class ThreadsMain {
    private static final int THREADS=10;
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        
        for(int i = 0; i<10; i++){
            Runnable worker = new RunnableClass();
            executor.execute(worker);
        }
        executor.shutdown();
        
        while(!executor.isTerminated()){
            
        }
        System.out.println("Threads are teminated");
    }        
}
