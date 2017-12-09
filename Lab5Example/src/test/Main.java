package test;

public class Main {
	public static void main(String[] args) {
		FileStorage myFile = new FileStorage();
		LectureList myLecturers = (LectureList) 
								myFile.readObject("lecturer.ser");
		if (myLecturers == null) {
			System.out.println("Lecture List not read from file");
			// TODO Auto-generated method stub
			Book b1 = new Book("book1", 12.09, "123456", "DMC");
			Book b2 = new Book("book2", 21.09, "5745457", "DMC");
			Book b3 = new Book("book3", 12.89, "8070780870", "DMC");
			Book b4 = new Book("book4", 15.99, "12347344252556", "DMC");
			Lecturer lect = new Lecturer("Diarmuid");
			lect.addBook(b1);
			lect.addBook(b2);
			lect.addBook(b3);
			lect.addBook(b4);
			myLecturers = new LectureList(100);
			myLecturers.add(lect);
			System.out.println(myLecturers.getAllDetails());
			myFile.storeObject(myLecturers, "lecturer.ser");
		}
		else {
			System.out.println("Lecture List read from file");
			System.out.println(myLecturers.getAllDetails());
		}

	}
}
