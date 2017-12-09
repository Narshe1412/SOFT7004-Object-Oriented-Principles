package question1.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Book implements Serializable{
	private int isbn;
	private String title;
	private String author;
	private double price;
	
	public Book(String title, int isbn, String author, double price) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getISBN() {
		return isbn;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return "'" + title + "' by " + author + "\nISBN: " + isbn + "\nPrice: " + price;
	}
}
