package question3;

public class Person {
	int stars; 		// Person rating
	String phone;	// Person's phone number
	String name;	// Person's name
	
	// Constructor
	public Person(int stars, String phone, String name) {
		setStars(stars);
		setPhone(phone);
		setName(name);
	}
	
	// Public class actions and methods
	public void jump() {
		//Defines a default action Jump for a person
		System.out.println("I jumped");
	}
	
	public void jump(int times) {
		//Defines an action Jump for a person. It can jump 'times' amount.
		System.out.println("I jumped " + times + " times!");
	}
	
	public String toString() {
		//Returns class contents overriding default toString
		return "Object contents: " +
				"\nstars: \t" + stars +
				"\nphone: \t" + phone +
				"\nname: \t" +  name;
	}
	
	public void print() {
		//Prints class contents to the console
		System.out.println(toString());
	}

	
	// Accessors / mutators
	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
