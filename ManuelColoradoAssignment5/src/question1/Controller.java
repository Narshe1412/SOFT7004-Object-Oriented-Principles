package question1;

import java.util.Scanner;

import question1.model.Book;
import question1.model.Lecturer;
import question1.model.LecturerList;
import question1.services.FileService;

public class Controller {
	private Scanner keyboard;
	private LecturerList lecturerList;
	
	public Controller() {
		// We try to load the previous database
		lecturerList = load();
		// If it does not exists or throws an error create a new one
		if (lecturerList == null) {
			lecturerList = new LecturerList(100);
		}
		keyboard = new Scanner(System.in);
	}

	public void Add() {
		// Handles the lecturer and ID input
		System.out.println("Please enter the name of the lecturer:");
		String name = keyboard.nextLine();
		System.out.println("Please enter the ID of the lecturer");
		try {
			// Handles non INT values for ID
			int id = Integer.parseInt(keyboard.nextLine());
			Lecturer lect = new Lecturer(name, id);
			// Adds the lecturer to the list
			lecturerList.add(lect);
			// Checks if we already have an active lecturer. If we don't, sets it up as active
			if(lecturerList.getActiveLecturer() == null) {
				lecturerList.setActiveLecturer(name);
			}
		} catch (Exception e) {
			System.out.println("Lecturer not added. You need to enter a numerical ID.");
		}
		
	}

	public void Find() {
		// Handles finding a new lecturer and setting up as Active
		System.out.println("Please enter the name of the lecturer:");
		String name = keyboard.nextLine();
		int position = lecturerList.search(name);
		
		if (position < 0) {
			System.out.println("Couldn't find " + name + " in the lecturer list.");
		} else {
			lecturerList.setActiveLecturer(name);
		}
	}

	public void AddBook() {
		// Handles getting the input of a new book to add to the book list
		System.out.println("Please enter the title of the new book");
		String title = keyboard.nextLine();
		System.out.println("Please enter the name of the author");
		String author = keyboard.nextLine();
		try {
			// Catches non numeric values for ISBN (int) and price (double)
			System.out.println("Please enter the ISBN");
			int isbn = Integer.parseInt(keyboard.nextLine());
			System.out.println("Please enter the price");
			double price = Double.parseDouble(keyboard.nextLine());
			lecturerList.getActiveLecturer().addBook(new Book(title, isbn, author, price));
			System.out.println("Book " +  title + " added to the list.");
		} catch (Exception e){
			System.out.println("Book not added. You need to enter numerical values for price and ISBN.");
		}
	}

	public void RemoveBook() {
		// Handles removing the books
		System.out.println("Please enter the ISBN of the book to remove:");
		try {
			// Catches non INT values for ISBN
			int isbn = Integer.parseInt(keyboard.nextLine());
			if (lecturerList.getActiveLecturer().getBookList().search(isbn) < 0) {
				// Show an error if we cannot locate the book
				System.out.println("Book does not exist.");
			} else {
				boolean success = lecturerList.getActiveLecturer().getBookList().removeBook(isbn);
				// Check if we could delete the book or it has been removed
				if (success) {
					System.out.println("Book has been removed successfully.");
				} else {
					System.out.println("Something went wrong when deleting the book.");
				}
			}
		} catch ( Exception e) {
			System.out.println("ISBN needs to be of numerical value.");
		}
	}

	public void SearchBook() {
		// Handles the search of books by ISBN
		System.out.println("Please enter the ISBN of the book to remove:");
		try {
			// Test if ISBN is INT value. Otherwise throw an error
			int isbn = Integer.parseInt(keyboard.nextLine());
			int index = lecturerList.getActiveLecturer().getBookList().search(isbn);
			if ( index < 0) { // If index < 0 means we didn't found
				System.out.println("Book does not exist.");
			} else {
				System.out.println("Book found. Details: ");
				System.out.println(lecturerList.getActiveLecturer().getBookList().getBook(index));
			}
		} catch ( Exception e) {
			System.out.println("ISBN needs to be of numerical value.");
		}
	}

	public void CalculatePayment() {
		// Handles calling payment calculator and printing it
		double total = lecturerList.getActiveLecturer().getBookList().calculateYearlyBookPayment();
		if (total < 0) { // If payment < 0 means no books were present
			System.out.println("The list of books is empty.");
		} else {
			System.out.println("The total payment for " +  showActiveLecturer() + " is " + total);
		}
	}

	public void Save() {
		// Saves the database to a file
		FileService fs = new FileService();
		boolean result = fs.SaveFile("lecturer.dat", lecturerList);
		if (result) {
			System.out.println("Database saved successfully");
		} else {
			System.out.println("Something went wrong when saving the file.");
		}
	}
	
	public LecturerList load() {
		// Load database from file and returns it for implementation
		FileService fs = new FileService();
		return (LecturerList) fs.LoadFile("lecturer.dat");
	}
	
	public String showActiveLecturer() {
		// Gets active lecturer name, if it's null means no lecturer is active
		if (lecturerList.getActiveLecturer() == null) return "";
		return lecturerList.getActiveLecturer().getName();
	}
}
