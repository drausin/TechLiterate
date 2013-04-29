
import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {

	/**
	 * The program generates a random number between 1 and N, and the user must
	 * guess it. After each unsuccessful guess, the program tells the user if
	 * the true number is higher or lower than the user's guessed number.
	 * 
	 * @author Drausin Wulsin
	 * @since 04/26/2013
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// get maximum number for program to guess
		int max;
		System.out.print("enter the maximum number: ");
		max = sc.nextInt();
		
		// generate target number
		Random gen = new Random();
		int target = 1 + gen.nextInt(max-1);
		
		// start guessing loop
		int numGuesses = 1;
		int curGuess = 0;
		System.out.println("Guess a number between 1 and " + max);
		
		for ( ; curGuess != target; numGuesses++){
			
			// get user's next guess
			System.out.print("next guess: ");
			curGuess = sc.nextInt();
			
			// print output based on guess
			if (curGuess < target){
				System.out.println("\t" + curGuess + " is too low");
			} else if (curGuess > target){
				System.out.println("\t" + curGuess + " is too high");
			} else {
				System.out.println("You got it in " + numGuesses + " guesses!");				
			}
			
		}

	}

}
