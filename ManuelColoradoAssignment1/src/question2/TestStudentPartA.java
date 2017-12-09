package question2;

import java.util.ArrayList;
import java.util.Scanner;

public class TestStudentPartA {
	//Minimum students to log according to spec
	private final static int MINIMUMSTUDENTS = 20;

	public static void main(String[] args) {
		// List to store all Students information
		ArrayList<Student> studentRecord = new ArrayList<Student>();
		
		// Scanner to read from keyboard
		Scanner keyboard = new Scanner(System.in);
		
		// We request the amount of students to process. Needs to be above the MINIMUM
		int totalStudents = 0;
		while (totalStudents < MINIMUMSTUDENTS) {
			System.out.println("Please enter the amount of students you're recording today: ");
			totalStudents = keyboard.nextInt();
			if (totalStudents < MINIMUMSTUDENTS) {
				System.out.println("That's too few. You need to record at least " + MINIMUMSTUDENTS + " per session.");
			}
		}
		
		// We loop as many times as students were requested in previous input
		for (int i = 0; i < totalStudents; i++) {
			String firstName, lastName;
			int mark;
			
			// Ask for student data by console, and store it in temporary variables
			System.out.println("Please enter the first name of the student: ");
			firstName = keyboard.next();
			System.out.println("Please enter the last name of the student: ");
			lastName = keyboard.next();
			System.out.println("Please enter marks for " + firstName + " " + lastName + ": ");
			mark = keyboard.nextInt();
			
			// Used variables to create a new Student object, and add it to the list
			studentRecord.add(new Student(firstName, lastName, mark));
		}
		keyboard.close(); // Close Scanner object to garbage collector
		
		// List of total results entered in this session
		System.out.println("The grades entered today are:");
		// We loop the entire list 
		for (Student student: studentRecord) {
			// and print each Student object by console
			System.out.println(student.toString());
		}
	}
}
