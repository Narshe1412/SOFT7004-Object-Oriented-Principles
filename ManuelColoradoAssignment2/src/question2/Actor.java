package question2;

import java.util.ArrayList;

public class Actor {
	private String name;
	private String address;
	private int age;
	//private Film[] myFilm;  commented as per exercise requirements
	private ArrayList<Film> myFilm; //Updated myFilm variable to be an arraylist instead of regular array
	
	// Constructor
	public Actor(String name, String address, int age) {
		setName(name);
		setAddress(address);
		setAge(age);
		//myFilm = new Film[3];
		myFilm = new ArrayList<>();
	}
	
	// Mutators
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setFilm(Film[] film) { 
		//The main program is still working with array of Films, so we do this implementation
		//to fill the ArrayList with our Film array
		//this.myFilm = film; 
		for (int i = 0; i < film.length; i++) {
			myFilm.add(film[i]);
		}
	}
	
	// Accessors
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getAge() {
		return age;
	}
	
	public Film[] getFilm() {
		//We transform our arraylist to a regular array as our Main still works with regular arrays
		return myFilm.toArray(new Film[myFilm.size()]);
	}
	
	public String toString() {
		String objectContents;
		objectContents = "Name: " + name + 
				"\nAddress: " + address + 
				"\nAge: " + age;
		return objectContents;
	}
	
	public void print() {
		System.out.println(toString());
		System.out.println("Films:");
		for ( Film movie: getFilm()) {
			movie.print();
		}
	}

}
