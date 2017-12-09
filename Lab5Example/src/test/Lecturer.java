package test;

import java.io.Serializable;

public class Lecturer implements Serializable{

	private BookList books;
	private final int MAX_BOOKS = 15;
	private String name;
	private int ID;
	static int LECT_ID = 1;
	public Lecturer(String name) {
		this.name = name;
		books = new BookList(MAX_BOOKS);
		ID = LECT_ID;
		LECT_ID++;
	}
	
	public void addBook(Book s) {
		this.books.add(s);
	}
	
	public BookList getBooks() {
		return this.books;
	}
	
	public String getName() {return this.name;}
	public int getID() {return this.ID;}
}
