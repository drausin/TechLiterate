
import java.util.Scanner;

public class QuadFormula {

	/**
	 * Calculate the roots of quadratic equation using the quadratic formula.
	 * 
	 * f(x) = ax^2 + bx + c
	 * 
	 * examples:
	 *  (x + 2)(x + 2) --> x^2 + 4x + 4 : one real root at -2
	 *  (x - 2)(x + 3) --> x^2 + x - 6 : two real roots at 2 and -3
	 *  2x^2 + 3x + 4 : two imaginary roots at -3/4 +/- i(sqrt(23))/4
	 * 
	 * @author Drausin Wulsin
	 * @since 04/25/2013
	 */
	public static void main(String[] args) {
		
		// inits
		Scanner sc = new Scanner(System.in);
		double a;
		double b;
		double c;
		
		// display an intro message
		System.out.println("The quadratic formula finds the root(s)\n" + 
				"where f(x) = 0 for the function f(x) = ax^2 + bx + c\n");
		
		// get coefficients from the user
		System.out.print("a: ");
		a = sc.nextDouble();
		System.out.print("b: ");
		b = sc.nextDouble();
		System.out.print("c: ");
		c = sc.nextDouble();
		sc.close();
		
		// calculate the discriminant, b^2 - 4ac
		double discrim;
		discrim = b*b - 4*a*c;
		
		double root1, root2;
		double imag;
		
		// modify output depending on sign of discriminant
		if (discrim > 0) { // two real roots
			root1 = (-b + Math.sqrt(discrim))/(2*a);
			root2 = (-b - Math.sqrt(discrim))/(2*a);
			System.out.println("Two real roots: " + root1 + " and " + root2);
		} else if (discrim < 0) { // two imaginary roots
			imag = Math.sqrt(-discrim) / (2*a);
			System.out.println("Two imaginary roots: " + (-b/(2*a)) + " +/- i" + 
					imag);
		} else {
			root1 = -b/(2*a);
			System.out.println("One real root: " + root1);
		}
		
	}

}
