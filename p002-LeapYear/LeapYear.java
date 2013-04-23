
import java.util.Scanner;

public class LeapYear {

	/**
	 * Determine if a year is a leap year
	 * 
	 * @author Drausin Wulsin
	 */
	public static void main(String[] args) {
		
		// declare our Scanner object to read input from the user
		Scanner sc = new Scanner(System.in);
		
		// declare our year variable
		int year;
		
		// prompt user for year to check
		System.out.print("Enter a year: ");
		year = sc.nextInt();
		sc.close();
		
		// check whether year is divisible by 4 but not 100 or divisible by 400
		if (year % 4 == 0 && year % 100 != 0){
			System.out.println(year + " IS a leap year");
		}
		else if (year % 400 == 0){
			System.out.println(year + " IS a leap year");
		}
		else {
			System.out.println(year + " IS NOT a leap year");
		}
		

	}

}
