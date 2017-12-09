package question3;
//part a

public class Book {
	private String title;
	private int ISBN;
	private String author;
	private double price;
	
	public Book(String title, int ISBN, String author, double price) {
		setTitle(title);
		setISBN(ISBN);
		setAuthor(author);
		setPrice(price);
	}

	public String getTitle() {
		return title;
	}

	public int getISBN() {
		return ISBN;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
