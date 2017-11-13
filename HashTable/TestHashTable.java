public class TestHashTable {
	public static void main(String[] args) {

		MyHashTable theHashTable = new MyHashTable(2);
		FullTimeEmployee theEmployee = new FullTimeEmployee(123456, "Bugs", "Bunny", "Male", "Mississauga", 0.2, 75000);
		theHashTable.addEmployee(theEmployee);
		theHashTable.displayEmployee(123456);
		theHashTable.displayContents();
		theHashTable.removeEmployee(123456);

	}
}