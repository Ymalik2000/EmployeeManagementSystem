public class TestHashTable {
	public static void main(String[] args) {

		MyHashTable theHashTable = new MyHashTable(2);
		FullTimeEmployee theFullTimeEmployee = new FullTimeEmployee(123456, "Bugs", "Bunny", "Male", "Mississauga", 0.2,
				75000);
		theHashTable.addEmployee(theFullTimeEmployee);
		PartTimeEmployee thePartTimeEmployee = new PartTimeEmployee(234567, "Daffy", "Duck", "Male", "Mississauga",
				0.15, 20, 30, 40);
		theHashTable.addEmployee(thePartTimeEmployee);
		theHashTable.displayEmployee(123456);
		theHashTable.displayEmployee(234567);
		theHashTable.editEmployee("Part Time", 123456, "George", "Yu", "Male", "Waterloo", 0.3, 15, 30, 40, 50);
		theHashTable.displayEmployee(123456);
		theHashTable.editEmployee("Full Time", 234567, "Yash", "Malik", "Male", "Waterloo", 0.35, 20, 40, 45, 50);
		theHashTable.displayEmployee(234567);
		theHashTable.displayContents();
		theHashTable.removeEmployee(123456);
		theHashTable.removeEmployee(234567);
		theHashTable.displayContents();

	}
}