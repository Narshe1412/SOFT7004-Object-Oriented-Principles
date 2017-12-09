package main;

import java.util.Scanner;

import exception.TestException;
import guest.Guest;
import guest.Lecturer;
import guest.Student;
import room.Room;
import room.RoomList;
import services.FileService;

public class Controller {

	private RoomList hotel;

	public Controller() {
		FileService fs = new FileService();
		this.hotel = (RoomList) fs.LoadFile("hotel.dat");
		if (this.hotel == null) {
			this.hotel = new RoomList();
		}
	}

	public void displayAvailableRooms() {
		String choice = Room.getTypeOfRoom();
		System.out.println("The amount of free " + choice + " is " + hotel.getFreeRooms(choice));
	}

	public void displayGuests() {
		String choice = Guest.getTypeOfGuest();
		System.out.println("List of current guests of type " + choice + " staying at the hotel:");
		System.out.println(hotel.getGuestList(choice));
	}

	public void processReservation() {
		int roomNo = viewReservation();
		if (roomNo < 0) {
			System.out.println("Room does not exists.");
		} else {
			try {
				Room currentRoom = hotel.getRoomByID(roomNo);
				while (!currentRoom.isFull()) {
					String guestType = Guest.getTypeOfGuest();
					String guestName = Guest.getNameOfGuest();
					switch (guestType) {
					case "lecturer":
						currentRoom.addGuest(new Lecturer(guestName));
						;
						break;
					case "student":
						currentRoom.addGuest(new Student(guestName));
						;
						break;
					default:
						System.out.println("Wrong type of guest chosen.");
					}
				}
			} catch (TestException e) {
				System.out.println("Room does not exists.");
			}
		}
	}

	public void newReservation() {
		int roomNo = hotel.nextAvailableRoom(Room.getTypeOfRoom());
		if (roomNo < 0) {
			System.out.println("Sorry no rooms of that type are available.");
		} else {
			String guestType = Guest.getTypeOfGuest();
			String guestName = Guest.getNameOfGuest();
			switch (guestType) {
			case "lecturer":
				hotel.addReservation(roomNo, new Lecturer(guestName));
				break;
			case "student":
				hotel.addReservation(roomNo, new Student(guestName));
				break;
			default:
				System.out.println("Wrong type of guest chosen.");
			}
		}
	}

	public int viewReservation() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter room number:");
		String option = "";
		option = keyboard.nextLine();
		int roomNo = -1;
		try {
			roomNo = Integer.parseInt(option);
			System.out.println("Room #" + option + " is reserved to " + hotel.getCustomer(roomNo));
		} catch (Exception e) {
			System.out.println("Room number does not exists.");
		}
		
		return roomNo;
	}

	public void cancelReservation() {
		Scanner keyboard = new Scanner(System.in);
		int option = viewReservation();
		System.out.println("Please enter room number again to confirm cancellation. Type (C) to Cancel.");
		String confirm = "";
		confirm = keyboard.nextLine();
		if (!confirm.toUpperCase().equals("C")) {
			try {
				if (option == Integer.parseInt(confirm)) {
					hotel.getRoomByID(option).emptyRoom();
				} else {
					System.out.println("Room and confirmation values don't match. Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Room and confirmation values don't match. Please try again.");
			}
		} else {
			System.out.println("Operation cancelled.");
		}
		
	}

	public void processPayment() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the room you want to check out: ");
		String option = "";
		option = keyboard.nextLine();

		try {
			int roomNo = Integer.parseInt(option);
			System.out.println("Customer: " + hotel.getCustomer(roomNo));
			System.out.println("Outstanding payment: " + hotel.getPayment(roomNo) + "€");
			System.out.println("Process? (Y/N)");
			option = keyboard.nextLine();
			if (option.equalsIgnoreCase("y")) {
				hotel.emptyRoom(roomNo);
			} else {
				System.out.println("Option cancelled.");
			}
		} catch (Exception e) {
			System.out.println("Room does not exist.");
		}
		
	}

	public void exit() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Do you want to save? (Y/N)");
		String option = "";
		while (option.equalsIgnoreCase("")) {
			option = keyboard.nextLine();
			switch (option.toUpperCase()) {
			case "Y":
				FileService fs = new FileService();
				if (fs.SaveFile("hotel.dat", this.hotel)) {
					System.out.println("Database saved successfully. Have a nice day!");
				} else {
					System.out.println("There was an issue saving the file. Exit cancelled.");
				}
				break;
			case "N":
				System.out.println("Logging you out...");
				break;
			default:
				System.out.println("Wrong option selected. Please enter Y or N.");
				option = "";
			}
		}
		
	}
}