
import java.util.Scanner;

public class ISBNChecker {

	/**
	 * Check that an ISBN number is valid.
	 * 
	 * @author Drausin Wulsin
	 * @since 05/02/2013
	 */
	public static void main(String[] args) {
		
		// init
		Scanner sc = new Scanner(System.in);
		String isbn;
		
		// get the ISBN
		System.out.print("Enter an ISBN: ");
		isbn = sc.nextLine();
		sc.close();
		
		// strip out spaces and dashes by replacing with empty char
		//isbn = isbn.replace(" ", "").replace("-", "");
		isbn = isbn.replaceAll("( |-)", "");
		
		// check depending on length
		boolean isValid;
		if (isbn.length() == 10) {
			isValid = CheckISBN10(isbn);
		} else if (isbn.length() == 13) {
			isValid = CheckISBN13(isbn);
		} else {
			isValid = false;
		}
		
		// print check status
		if (isValid) {
			System.out.println(isbn + " IS a valid ISBN");
		} else {
			System.out.println(isbn + " IS NOT a valid ISBN");
		}

	}
	
	/**
	 * Check a 10-digit ISBN
	 * 
	 * @param isbn	the ISBN digits string, with the last digit possibly 'X'
	 * @return 			whether the ISBN is valid in the 10-digit scheme 
	 */
	private static boolean CheckISBN10(String isbn) {
		
		// calc sum of digits times 10,...,1, respectively
		int sum = 0;
		String dStr;
		for (int d = 0; d < 10; d++){
			dStr = isbn.substring(d, d + 1);
			if (d < 9 || dStr != "X") {
				sum += Integer.parseInt(dStr) * (10-d);
			} else {
				sum += 10;
			}
		}
		
		return (sum % 11 == 0);
		
	}
	
	/**
	 * Check a 13-digit ISBN
	 * 
	 * @param isbn	the ISBN digits string, where all values are 0-9
	 * @return			whether the ISBN is valid in the 13-digit scheme
	 */
	private static boolean CheckISBN13(String isbn) {
		
		// calc sum of first 12 digits times 1, 3, 1, 3, ..., 1, respectively
		int sum = 0;
		int dVal;
		for (int d = 0; d < 13; d++) {
			dVal = Integer.parseInt(isbn.substring(d, d+1));
			if (d % 2 == 0) { // if we have an odd digit
				sum += dVal * 1;
			} else {
				sum += dVal * 3;
			}
		}
		
		return (sum % 10 == 0);
		
	}

}
