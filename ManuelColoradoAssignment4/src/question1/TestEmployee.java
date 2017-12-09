package question1;

public class TestEmployee {

	public static void main(String[] args) {
		Employee[] empList = new Employee[4];
		
		empList[0] = new FullTimeEmployee("Johnny");
		// We use casting here as empList is an array of Employee so it doesn't
		// "understand" that thanks to polymorphism it has available a method from the
		// children class
		((FullTimeEmployee) empList[0]).setAnnualSalary(30000);
		
		empList[1] = new PartTimeEmployee("Peter");
		((PartTimeEmployee) empList[1]).setHourlyPay(12);
		
		empList[2] = new FullTimeEmployee("Mary");
		((FullTimeEmployee) empList[2]).setAnnualSalary(50000);
		
		empList[3] = new PartTimeEmployee("Jessica");
		((PartTimeEmployee) empList[3]).setHourlyPay(14);
		
		// Iterate over the array printing each employee
		for (Employee emp : empList) {
			emp.print(); 
		}
	}

}
