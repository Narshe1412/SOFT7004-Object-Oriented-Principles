package main;

import java.util.Scanner;

public class Menu {
	Controller app;

	public Menu() {
		this.app = new Controller();
	}

	public void start() {
		Scanner keyboard = new Scanner(System.in);
		String option = "";

		while (!option.equals("5")) {
			printMenu();
			option = keyboard.nextLine();
			switch (option) {
			case "1":
				app.displayAvailableRooms();
				break;
			case "2":
				app.displayGuests();
				break;
			case "3":
				menuReservation();
				break;
			case "4":
				app.processPayment();
				break;
			case "5":
				app.exit();
				break;
			default:
				System.out.println("Wrong option selected.");
			}
		}
		
	}

	private void menuReservation() {
		String option = "";
		Scanner keyboard = new Scanner(System.in);

		while (!option.equals("5")) {
			printMenu();
			option = keyboard.nextLine();
			switch (option) {
			case "1":
				app.newReservation();
				break;
			case "2":
				app.viewReservation();
				break;
			case "3":
				app.cancelReservation();
				break;
			case "4":
				app.exit();
				break;
			default:
				System.out.println("Wrong option selected.");
			}
		}
		
	}

	public void printMenu() {
		System.out.println("Welcome to CIT Hotel Management System");
		System.out.println("**************************************");
		System.out.println("1)  Display Available Rooms");
		System.out.println("2)  Display Guests");
		System.out.println("3)  Process Reservation");
		System.out.println("4)  Process Payment");
		System.out.println("5)  Exit");
	}

	public void printMenuReservations() {
		System.out.println("Welcome to Reservations");
		System.out.println("**************************************");
		System.out.println("1)  New Reservation");
		System.out.println("2)  View Reservation");
		System.out.println("3)  Cancel Reservation");
		System.out.println("4)  Return");
	}
}
