package question2;

public class Student {
	private String firstName; 	// Name of the student
	private String lastName;	// Surname of the student
	private int mark;			// Mark of the student
	
	// Constructor
	public Student(String firstName, String lastName, int mark) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
	}
	
	public String toString() {
		// Returns name and result to be printed by UI
		return firstName + " " + lastName + " received a " + resultName(mark) + " for a mark of " + mark;
	}

	private String resultName(int mark) {
		// Translates numeric result to their equivalent grade mark
		String result = "";
		
		if (mark >= 85) { 
			result = "Distinction"; 	// Result above 85 gets Distinction
		} else if (mark >= 65 && mark <= 84) {
			result = "Merit";		// Result between 65 and 84 gets Merit
		} else if (mark >= 40 && mark <= 64) {
			result = "Pass";		// Result between 40 and 64 gets Pass
		} else {					
			result = "Fail";		// Otherwise gets Fail
		}

		return result;
	}
	
	// We don't create mutators or accessors as we don't want this class
	// to be modified outside the Constructor

}
