package question3;
//part b

import java.util.ArrayList;

public class BookList {
	private ArrayList<Book> booklist;
	
	public BookList() {
		this.booklist = new ArrayList<>();
	}

	public int size() {
		return booklist.size();
	}

	public void add(Book book) {
		booklist.add(book);
	}
	
	public String toString() {
		String result = "";
		for (Book book: booklist) {
			result += book.getTitle() + "\n";
		}
		return result;
	}

}
