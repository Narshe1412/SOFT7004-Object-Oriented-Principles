package question1.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Lecturer implements Serializable{
	private String name;
	private int id;
	private BookList books;
	private final int MAXNOOFBOOKS = 15;
	
	public Lecturer(String name, int id) {
		this.name = name;
		this.id = id;
		this.books = new BookList(MAXNOOFBOOKS);
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
	
	public void addBook (Book book) {
		books.add(book);
	}
	
	public BookList getBookList() {
		return books;
	}
	
	public String toString() {
		return "ID: " + id + " Name: " +  name + "\n" + books;
	}
	
	public void print() {
		System.out.println(toString());
	}
}