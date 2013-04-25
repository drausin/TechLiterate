
import java.util.Scanner;

public class Fibonacci {

	/**
	 * Print out numbers in the Fibonacci sequence.
	 * 
	 * @author Drausin Wulsin
	 * @since 04/24/2013
	 * 
	 */
	public static void main(String[] args) {
		
		int numToPrint;
		
		// get the number of numbers to print
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of Fibonacci numbers: ");
		numToPrint = sc.nextInt();
		sc.close();
		
		// init and print the first two numbers in the sequence
		int current = 1;
		int last = 0;
		System.out.println(last);
		System.out.println(current);
		
		int lastlast = 0;
		for (int c = 2; c < numToPrint; c++){
			
			// calculate current value
			lastlast = last;
			last = current;
			current = lastlast + last;
			
			System.out.println(current);
		}

	}

}
