public class TestHashTable {
	public static void main(String[] args) {

		MyHashTable theHashTable = new MyHashTable(2);

		EmployeeInfo someEmployee;

		someEmployee = new EmployeeInfo(123456, "Bugs", "Bunny", 1, 1, 0.2);
		theHashTable.addEmployee(someEmployee);

		someEmployee = new EmployeeInfo(234567, "Daffy", "Duck", 1, 2, 0.25);
		theHashTable.addEmployee(someEmployee);

		someEmployee = new EmployeeInfo(345678, "Elmer", "Fudd", 1, 3, 0.3);
		theHashTable.addEmployee(someEmployee);

		int x;

		// calcBucket
		x = theHashTable.calcBucket(123456);
		System.out.println(x);

		x = theHashTable.calcBucket(234567);
		System.out.println(x);

		x = theHashTable.calcBucket(345678);
		System.out.println(x);

		// searchByEmployeeNumber
		x = theHashTable.searchByEmployeeNumber(123456);
		System.out.println(x);

		x = theHashTable.searchByEmployeeNumber(234567);
		System.out.println(x);

		x = theHashTable.searchByEmployeeNumber(345678);
		System.out.println(x);

		theHashTable.displayContents();

		// removeEmployee
		EmployeeInfo employeeRemoved;

		employeeRemoved = theHashTable.removeEmployee(123456);
		System.out.println(employeeRemoved.getEmpNum());

		employeeRemoved = theHashTable.removeEmployee(234567);
		System.out.println(employeeRemoved.getEmpNum());

		employeeRemoved = theHashTable.removeEmployee(345678);
		System.out.println(employeeRemoved.getEmpNum());

		theHashTable.displayContents();

	}
}