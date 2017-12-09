/* Part a)	Write code for a class Person. A Person object is to have attributes name, age and address.									     (.5)
Part b) Write code for a class Cat. A Cat object is to have attributes name and age. (.5)
Part c) Give any additional code in the Person and Cat classes that is required to setup a	bidirectional 
	association between a Person object and a Cat object. A Person object acts as 	
	an owner for a Cat object and the Cat object acts as a pet for the Person	object. 	      (1)
Part d) Add new sections to your Person class so that a Person object can act as owner for up to 20 Cat objects.  

 * 
 * */

package question2;

public class Person {
	String name;
	int age;
	String address;
	Cat pet; 		 // part c
	Cat[] menagerie; // part d
	
	//part a
	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.menagerie = new Cat[20]; // part d
	}
	
	//part c
	public void addPet (Cat cat) {
		this.pet = cat;
	}
	
	//part d
	public void addAnotherCat (Cat cat) {
		// Verify the size of the cat array. If the array is full, print error message
		if(menagerie.length >= 20) {
			System.out.println("Error. Cannot add any more cats.");
		} else { // Else add a new cat at the last index of the array
			menagerie[menagerie.length] = cat;
		}
	}

}
