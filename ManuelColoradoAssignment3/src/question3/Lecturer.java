package question3;
//part b

public class Lecturer {
	private String name;
	private int ID;
	private BookList books;
	private final int MAXNOOFBOOKS = 15;
	
	public Lecturer(String name, int id) {
		this.name = name;
		this.ID = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
	
	public void addBook(Book book) {
		if (books.size() >= MAXNOOFBOOKS) {
			System.out.println("Error. Not enough space for more books");
		} else {
			books.add(book);
		}
	}
	
	public BookList getBookList() {
		return books;
	}
	
	public String toString() {
		return "ID: " + ID + " - " + name + "\nList of Books:\n" + books.toString();
	}
	
	public void print() {
		System.out.println(toString());
	}
}
