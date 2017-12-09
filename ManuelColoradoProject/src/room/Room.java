package room;

import java.util.ArrayList;
import java.util.Scanner;

import exception.TestException;
import guest.Guest;

public class Room {
	private static int ROOM_NUM = 1;
	private int roomNumber;
	private int maxGuests;
	private double price;
	private ArrayList<Guest> guests; // if it's null, it's not occupied
	private Guest reservedBy; // if it's null, it's not reserved

	public Room(double price, int maxGuests) {
		roomNumber = ROOM_NUM;
		ROOM_NUM++;
		guests = null;
		reservedBy = null;
	}

	public ArrayList<Guest> getGuests() {
		return guests;
	}

	public void addGuest(Guest guest) throws TestException {
		if (!isFull()) {
			guests.add(guest);
		} else {
			throw new TestException("Maximum number of guests reached.");
		}
	}

	public void removeGuest(Guest guest) throws TestException {
		if (isOccupied()) {
			if (guests.contains(guest)) {
				guests.remove(guest);
			} else {
				throw new TestException("Guest is not staying on this room.");
			}
		} else {
			throw new TestException("This room has no guests.");
		}
	}

	public void addReservation(Guest guest) throws TestException {
		if (reservedBy == null) {
			reservedBy = guest;
		} else {
			throw new TestException("This room is already reserved.");
		}
	}

	public void removeReservation() throws TestException {
		if (reservedBy == null) {
			throw new TestException("This room is not reserved.");
		} else {
			reservedBy = null;
		}
	}
	
	public void emptyRoom() {
		this.guests = null;
		this.reservedBy = null;
	}

	public double calculatePrice() {
		double total = 0;
		if (isOccupied()) {
			for (Guest guest : guests) {
				total += price - (price * guest.getDiscount());
			}
		}
		return total;
	}

	public boolean isOccupied() {
		return (guests == null);
	}

	public boolean isFull() {
		return (guests.size() >= maxGuests);
	}

	public int getNumber() {
		return roomNumber;
	}
	
	public String getReservation() {
		return this.reservedBy.getName();
	}

	public String toString() {
		return "Room #" + roomNumber + ":" + "\nPrice: " + price + "€ pp." + "\nReservation made by " + reservedBy;
	}
	
	public static String getTypeOfRoom() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Choose the type of room:");
		System.out.println("Sui(T)e, (D)ouble, (S)ingle");
		String option = "", choice = "";
		while (option.equalsIgnoreCase("")) {
			option = keyboard.nextLine();
			switch (option.toUpperCase()) {
			case "T":
				choice = "suite";
				break;
			case "D":
				choice = "double";
				break;
			case "S":
				choice = "single";
				break;
			default:
				System.out.println("Wrong option selected. Please enter T, D or S");
				option = "";
				break;
			}
		}
		
		return choice;
	}
}