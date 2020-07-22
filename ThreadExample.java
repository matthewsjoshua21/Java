import java.util.concurrent.Semaphore; // import utilities
import java.util.Scanner;

public class ThreadExample {

	  public static int x = 0;  //global variable
	    public static void main(String[] args) 
	    {   Semaphore sem = new Semaphore(1); // create a new semaphore with only 1, which is a mutex 

		int expression; //variable for switch statment
		System.out.println("\nThis Proram demonstrates multithreading by adding \n5000 numbers in two threads to one global variable \nOption 1: no semaphore \nOption 2: semaphore");
		System.out.println("\nPlease choose 1 or 2");
		try (Scanner scanner = new Scanner(System.in)) {
			expression = scanner.nextInt(); // read in a value from the user
		}
		Thread1 Thread1 = new Thread1(); // create a new instance of thread1
		Thread2 Thread2 = new Thread2(); // create a new instance of thread2
		
		switch(expression)
		    {
		    case 1: // case 1 calls both threads simultaneously
			Thread1.start();
			Thread2.start();
			System.out.println("value " + x);
			break;
		    case 2: // case 2 uses semaphores to grant access to the global variable one thread at a time
			try{
			    sem.acquire(); // decreament semaphore in a try block and execute the thread
			    try{
				Thread1.start();
			    }finally{ Thread.sleep(1);}
			}catch(InterruptedException e){
			    e.printStackTrace();
			}
			sem.release(); // release semaphore
			try{
			    sem.acquire();
			    try{
				Thread2.start();
			    }finally{ Thread.sleep(1);}
			}catch(InterruptedException e){
			    e.printStackTrace();
			}
			sem.release();
			System.out.println("value " + x);
			
		    }
	       
	    }
	}    
	class Thread1 extends Thread // thread 1 uses a for loop to add 5000 to global variable x
	{
	   public void run()
	    {
		
		for(int i = 0; i < 5000; i++)
		    {
			ThreadExample.x = ThreadExample.x + 1;
		    }

	    }
	}


	class Thread2 extends Thread // thread 2 uses a for loop to add 5000 to global variable x 
	{
	    public void run()
	    {
	        for(int i = 0; i < 5000; i++)
	            {
	        	ThreadExample.x = ThreadExample.x + 1;
	            }

	    }
}
