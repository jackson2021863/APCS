/**
 * This class stores a fraction as an object to avoid it being stored imprecisely.
 * @author Dr. Cheese
 * Date: 10/11/19
 */
public class Fraction {
	int num;
	int den;
	int wnumber;
	
	/**
	 * The proper constructor.
	 * @param num Numerator
	 * @param den Denominator
	 */
	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
		if (this.den < 0) { //checks if the denominator is negative to switch it if necessary
			this.num = -this.num;
			this.den = -this.den;
		}
	}
	
	/**
	 * A variant constructor that I decided not to use.
	 * @param wnumber Whole Number
	 * @param num Numerator
	 * @param den Denominator
	 */
	public Fraction(int wnumber, int num, int den) {
		this.wnumber = wnumber;
		this.num = num;
		this.den = den;
	}
	
	/**
	 * Prints the fraction as a fraction. Example: a/b
	 */
	public String toString() {
		String x = "";
		x += " " + num + "/" + den + " ";
		if (den == 0) { 
			if (num == 0) {
				x = "Undefined"; // if it's 0/0, it's undefined
				return x;
			}
			x = "Infinity"; // if it's any number / 0, it's infinity
		}
		return x;
	}
	
	/**
	 * Adds two different Fractions together.
	 * @param other Fraction object
	 * @return Fraction object
	 */
	public Fraction add(Fraction other) {
		int newN1 = this.num * other.getDenominator(); // multiplies the first numerator by the second denominator
		int newN2 = this.den * other.getNumerator(); // multiplies the second numerator by the first denominator
		int newN = newN1 + newN2; // evaluates the algebra
		
		int newD = this.den * other.getDenominator(); // finds the new denominator
		
		if (newN % newD == 0 && newN != 0) {
			newN = newD = 1; // if the fraction can simplify to 1/1, makes it equal that
		} else if (newN == 0) {
			newD = 1; // if the numerator is 0, stores the denominator as 1 for reading purposes
		}
		
		Fraction o = new Fraction(newN, newD);
		return o;
	}
	
	/**
	 * Subtracts another Fraction from the one receiving the message.
	 * @param other Fraction object
	 * @return Fraction object
	 */
	public Fraction subtract(Fraction other) {
		int newN1 = this.num * other.getDenominator(); // multiplies the first numerator by the second denominator
		int newN2 = this.den * other.getNumerator(); // multiplies the second numerator by the first denominator
		int newN = newN1 - newN2; // evaluates the algebra
		
		int newD = this.den * other.getDenominator(); // finds the new denominator
		
		if (newN % newD == 0 && newN != 0) {
			newN = newD = 1; // if the fraction can simplify to 1/1, makes it equal that
		} else if (newN == 0) {
			newD = 1; // if the numerator is 0, stores the denominator as 1 for reading purposes
		}
		
		Fraction o = new Fraction(newN, newD);
		return o;	
	}
	
	/**
	 * Multiplies two Fractions objects.
	 * @param other Fraction object
	 * @return Fraction object
	 */
	public Fraction multiply(Fraction other) {
		int newN = this.num * other.getNumerator(); // finds the new numerator by multiplying the first one by the second
		int newD = this.den * other.getDenominator(); // finds the new denominator by multiplying the first one by the second
		
		if (newN % newD == 0 && newN != 0) {
			newN = newD = 1; // if the fraction can simplify to 1/1, makes it equal that
		} else if (newN == 0) {
			newD = 1; // if the numerator is 0, stores the denominator as 1 for reading purposes
		}
		
		Fraction o = new Fraction(newN, newD);
		return o;
	}
	
	/**
	 * Divides this fraction from another one by multiplying by the reciprocal.
	 * @param other Fraction object
	 * @return Fraction object
	 */
	public Fraction divide(Fraction other) {
		int newN = this.num * other.getDenominator(); // finds the new numerator by multiplying the first numerator by the second denominator, following the rule of dividing by a/b = multiplying by b/a
		int newD = this.den * other.getNumerator(); // finds the new denominator by multiplying the first denominator by the second numerator, following the rule of dividing by a/b = multiplying by b/a
		
		if (newN % newD == 0 && newN != 0) {
			newN = newD = 1; // if the fraction can simplify to 1/1, makes it equal that
		} else if (newN == 0) {
			newD = 1; // if the numerator is 0, stores the denominator as 1 for reading purposes
		}
		
		Fraction o = new Fraction(newN, newD);
		return o;
	}
	
	/**
	 * Checks if this Fraction is equal to another, including different multiples of a Fraction.
	 * @param other Fraction object
	 * @return boolean
	 */
	public boolean equals(Fraction other) {
		if (this.num * other.getDenominator() == this.den * other.getNumerator()) {
			return true; // if you cross-multiply and the two answers equal each other, the fraction is equal
		}
		
		return false;
	}
	
	/**
	 * It doesn't work.
	 * @param other Fraction
	 * @return result
	 */
	public Fraction exp(Fraction other) {
		int N = num;
		for (int i = 1; i < other.getNumerator(); i++) {
			N *= num;
		}
		int D = den;
		for (int i = 1; i < other.getDenominator(); i++) {
			D *= den;
		}
		Fraction f = new Fraction(N, D);
		return f;
	}

	/**
	 * Gets the value of the numerator.
	 * @return int Numerator
	 */
	public int getNumerator() {
		return num;
	}

	/**
	 * Sets the value of the numerator equal to what the coder would like to change it to.
	 * @param num int
	 */
	public void setNumerator(int num) {
		this.num = num;
	}

	/**
	 * Gets the value of the denominator.
	 * @return int Denominator
	 */
	public int getDenominator() {
		return den;
	}

	/**
	 * Sets the value of the denominator equal to what the coder would like to change it to.
	 * @param den int
	 */
	public void setDenominator(int den) {
		this.den = den;
	}
}
