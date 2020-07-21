import java.util.stream.IntStream;

public class Triangle {

	public static void main(String[] args) {
		//variable for levels of triangle
		int x = 10;

		//iterate for j times
		for ( ; x >= 0; x--) {  
		 
			//declare final variable for lambda function
			int finalJ = x;
		 
			IntStream.range(0, 10-x ).forEach(s -> {
		       System.out.print(" ");
		   });

		   IntStream.range(0, 2*x-1 ).forEach(s -> {
		       System.out.print("*");
		       if(s == 2*finalJ -2) {
		           System.out.println();
		       }});
		}

	}
}
