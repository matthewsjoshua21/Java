import java.util.LinkedList;
import java.util.Iterator;

public class Queue {

	public static void main(String[] args) {
		
		//variable for size of LL
		int length = 10000;
		
		LinkedList<Integer> queue = new LinkedList<Integer> ();
		//fill LL
		for (int i=0; i!=length; i++) {
			int x = (int)Math.random();
			queue.add(x);
		}
		
		//variable to compare time
		long time = System.currentTimeMillis();
		//use get method and measure time to access queue
		for (int j=0; j!=length; j++) {
			queue.get(j);
		}
		//calculate total time
		long fTime = System.currentTimeMillis() - time;
		System.out.println("LL get method takes "+ fTime +" ms");
		
		time = System.currentTimeMillis();
		//use iterator and measure access time
		for (Iterator<Integer> itr = queue.iterator(); itr.hasNext();) {
			itr.next();
		}
		fTime = System.currentTimeMillis() - time;
		System.out.println("Iterator method takes "+ fTime +" ms");
	}
	
	
}
