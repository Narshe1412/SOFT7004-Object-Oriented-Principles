package question1;

public class FullTimeEmployee extends Employee{
	int annualSalary;

	public FullTimeEmployee(String name) {
		super(name);
		setAnnualSalary(0);
	}

	public String getStatus() {
		return toString();
	}
	
	//Accessors
	public int getAnnualSalary() {
		return annualSalary;
	}

	public int getMonthlySalary() {
		return getAnnualSalary() / 12;
	}
	
	public String toString() {
		return "ID: " + getNumber() + " - " + getName() + " Salary: " + getMonthlySalary() + " €/m.";
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	//Mutators
	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
}

/*
 * Now add two more classes to your diagram called FulltimeEmployee and PartTimeEmployee which inherit from the 
 * Employee class above.  
 * FulltimeEmployee contains an annualSalary and a method to calculate the monthly pay.  
 * PartTimeEmployee contains an hourlyPay and a method that takes in an int (number of hours) and calculates the 
 * 	weekly pay for the hours worked. 
 * Include all sets, gets, toString and print methods. Remember the rules for inheritance.  
 * */