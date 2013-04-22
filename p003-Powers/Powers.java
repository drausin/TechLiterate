
import java.util.Scanner;

public class Powers {

	/**
	 * Print the powers of a given number.
	 * 
	 * @author Drausin Wulsin
	 * @since 04/17/2013
	 */
	public static void main(String[] args) {
		
		// init our Scanner
		Scanner sc = new Scanner(System.in);
		
		int base; 	// our base
		int numPowers;	// the number of powers of the base to print
		
		// get base and numPowers from user
		System.out.print("Enter the base: ");
		base = sc.nextInt();
		System.out.print("Enter the number of powers: ");
		numPowers = sc.nextInt();
		
		// print the powers
		double val;
		for (int p = 0; p < numPowers; p++) {
			
			// calculate current power value
			val = Math.pow(base, p);
			
			System.out.println(	Integer.toString(base) + "^" + 
							   	Integer.toString(p) + " = " + 
							   	Double.toString(val)	);
		}
		

	}

}
