package question3;

public class Student {

	String firstName;
	String lastName;
	int mark;
	
	// Constructor
	public Student(String firstName, String lastName, int mark) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
	}
	
	// Accessors
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getMark() {
		return mark;
	}
	
	public String getGrade() {
		String grade = "Fail";
		if (mark >= 85) {
			grade = "Distinction";
		} else if (mark >= 65) {
			grade = "Merit";
		} else if (mark >= 40) {
			grade = "Pass";
		}
		return grade;
	}
	
	public String toString() {
		return firstName + " " + lastName + " received a " + getGrade() + " for his mark of " + mark;
	}
	
	// We don't need mutators as we don't want this class to be modified outside the constructor
}
