public class TestHashTable {
	public static void main(String[] args) {

		MyHashTable theHashTable = new MyHashTable(2);
		EmployeeInfo theEmployee = new FullTimeEmployee(123456, "Bugs", "Bunny", "Male", "Mississauga", 0.2, 75000);
		theHashTable.addEmployee(theEmployee);
		theEmployee = new PartTimeEmployee(234567, "Daffy", "Duck", "Male", "Mississauga", 0.15, 20, 30, 40);
		theHashTable.addEmployee(theEmployee);
		theHashTable.displayContents();

	}
}