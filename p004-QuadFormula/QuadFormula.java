
import java.util.Scanner;

public class QuadFormula {

	/**
	 * Calculate the roots of a quadratic equation using the quadratic formula.
	 * 
	 * @author Drausin Wulsin
	 * @since 04/23/2013
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double a;
		double b;
		double c;
		double discrim;
		double root1, root2;
		
		// display an intro message
		System.out.println("The quadratic formula finds the root(s)\n" + 
				"where f(x) = 0 of the quadratic equation\nf(x) = " + 
				"ax^2 + bx + c\n");
		
		// get the quadratic equation coefficients
		System.out.println("Enter the coefficients of your equation");
		System.out.print("a: ");
		a = sc.nextInt();
		System.out.print("b: ");
		b = sc.nextInt();
		System.out.print("c: ");
		c = sc.nextInt();
		sc.close();
		
		// calculate discriminant, i.e., b^2 - 4*a*c
		discrim = b*b - 4*a*c;
		
		// modify output depending on sign of discriminant
		if (discrim > 0){
			root1 = (-b + Math.sqrt(discrim)) / (2*a);
			root2 = (-b - Math.sqrt(discrim)) / (2*a);
			System.out.println("Two real roots: " + root1 + " and " + root2);
		} else if (discrim == 0) {
			root1 = -b / (2*a);
			System.out.println("One real root: " + root1);
		} else {
			System.out.println("Two imaginary roots: " + (-b/(2*a)) + " +/- i" + 
					Math.sqrt(-discrim));
		}
		

	}

}
