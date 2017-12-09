package question1.model;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ObjectList implements Serializable {
	private ArrayList<Object> oList;
	private int total;
	
	public ObjectList(int total) {
		this.total = total;
		this.oList = new ArrayList<Object>();
	}
	
	public boolean add(Object obj) {
		if (oList.size() >= total) { // Returns false if it cannot be added to the list
			return false;
		} else {
			oList.add(obj);
			return true;
		}
	}
	
	public boolean remove(int index) {
		if(isEmpty() || index >= getTotal()) { // returns false if it cannot be removed due to list being empty
											   // or index provided above the total of entries
			return false;
		} else {
			oList.remove(index);
			return true;
		}
	}
	
	public boolean isFull() {
		return (getTotal() == total);
	}
	
	public boolean isEmpty() {
		return (getTotal() == 0);
	}
	
	public Object getObject(int index) {
		if (isEmpty() || index >= getTotal()) {
			return null;
		} else {
			return oList.get(index);
		}
	}
	
	public int getTotal() {
		return oList.size();
	}
	
	public ArrayList<Object> getList() {
		return oList;
	}
}
