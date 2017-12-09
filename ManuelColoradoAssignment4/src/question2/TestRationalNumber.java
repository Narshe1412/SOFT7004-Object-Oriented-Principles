package question2;

public class TestRationalNumber {

	public static void main(String[] args) {
		try {
			//Create two rational numbers
			RationalNumber onehalf = new RationalNumber (1,2);
			RationalNumber twothirds = new RationalNumber (2,3);
			
			//Print them on screen
			System.out.println("First rational number:");
			onehalf.print();
			System.out.println("Second rational number:");
			twothirds.print();
			
			//Do all the programmed operations
			System.out.println("The sum of the two rational numbers is: " + onehalf.add(twothirds));
			System.out.println("The difference of the two rational numbers is: " + onehalf.substract(twothirds));
			System.out.println("The product of the two rational numbers is: " + onehalf.multiply(twothirds));
			System.out.println("The division of the two rational numbers is: " + onehalf.divide(twothirds));
		} catch (IllegalArgumentException e) {
			//Catch any division by zero errors and handle the exception
			System.out.println("Error during operation: " + e.getMessage());
		}

	}

}
