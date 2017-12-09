package room;

import java.io.Serializable;
import java.util.ArrayList;

import exception.TestException;
import guest.Guest;
import guest.Lecturer;
import guest.Student;

@SuppressWarnings("serial")
public class RoomList implements Serializable {
	private ArrayList<Room> rooms;
	private final int MAX_SUITES = 3;
	private final int MAX_DOUBLES = 6;
	private final int MAX_SINGLES = 6;

	public RoomList() {
		rooms = new ArrayList<Room>();

		for (int i = 0; i < MAX_SUITES; i++) {
			rooms.add(new Suite());
		}
		for (int i = 0; i < MAX_DOUBLES; i++) {
			rooms.add(new Double());
		}
		for (int i = 0; i < MAX_SINGLES; i++) {
			rooms.add(new Single());
		}
	}

	public int getFreeRooms(String roomType) {
		int freeRooms = 0;

		for (Room room : rooms) {
			switch (roomType) {
			case "suite":
				if (room instanceof Suite && room.isOccupied()) {
					freeRooms++;
				}
				break;
			case "double":
				if (room instanceof Double && room.isOccupied()) {
					freeRooms++;
				}
				break;
			case "single":
				if (room instanceof Single && room.isOccupied()) {
					freeRooms++;
				}
				break;
			}
		}
		return freeRooms;
	}

	public int nextAvailableRoom(String roomType) {
		int id = -1;

		for (Room room : rooms) {
			switch (roomType) {
			case "suite":
				if (room instanceof Suite && !room.isOccupied()) {
					id = room.getNumber();
				}
				break;
			case "double":
				if (room instanceof Double && !room.isOccupied()) {
					id = room.getNumber();
				}
				break;
			case "single":
				if (room instanceof Single && !room.isOccupied()) {
					id = room.getNumber();
				}
				break;
			}
		}
		return id;
	}

	public String getGuestList(String guestType) {
		String guestList = "";

		for (Room room : rooms) {
			if (!(room.getGuests() == null)) {
				for (Guest guest : room.getGuests()) {
					switch (guestType) {
					case "lecturer":
						if (guest instanceof Lecturer) {
							guestList += "Room #" + room.getNumber() + " - " + guest.getName() + "\n";
						}
						break;
					case "student":
						if (guest instanceof Student) {
							guestList += "Room #" + room.getNumber() + " - " + guest.getName() + "\n";
						}
					}
				}
			}
		}
		if (guestList.equals("")) {
			guestList = "No guests of type " + guestType + " currently staying at the hotel";
		}
		return guestList;
	}

	public Room getRoomByID(int roomNo) {
		for (Room room : rooms) {
			if (room.getNumber() == roomNo) {
				return room;
			}
		}
		return null;
	}

	public double getPayment(int roomNo) {
		return getRoomByID(roomNo).calculatePrice();
	}

	public String getCustomer(int roomNo) {
		return getRoomByID(roomNo).getReservation();
	}

	public void addReservation(int roomNo, Guest guest) {
		try {
			getRoomByID(roomNo).addReservation(guest);
		} catch (TestException e) {
			System.out.println("An error occured while trying to add reservation.");
		}
	}

	public void emptyRoom(int roomNo) {
		getRoomByID(roomNo).emptyRoom();
	}
}
