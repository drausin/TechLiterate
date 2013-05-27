
import java.util.Scanner;

public class NumberBaseConv {

	/**
	 * Convert a number from one base system to another base system.
	 * 
	 * @author Drausin Wulsin
	 * @since 05/02/2013
	 */
	public static void main(String[] args) {
		
		// inits
		Scanner sc = new Scanner(System.in);
		String origNum;
		String newNum;
		int origBase;
		int newBase;
		
		// get original number and base
		System.out.print("original number: ");
		origNum = sc.nextLine();
		System.out.print("original base: ");
		origBase = sc.nextInt();
		
		// validate original number and base
		ValidateBase(origBase);
		ValidateNumInBase(origNum, origBase);
				
		// get new base to convert to
		System.out.print("new base: ");
		newBase = sc.nextInt();
		sc.close();
		
		// do conversion
		newNum = NumConvertBase(origNum, origBase, newBase);
		
		// print number in new base
		System.out.println("new number: " + newNum);

	}
	
	
	/**
	 * Check that the base is valid, i.e., >= 2, and print error and exit if it 
	 * is not.
	 * 
	 * @param base	the base of a number system
	 */
	private static void ValidateBase(int base) {
		
		// check to ensure base is >= 2 and <= 36
		if (base < 2 || base > 36) {
			System.out.println("error: base must be >= 2 and <= 36");
			System.exit(1);
		}
	}
	
	/**
	 * Check that a number is valid in a given base and print an error and exit
	 * if it is not.
	 * 
	 * @param num	the string representation of the number
	 * @param base	the base of the number system
	 */
	private static void ValidateNumInBase(String num, int base) {
		
		// check that digits of number range from 0-(base-1)
		char chDigit;
		for (int d = 0; d < num.length(); d++){
			chDigit = num.toUpperCase().charAt(d);
			if (Character.isDigit(chDigit) && 
					(chDigit - '0') >= base) {
				System.out.println("Cannot have digit " + chDigit + 
						" in base " + base);
				System.exit(1);
			} else if (Character.isLetter(chDigit) && 
					(chDigit - 'A') + 10 >= base) {
				System.out.println("Cannot have digit " + chDigit + 
						" in base " + base);
				System.exit(1);
			} else if (!Character.isDigit(chDigit) && 
					!Character.isLetter(chDigit) ){
				System.out.println("Invalid digit character " + chDigit);
			}
		}
	}
	
	/**
	 * Convert a number representation from one base to another.
	 * 
	 * @param origNum	the number string in the original base
	 * @param origBase	the original base of the number
	 * @param newBase	the new base to convert the number representation to
	 * @return			the number string in the new base
	 */
	private static String NumConvertBase(String origNum, int origBase, 
			int newBase) {
		
		// get the value of the original number, assuming the lease significant 
		// digit is on the right
		double val = 0;
		double decDigit = 0;
		char chDigit;
		int L = origNum.length();
		for (int p = 0; p < L; p++){
			
			// get the digit character (0-9, A-Z); N.B., toUpperCase() on a 
			// numeric character leaves it the same
			chDigit = Character.toUpperCase(origNum.charAt(L-1-p));
			
			// get the decimal value of our character
			if (Character.isLetter(chDigit)) {
				decDigit = 10 + chDigit - 'A';
			} else if (Character.isDigit(chDigit)) {
				decDigit = chDigit - '0';
			} else {
				System.out.println("error: unrecognized digit " + chDigit);
				System.exit(1);
			}
			
			// add this digit's value to the total
			val += decDigit * Math.pow(origBase, p);
		}
		
		// determine the number of digits in our new base
		int D = 1;
		for ( ; Math.pow(newBase, D) <= val; D++) {}
		
		// create array to hold new digits
		char[] newNum = new char[D];
		double pwr;
		for (int p = D-1; p >= 0; p--){
			
			// calculate digit for this power of newBase
			pwr = Math.pow(newBase, p);
			decDigit = Math.floor(val / pwr);
			val -= decDigit * pwr;
			
			// store digit character
			if (decDigit <= 9) {
				newNum[D-1-p] = (char)('0' + (int)decDigit);
			} else {
				newNum[D-1-p] = (char)('A' + (int)(decDigit-10));
			}
		}
		
		return new String(newNum);
		
	}

}
