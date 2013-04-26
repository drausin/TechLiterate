
import java.util.Scanner;

public class DayOfWeek {

	/**
	 * Calculate the day of the week for a particular date.
	 * 
	 * @author Drausin Wulsin
	 * @since 04/25/2013
	 */
	public static void main(String[] args) {
		
		// inits
		Scanner sc = new Scanner(System.in);
		int month;
		int day;
		int year;
		
		// get the month, day, and year
		System.out.print("month: ");
		month = sc.nextInt();
		System.out.print("day: ");
		day = sc.nextInt();
		System.out.print("year: ");
		year = sc.nextInt();
		sc.close();
		
		// use Gauss's method for determining the first day of the year
		double m;
		int y;
		int dow;
		m = (month - 2 + 12) % 12; // calc month offset, i.e, Mar = 1
		if (month <= 2){ // decrement year if month is Jan or Feb
			year--;
		}
		y = 5 * (year % 4) + 4 * (year % 100) + 6 * (year % 400);
		dow = (day + (int)(2.6*m - 0.2) + y) % 7;
		
		// ouput
		System.out.print("Day of week (Sun = 0, ..., Sat = 6): " + dow);

	}

}
