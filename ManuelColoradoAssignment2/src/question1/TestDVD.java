package question1;

public class TestDVD {

	public static void main(String[] args) { // Part a) Comments
		DVD dvd1 = new DVD(); 			//Creates a new instance of the DVD class using default constructor
		dvd1.setTitle("Song Bird");		//Set the property title of this instance
		dvd1.setGenre("Blues");			//Set the property genre of this instance
		dvd1.setArtist("Eva Cassidy");	//Set the property artist of this instance
		dvd1.print();					//Prints the content of this object (probably as workaround of toString)
		
		DVD dvd2 = new DVD("Johnny B. Goode", "Chuck Berry"); // Creates a new instance of the DVD class using a custom
															  // constructor that takes song and artist as parameters
		dvd2.print(); //Prints the content of this object

		//Part b) Fixing errors
		/* Aside from having to create a new class, several improvements can be made to this code.
		 * First of all, when instancing dvd1, we're using a default constructor and then using accessors
		 * to update its fields. This adds a lot of unnecessary explicit declarations that can be avoided by using a
		 * custom constructor defined by us.
		 * 
		 * On the other hand when creating dvd2 instance, we're missing the genre in our constructor.
		 * This may be because the parameter genre is optional or we need to use an accessor to modify it
		 * 
		 * On the very last line, the method print() is not defined in our class. I assume that we're calling
		 * the print method of the DVD class and I've updated 
		 * 		print() => dvd2.print()
		 * 
		 * As the last step, I've created the DVD class in a separate module.
		 * 
		 * */
	}
}
