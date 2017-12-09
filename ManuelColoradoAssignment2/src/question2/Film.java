package question2;

public class Film {
	private String name;
	private String code;
	
	// Constructor
	public Film(String name) {
		setName(name);
		this.code = name.substring(0, 2);
	}
	
	// Mutators
	public void setName(String name) {
		this.name = name;
	}
	
	
	// Accessors
	public String getName() {
		return name;
	}
	
	public String getCode() {
		return code;
	}
	
	public String toString() {
		return code + "-" + name;
	}
	
	public void print() {
		System.out.println(toString());
	}
}
