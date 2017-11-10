public class TestHashTable {
	public static void main(String[] args) {

		MyHashTable theHashTable = new MyHashTable(2);
		FullTimeEmployee theEmployee = new FullTimeEmployee(123456, "Bugs", "Bunny", 1, 1, 0.2, 75000);
		theHashTable.addEmployee(theEmployee);
		EmployeeInfo employeeRemoved = theHashTable.removeEmployee(123456);

		// Prints out the yearly salary of the full time employee
		if (employeeRemoved instanceof FullTimeEmployee) {
			theEmployee = (FullTimeEmployee) employeeRemoved;
			System.out.println(theEmployee.getYearlySalary());
		}
		
		theHashTable.displayEmployee(123456);

	}
}