
import java.util.Scanner;

public class SieveOfEratos {

	/**
	 * Print all the prime numbers less than a given number N using the seive of 
	 * Eratosthenes.
	 * 
	 * @author Drausin Wulsin
	 * @since 04/30/2013
	 */
	public static void main(String[] args) {
		
		// get the ceiling on our prime numbers
		int N;
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the prime number ceiling: ");
		N = sc.nextInt();
		sc.close();
		
		// init numbers array, where true denotes primality
		boolean[] isPrime = new boolean[N];
		
		// init possible primes
		isPrime[0] = false; // 1 is not prime
		for (int i = 1; i < N; i++) {
			isPrime[i] = true;
		}
		
		// check every number >= 2 for primality
		for (int i = 2; i <= N; i++){
			
			// i is prime if it hasn't been "crossed off" yet
			if (isPrime[i-1]) {
				
				// print out the prime number
				System.out.println(i);
				
				// "cross off" all the subsequent multiples of i
				//for (int j = 2*i; j <= N; j += i) {
				for (int j = i*i; j <= N; j += i) { // more efficient
					isPrime[j-1] = false;
				}
			}
		}
		
	}

}
