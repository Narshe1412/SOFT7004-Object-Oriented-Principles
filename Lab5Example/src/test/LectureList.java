package test;

import java.io.Serializable;

public class LectureList extends ObjectList {

	public LectureList(int max) {
		super(max);		
		
	}
	
	public String getAllDetails() {
		String val = "LECTURERS\n=================";
		
		for(Object o:getList()) {
			Lecturer lect = (Lecturer)o;
			val+="\nName:"+lect.getName()+
					"\nID:"+lect.getID()+
					"\n\tBOOKS===========";
			for(Object n:lect.getBooks().getList()) {
				Book b = (Book)n;
				val+="\n\tBookName:"+b.getName()+
						"\n\tBookAuthor:"+b.getAuthor()+
						"\n\tBookPrice:"+b.getPrice()+
						"\n\tBookISBN:"+b.getISBN();
			}
		}
		return val;
	}
}


