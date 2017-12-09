package question1;

import java.util.Scanner;

public class Menu {
	
	private Controller app;
	
	public Menu() {
		this.app = new Controller();
	}
	
	public void printMenu() {
		// Obtains lecturer name
		String lecturer = app.showActiveLecturer();
		// Prints menu header
		System.out.println();
		System.out.println("####     Menu:     ####");
		// Prints active lecturer name
		if (!lecturer.equals("")) {
			System.out.println("Active Lecturer: " + lecturer);
		}
		System.out.println("1. Add a lecturer to the database");
		System.out.println("2. Find a lecturer on the database and mark it as active");
		// Hides menu for adding books to a lecturer if there's no active lecturer
		if (!lecturer.equals("")) {
			System.out.println("3. Add a book to the lecturer's book list");
			System.out.println("4. Remove a book from the lecturer's book list");
			System.out.println("5. Search for a book using ISBN");
			System.out.println("6. Calculate the total payment for the year");
			System.out.println("7. Save database");
		}
		System.out.println();
		System.out.println("0. Exit");
	}

	public void start() {
		// Prints app header
		System.out.println("#######################");
		System.out.println("Welcome to BookList app");
		System.out.println("#######################");
		
		String option = "";
		Scanner keyInput = new Scanner(System.in);

		// Loop and switch between menu options
		while (!option.equals("0")) {
			printMenu();
			System.out.println("Please enter option: ");
			option = keyInput.next();
			switch(option) {
				case "1":
					app.Add();
					break;
				case "2":
					app.Find();
					break;
				case "3":
					app.AddBook();
					break;
				case "4":
					app.RemoveBook();
					break;
				case "5":
					app.SearchBook();
					break;
				case "6":
					app.CalculatePayment();
					break;
				case "7":
					app.Save();
					break;
				case "0":
					System.out.println("Thanks for using this app.");
					break;
				default:
					System.out.println("Wrong option selected. Please enter a new one.");
					option = "";
			}
		}
		keyInput.close();
	}
}
