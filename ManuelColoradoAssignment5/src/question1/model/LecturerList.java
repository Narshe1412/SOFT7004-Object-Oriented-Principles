package question1.model;

@SuppressWarnings("serial")
public class LecturerList extends ObjectList {
	private int activeLecturer;
	
	public LecturerList(int max) {
		super(max);
		setActiveLecturer("");
	}

	public Lecturer getActiveLecturer() {
		// If there's active lecturer (position >= 0) get the object for manipulation
		if (activeLecturer <0 ) return null;
		return (Lecturer) getObject(activeLecturer);
	}

	public void setActiveLecturer(String name) {
		this.activeLecturer = search(name);
	}
	
	public int search(String name) {
		// Transverse the list of lecturers and find the position where this customer 
		int position = 0;
		for(Object obj:getList()) {
			Lecturer current = (Lecturer)obj;
			if(current.getName().toUpperCase().equals(name.toUpperCase())) {
				return position;
			}
			position++;
		}
		return -1; // Return -1 if not found
	}
}
