package question2;

public class RationalNumber {
	private int numerator, denominator;
	
	public RationalNumber() {
		// default object if no parameter is created
		this(1,1);
	}
	
	public RationalNumber(int numerator, int denominator) {
		// Verify we don't allow any rational numbers to be created with denominator zero
		if (denominator == 0)
			throw new IllegalArgumentException("Argument denominator is equals to zero");
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public RationalNumber add(RationalNumber operand) {
		// Implement the formula:
		// a/b + c/d = ad + bc / bd
		int num = denominator * operand.numerator + numerator * operand.denominator;
		int den = denominator * operand.denominator;
		// Verify we don't create an illegal rational number
		if (den == 0) 
			throw new IllegalArgumentException("The result of the operation creates an invalid rational number (Division by zero)");
		else
			return new RationalNumber(num, den);
	}
	
	public RationalNumber substract(RationalNumber operand) {
		// Implement the formula:
		// a/b - c/d = ad - bc / bd
		int num = numerator * operand.denominator - operand.numerator * denominator;
		int den = denominator * operand.denominator;
		// Verify we don't create an illegal rational number
		if (den == 0) 
			throw new IllegalArgumentException("The result of the operation creates an invalid rational number (Division by zero)");
		else
			return new RationalNumber(num, den);
	}
	
	public RationalNumber multiply(RationalNumber operand) {
		//Implement the rational number multiplication
		int num = numerator * operand.numerator;
		int den = denominator * operand.denominator;
		return new RationalNumber(num, den);
	}
	
	public RationalNumber divide(RationalNumber operand) {
		//Implement rational number division
		int num = numerator * operand.denominator;
		//Make sure we don't create an illegal rational number
		if (operand.numerator * operand.denominator == 0) 
			throw new IllegalArgumentException("Division by zero");
		else {
			int den = denominator * operand.numerator;
			return new RationalNumber(num, den);
		}
	}
	
	public String toString() {
		return numerator + " / " + denominator;
	}
	
	public void print() {
		System.out.println(toString() + " = " + ((double) numerator / denominator));
	}

}
/*
 * a)	Create a class called RationalNumber to perform arithmetic with fractions. 
 * It encapsulates the concept of one rational number. 
 * Use integer attributes to represent the fraction’s numerator and denominator. 
 * Write two constructors one no argument constructor which sets the numerator and denominator to one. 
 * The other constructor takes two integers used to set the denominator and numerator. 
 * Provide public methods to perform the following operations:
		Add two rational numbers 
		Subtract two rational numbers    
		Multiply two rational numbers
		Divide 
		toString “a  / b”
		Print output the string and floating point (double) value.               
		Add ,subtract multiply and divide methods return a rational number object.            
 * 
 */