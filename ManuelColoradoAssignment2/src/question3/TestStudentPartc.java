package question3;

import java.util.ArrayList;
import java.util.Scanner;

public class TestStudentPartc {
	private enum Menu {ADD, REMOVE, LIST, EXIT};
	private static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<Student> studentList = new ArrayList<Student>();
		
	
	private static String getOption() {
		System.out.println("Please select an option:");
		System.out.println("1. Add a student");
		System.out.println("2. Remove a student");
		System.out.println("3. List all students");
		
		return keyboard.next();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Student Manager 0.1beta");
		Menu option = null;
		
		while(option != Menu.EXIT) {
			
			switch(getOption()) {
				case "1":
					option = Menu.ADD;
					addStudent();
					break;
				case "2":
					option = Menu.REMOVE;
					removeStudent();
					break;
				case "3":
					option = Menu.LIST;
					listStudents();
					break;
				case "0":
					option = Menu.EXIT;
					break;
				default:
					option = null;
					System.out.println("Incorrect option.");
			} 
		}
		
		System.out.println("Thanks for using Student Manager.");
	}

	private static void listStudents() {
		if (studentList.size() <= 0) {
			System.out.println("No students in the database yet.");
		} else {
			for (Student student: studentList) {
				System.out.println(student.toString());
			}
		}
	}

	private static void removeStudent() {
		if (studentList.size() <= 0) {
			System.out.println("No students in the database yet.");
		} else {
			for (Student student: studentList) {
				System.out.println( studentList.indexOf(student) + ". " + student.firstName + " " + student.lastName);
			}
			System.out.println("Please enter the ID of the student to delete: ");
			int idToDelete = Integer.parseInt(keyboard.next());
			studentList.remove(idToDelete);
		}	
	}

	private static void addStudent() {
		System.out.println("Please enter the name of the student to add: ");
		String firstName = keyboard.next();
		System.out.println("Please enter the surname of " + firstName + ": ");
		String lastName = keyboard.next();
		System.out.println("Please enter the mark of " + firstName + " " + lastName + ": ");
		int mark = Integer.parseInt(keyboard.next());
		
		studentList.add(new Student(firstName, lastName, mark));
		System.out.println(firstName + " " + lastName + " added successfully.");
	}

}


/* Question 3, part b
 * 
 * ArrayLists are created dynamically so you don't have to set up a maximum size on creation
 * They also allow an easier to implement search function, as you don't have to transverse
 * the arraylist to find an element. 
 * However, the memory footprint is higher, and insertion/deletion operations are on a higher O value
 * than regular arrays. Accessing an element on a regular array is also quicker if performed by index.
 * 
 * */
