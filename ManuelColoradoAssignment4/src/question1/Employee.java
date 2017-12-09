package question1;

public abstract class Employee {
	private String name;
	private int number;
	private static int id = 1;
	
	public Employee(String name) {
		setName(name);
		setNumber(id);
		id++;
	}
	// Part a) Creating an abstract method for the class means the class also needs to be created as abstract
	// Abstract classes cannot be used until all their abstract methods are implemented after inherited
		
	public abstract String getStatus(); 
	public abstract void print();
	
	// Accessors
	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	//Mutators
	public void setName(String name) {
		this.name = name; 
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
