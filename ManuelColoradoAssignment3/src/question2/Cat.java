package question2;

public class Cat {
	String name;
	int age;
	Person owner;
	
	//part b
	public Cat (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//part c
	public void addOwner (Person owner) {
		this.owner = owner;
	}

}
