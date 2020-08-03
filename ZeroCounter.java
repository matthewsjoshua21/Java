import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.IntStream;

/* This Program will take a number from the user,
 * convert the number to binary, and count the consecutive zeros
 * using intstream and iterator.
 */
public class ZeroCounter {

	public static void main(String[] args) {
		// variable for user value
		int userValue;
		//create runner
		ZeroCounter runner = new ZeroCounter();
		
		System.out.print("Enter a number to count the Zeros in binary: ");
		//take value from user
		try (Scanner scanner = new Scanner(System.in)) {
			userValue = scanner.nextInt(); 
		}
		//create variable for return value
		int numZeros = runner.streamCounter(userValue);
		
		System.out.println("The number of consecutive zeros = " + numZeros);
	}
	//function to count binary zeros
	public int streamCounter(int binaryNumber) {
		//convert int to binary and store in string
		String binNum = Integer.toBinaryString(binaryNumber);
		
		System.out.println(binaryNumber + " in binary is: " + binNum);
		
		IntStream stream = binNum.chars();
		
		Iterator itr = stream.iterator();
		//variable for 0's
		int x = 0;
		//variable to store max value
		int y = 0;
		//iterate through string
		while (itr.hasNext()) {
			int position = (int) itr.next();
			//check ascii = 0
			if (position == 48) {
				x++;
			}
			//check ascii = 1
			if (position == 49) {
				//check that x is greater
				if (y < x) {
					y = x;
				}
				//reset variable
				x = 0;
			}
			
		}
		//return largest value
		return y;
	}
}
