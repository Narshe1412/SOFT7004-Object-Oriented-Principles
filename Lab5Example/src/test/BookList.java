package test;

public class BookList extends ObjectList{

	public BookList(int max) {
		super(max);		
	}

	public Book searchBookListByISBN(String ISBN) {
		Book b = null;
		
		for(Object o:getList()) {
			Book searchBook = (Book)o;
			if(searchBook.getISBN().toUpperCase().equals(ISBN.toUpperCase())) {
				b = searchBook;
			}
		}
		
		return b;
	}
	
	public int searchBookListPostiionByISBN(String ISBN) {
		int pos = -1;
		int i = 0;
		for(Object o:getList()) {
			Book searchBook = (Book)o;
			if(searchBook.getISBN().toUpperCase().equals(ISBN.toUpperCase())) {
				pos = i;
				break;
			}
			i++;
		}		
		return pos;
	}
	
	public double getYearlyBookPayment() {
		double payment = 0;
		for(Object o:getList()) {
			Book searchBook = (Book)o;
			payment += searchBook.getPrice();
		}		
		return payment;
	}
}
