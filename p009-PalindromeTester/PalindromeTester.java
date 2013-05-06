
import java.io.*;
import java.util.Scanner;

public class PalindromeTester {

	/**
	 * Read in possible palindromes from a text file and then determine if each 
	 * is actually a palindrome.
	 * 
	 * @author Drausin Wulsin
	 * @since 05/01/2013
	 */
	public static void main(String[] args) {
		
		// file where our candidate palindroms are stored, one per line
		String palFile = "possible_pals.txt";
		
		// get the array of possible palindomes
		String[] possPals = ReadPalsFile(palFile);

		// process each possible palindrome
		for (int p = 0; p < possPals.length; p++) {
			
			System.out.println("Testing string: " + possPals[p]);
			
			if (isPalindrome(possPals[p])) {
				System.out.println("--> this string IS a palindrome");
			} else {
				System.out.println("--> this string IS NOT a palindrome");
			}
			
			System.out.println();
		}
		
	}
	
	/**
	 * Read the possible palindromes from the text file given in filepath.
	 * 
	 * @param filepath	the (full) path to the file of possible palindromes
	 * @return 			a string array of possible palindromes
	 */
	private static String[] ReadPalsFile(String filepath) {
		
		// create a Scanner object for our file
		File inF = new File(filepath);
		Scanner sc = null;
		try {
			sc = new Scanner(inF);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open " + filepath);
			System.exit(1);
		}
		
		// do an initial scan through the file to determine the number of lines, 
		// i.e., the number of possible palindromes to test
		int numLines = 0;
		for ( ; sc.hasNextLine(); numLines++) {
			sc.nextLine();
		}
		sc.close();
		
		// reset the Scanner object to again read in the file
		try {
			sc = new Scanner(inF);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open " + filepath);
			System.exit(1);
		}
		
		// init String array of possible palindromes
		String[] possPals = new String[numLines];
		for (int l = 0; l < numLines; l++) {
			possPals[l] = sc.nextLine();
		}
		sc.close();
		
		return possPals;
		
	}

	/**
	 * Determine whether a string is indeed a palindrome, ignoring whitespace, 
	 * capitalization, and punctuation.
	 * 
	 * @param possPal	the string to test
	 * @return			true if the string is a palindrome, false otherwise
	 */
	private static boolean isPalindrome(String possPal) {
		
		// to lower
		String possPal_norm = possPal.toLowerCase().replaceAll(" |:|;|\\.|,|'", 
				"");
		
		// init start/end indices
		int startIdx = 0;
		int endIdx = possPal_norm.length() - 1;
		
		// check each pair of characters at the beginning/end 
		for( ; startIdx <= endIdx; startIdx++, endIdx--) {
			if (possPal_norm.charAt(startIdx) != possPal_norm.charAt(endIdx)) {
				
				// characters are different, so return false
				return false;
			}			
		}
		
		// if we've made it to here, that means we have a palindome
		return true;
		
	}

}
