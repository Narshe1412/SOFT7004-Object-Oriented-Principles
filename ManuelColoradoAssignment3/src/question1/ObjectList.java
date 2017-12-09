package question1;

import java.util.ArrayList;

public class ObjectList {
	private ArrayList<Object> collection;
	private int maxSize;

	public ObjectList(int i) {
		this.collection = new ArrayList<Object>();
		this.maxSize = i;
	}

	public String add(Object object) {
		if (collection.size() < maxSize) {
			collection.add(object);
			return object + " added successfully!";
		}
		return "Could not add " + object + " object. List is full!";
	}

	public void remove(int i) {
		if (collection.size() >= i) {
			collection.remove(i);
		}
	}

	public boolean isFull() {
		return (collection.size() == maxSize);
	}

	public boolean isEmpty() {
		return (collection.size() == 0);
	}

	public int getTotal() {
		return collection.size();
	}

	public Object getObject(int i) {
		if (collection.size() > i) {
			return collection.get(i);
		}
		return null;
	}
}
