import java.util.Scanner;

public class Runner {
	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		Fraction f1 = new Fraction (1, 2);         // represents one-half
		System.out.print ("One Half =");
		System.out.println (f1);                   // should output   1 / 2
		f1.setNumerator (3);                       // change numerator to 3
		f1.setDenominator (4);                     // change denominator to 4
		int num = f1.getNumerator ();              // get the numerator
		int den = f1.getDenominator ();            // get the denominator
		System.out.print ("Three Quarters =");
		System.out.println (" "+ num + "/" + den);      // should output 3 / 4
		Fraction f2 = new Fraction (2, 3);
		System.out.print ("Two Thirds =");
		System.out.println (f2);
		Fraction sum = f1.add(f2);
		System.out.println (f1 + "+" + f2 + "=" + sum);
		f2 = new Fraction (1, 2);
		sum = f1.add(f2);
		Fraction difference = f1.subtract(f2);
		Fraction product = f1.multiply(f2);
		Fraction quotient = f1.divide(f2);
		System.out.println ("f1: " + f1);
		System.out.println ("f2: " + f2);
		System.out.println ("sum: " + sum);
		System.out.println ("difference: " + difference);
		System.out.println ("product: " + product);
		System.out.println ("quotient: " + quotient);
		f1 = new Fraction (1, 2);
		f2 = new Fraction (1, 2);
		System.out.println (f1 + "==" + f2 + " = " + f1.equals (f2));
		System.out.println (f2 + "==" + f1 + " = " + f2.equals (f1));

		f2 = new Fraction (1, 3);
		System.out.println (f1 + "==" + f2 + " = " + f1.equals (f2));
		System.out.println (f2 + "==" + f1 + " = " + f2.equals (f1));

		f2 = new Fraction (2, 4);
		System.out.println (f1 + "==" + f2 + " = " + f1.equals (f2));
		System.out.println (f2 + "==" + f1 + " = " + f2.equals (f1));
		
		line();
		System.out.println("This is Extension 1 Material.");
		f1 = new Fraction (1, 2);
		f2 = new Fraction (3, -5);
		sum = f1.add(f2);
		System.out.println ("Minus Sign: " + sum); // properly placed minus
		f1 = new Fraction (3, 0);
		System.out.println ("3 / 0: " + f1);   // "infinity"
		sum = new Fraction (0, 0);
		System.out.println ("0 / 0: " + sum);   // "undefined"

		
		line();
		System.out.println("Enter a numerator as an integer");
		num = reader.nextInt();
		f1.setNumerator(num);
		System.out.println("Enter a denominator as an integer");
		den = reader.nextInt();
		f1.setDenominator(den);
		String s = "";
		do {
			System.out.println("Enter an operator (+, -, *, /, =): ");
			s = reader.nextLine();
		} while(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("=")));
		System.out.println("Enter a numerator as an integer");
		num = reader.nextInt();
		f2.setNumerator(num);
		System.out.println("Enter a denominator as an integer");
		den = reader.nextInt();
		f2.setDenominator(den);
		if (s.equals("+")) {
			System.out.println("Sum: " + f1.add(f2));
		} else if (s.equals("-")) {
			System.out.println("Difference: " + f1.subtract(f2));
		} else if (s.equals("*")) {
			System.out.println("Product: " + f1.multiply(f2));
		} else if (s.equals("/")) {
			System.out.println("Difference: " + f1.divide(f2));
		} else if (s.equals("=")) {
			System.out.println(f1.equals(f2));
		}
	}
	
	static void line() {
		System.out.println();
	}
}
