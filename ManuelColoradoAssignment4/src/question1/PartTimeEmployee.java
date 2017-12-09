package question1;

public class PartTimeEmployee extends Employee{
	int hourlyPay;

	public PartTimeEmployee(String name) {
		super(name);
		setHourlyPay(0);
	}

	//Accessors
	public String getStatus() {
		return toString();
	}

	public int getHourlyPay() {
		return hourlyPay;
	}
	public int getWeeklySalary() {
		return getHourlyPay() * 40;
	}
	
	public String toString() {
		return "ID: " + getNumber() + " - " + getName() + " Salary: " + getWeeklySalary() + " €/w.";
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	//Mutators
	public void setHourlyPay(int hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
	
	

}

/*PartTimeEmployee contains an hourlyPay and a method that takes in an int (number of hours) and calculates the 
 * 	weekly pay for the hours worked. */