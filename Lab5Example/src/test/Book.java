package test;

import java.io.Serializable;

public class Book implements Serializable {
	String isbn;
	double price;
	String name,author;
	
	public Book(String name, double price, String isbn, String author) {
		this.name=name;
		this.price=price;
		this.isbn=isbn;
		this.author = author;
	}
	
	public String getName() {return this.name;}
	public String getAuthor() {return this.author;}
	public String getISBN() {return this.isbn;}
	public double getPrice() {return this.price;}
}
