import java.util.*;

public class MyHashTable {

	// ATTRIBUTES
	// Buckets is an array of ArrayList.
	// Each item in an ArrayList is an EmployeeInfo object.
	private ArrayList<EmployeeInfo>[] buckets;

	// CONSTRUCTORS
	public MyHashTable(int howManyBuckets) {
		// Construct the hash table (open hashing/closed addressing) as an array of
		// howManyBuckets ArrayLists.
		// Instantiate an array to have an ArrayList as each element of the array.
		buckets = new ArrayList[howManyBuckets];
		// For each element in the array, instantiate its ArrayList.
		for (int i = 0; i < howManyBuckets; i++) {
			// Instantiate the ArrayList for bucket i.
			buckets[i] = new ArrayList();
		}
	}

	// METHODS
	public int calcBucket(int keyValue) {
		// Returns the bucket number as the integer keyValue modulo the number of
		// buckets for the hash table.
		return (keyValue % buckets.length);
	}

	public boolean addEmployee(EmployeeInfo theEmployee) {
		// Add the employee to the hash table.
		// Return true if employee is added successfully, return false otherwise.
		if (buckets[theEmployee.getEmpNum() % buckets.length].add(theEmployee)) {
			return (true);
		} else {
			return (false);
		}
	}

	public int searchByEmployeeNumber(int employeeNum) {
		// Determine the position of the employee in the ArrayList for the bucket that
		// employee hashes to.
		// If the employee is not found, return -1.
		int size = buckets[employeeNum % buckets.length].size();
		EmployeeInfo theEmployee;
		for (int i = 0; i < size; i++) {
			theEmployee = (EmployeeInfo) buckets[employeeNum % buckets.length].get(i);
			if (theEmployee.getEmpNum() == employeeNum) {
				return (i);
			}
		}
		return -1;
	}
	
	public void displayEmployee(int employeeNum) {
		
		// THIS LINE DOES NOT WORK, TO BE FIXED!!!
		EmployeeInfo theEmployee = (EmployeeInfo) buckets[calcBucket(employeeNum)].get(searchByEmployeeNumber(employeeNum));
		
		System.out.println("Employee number: " + theEmployee.getEmpNum());
		System.out.println("First name: " + theEmployee.getFirstName());
		System.out.println("Last name: " + theEmployee.getLastName());
		System.out.println("Sex: " + theEmployee.getSex());
		System.out.println("Work location: " + theEmployee.getWorkLoc());
		System.out.println("Deduct rate: " + theEmployee.getDeductRate());
		if (theEmployee instanceof FullTimeEmployee) {
			System.out.println("Annual gross income: " + ((FullTimeEmployee) theEmployee).calcAnnualGrossIncome());
			System.out.println("Annual net income: " + ((FullTimeEmployee) theEmployee).calcAnnualNetIncome());
			System.out.println("Yearly salary: " + ((FullTimeEmployee) theEmployee).getYearlySalary());
		}
		else if (theEmployee instanceof PartTimeEmployee) {
			System.out.println("Annual gross income: " + ((PartTimeEmployee) theEmployee).calcAnnualGrossIncome());
			System.out.println("Annual net income: " + ((PartTimeEmployee) theEmployee).calcAnnualNetIncome());
			System.out.println("Hourly wage: " + ((PartTimeEmployee) theEmployee).getHourlyWage());
			System.out.println("Hours per week: " + ((PartTimeEmployee) theEmployee).getHoursPerWeek());
			System.out.println("Weeks per year: " + ((PartTimeEmployee) theEmployee).getWeeksPerYear());
		}
	}

	public EmployeeInfo removeEmployee(int employeeNum) {
		// Remove the employee from the hash table and return the reference to that
		// employee.
		// If the employee is not in the hash table, return null.
		int i = searchByEmployeeNumber(employeeNum);
		if (i != -1) {
			return ((EmployeeInfo) buckets[employeeNum % buckets.length].remove(i));
		}
		return null;
	}

	public void displayContents() {
		// Print the employee numbers for the employees stored in each bucket's
		// ArrayList.
		// Start with bucket 0, then bucket 1, and so on.
		for (int i = 0; i < buckets.length; i++) {
			// For the current bucket, print out the empNum for each item in its ArrayList.
			System.out.println("Examining the ArrayList for bucket " + i);
			int listSize = buckets[i].size();
			if (listSize == 0) {
				System.out.println("Nothing in its ArrayList");
			} else {
				for (int j = 0; j < listSize; j++) {
					int theEmpNum = buckets[i].get(j).getEmpNum();
					System.out.println("Employee " + theEmpNum);
				}
			}
		}
	}

}