package test;

import java.io.Serializable;
import java.util.ArrayList;

public class ObjectList implements Serializable  {
	ArrayList<Object> oList;
	private int max_num;

	public ObjectList(int max) {
		oList = new ArrayList<Object>();
		this.max_num = max;
	}

	public String add(Object o) {
		if (oList.size() >= max_num) {
			return "Not Added(" + o.toString() + ")";
		} else {
			this.oList.add(o);

			return "Added(" + o.toString() + ")";
		}
	}

	public String isFull() {
		if (oList.size() == max_num)
			return "YES";

		return "NO";
	}

	public String isEmpty() {
		if (oList.size() == 0)
			return "YES";

		return "NO";
	}

	public int getTotal() {
		return oList.size();
	}
	
	public void remove(int i) {
		if(!isEmpty().equals("YES")) {
			this.oList.remove(i);
			System.out.println("index "+i+" removed");
		}
		else {
			System.out.println("index "+i+" not removed");
		}
	}

	public void remove(Object o) {
		if (!isEmpty().equals("YES")) {
			if (oList.contains(o)) {
				System.out.println(o+" removed");
				this.oList.remove(o);
			}
			else {
				System.out.println(o+" not removed");
			}
		}
	}

	public Object getObject(int i) {
		return this.oList.get(i);
	}

	public ArrayList<Object> getList() {
		return this.oList;
	}
}
