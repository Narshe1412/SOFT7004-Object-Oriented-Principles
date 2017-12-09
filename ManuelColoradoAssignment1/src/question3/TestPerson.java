package question3;

public class TestPerson {

	public static void main(String[] args) {
		// Creates a person object to test Person class
		// Default constructor not available, using random data to test
		Person testp = new Person(3, "086 88 77 66", "John Doe");
		
		// Testing both jump actions, with and without a parameter
		testp.jump();
		testp.jump(7);
		
		// Testing class contents printing. It calls toString and prints to console
		testp.print();
	}
}
