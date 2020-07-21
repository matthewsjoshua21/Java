import java.util.Scanner;

public class factorial {

	//java program to calculate factorial of a number
	 
	public static void main(String[] args) {
		int num;
		System.out.println("\nEnter any number");
		try (Scanner scanner = new Scanner(System.in)) {
			num=scanner.nextInt();
		}
		System.out.println("\nFactorial: "+calcFactorial(num));
	 }

    /*this is a recursive function that calculates
    the factorial of given number.
    */
    
	public static int calcFactorial(int n) {
		if(n==1)
		    return 1;
		//recursive call
		return n*calcFactorial(n-1);
    }


}
