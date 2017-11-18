public class TestHashTable {
	public static void main(String[] args) {

		MyHashTable theHashTable = new MyHashTable(2);
		FullTimeEmployee theEmployee = new FullTimeEmployee(123456, "Bugs", "Bunny", "Male", "Mississauga", 0.2, 75000);
		theHashTable.addEmployee(theEmployee);
		PartTimeEmployee anotherEmployee = new PartTimeEmployee(234567, "Daffy", "Duck", "Male", "Mississauga", 0.15,
				20, 30, 40);
		theHashTable.addEmployee(anotherEmployee);
		theHashTable.editEmployee("Part Time", 123456, "George", "Yu", "Male", "Waterloo", 0.3, 15, 30, 40, 50);
		theHashTable.editEmployee("Full Time", 234567, "Yash", "Malik", "Male", "Waterloo", 0.35, 20, 40, 45, 50);
		theHashTable.displayContents();

	}
}