package Main;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

	public void addEmployee(EmployeeInfo theEmployee) {
		// Add the employee to the hash table.
		buckets[calcBucket(theEmployee.getEmpNum())].add(theEmployee);
		writeToFile();
	}

	public int searchByEmployeeNumber(int employeeNum) {
		// Determine the position of the employee in the ArrayList for the bucket that
		// employee hashes to.
		// If the employee is not found, return -1.
		int size = buckets[calcBucket(employeeNum)].size();
		EmployeeInfo theEmployee;
		for (int i = 0; i < size; i++) {
			theEmployee = (EmployeeInfo) buckets[calcBucket(employeeNum)].get(i);
			if (theEmployee.getEmpNum() == employeeNum) {
				return (i);
			}
		}
		return -1;
	}

	public void displayEmployee(int employeeNum) {
		EmployeeInfo theEmployee = (EmployeeInfo) buckets[calcBucket(employeeNum)]
				.get(searchByEmployeeNumber(employeeNum));
		if (theEmployee instanceof FullTimeEmployee) {
			System.out.println("Employee type: Full Time");
		} else if (theEmployee instanceof PartTimeEmployee) {
			System.out.println("Employee type: Part Time");
		}
		System.out.println("Employee number: " + theEmployee.getEmpNum());
		System.out.println("First name: " + theEmployee.getFirstName());
		System.out.println("Last name: " + theEmployee.getLastName());
		System.out.println("Sex: " + theEmployee.getSex());
		System.out.println("Work location: " + theEmployee.getWorkLoc());
		System.out.println("Deduct rate: " + theEmployee.getDeductRate());
		if (theEmployee instanceof FullTimeEmployee) {
			System.out.println("Yearly salary: " + ((FullTimeEmployee) theEmployee).getYearlySalary());
			System.out.println("Annual gross income: " + ((FullTimeEmployee) theEmployee).calcAnnualGrossIncome());
			System.out.println("Annual net income: " + ((FullTimeEmployee) theEmployee).calcAnnualNetIncome());
		} else if (theEmployee instanceof PartTimeEmployee) {
			System.out.println("Hourly wage: " + ((PartTimeEmployee) theEmployee).getHourlyWage());
			System.out.println("Hours per week: " + ((PartTimeEmployee) theEmployee).getHoursPerWeek());
			System.out.println("Weeks per year: " + ((PartTimeEmployee) theEmployee).getWeeksPerYear());
			System.out.println("Annual gross income: " + ((PartTimeEmployee) theEmployee).calcAnnualGrossIncome());
			System.out.println("Annual net income: " + ((PartTimeEmployee) theEmployee).calcAnnualNetIncome());
		}
		System.out.println();
	}

	public void editEmployee(String empType, int employeeNum, String firstName, String lastName, String sex,
			String workLoc, double deductRate, double yearlySalary, double hourlyWage, double hoursPerWeek,
			double weeksPerYear) {

		EmployeeInfo theEmployee = (EmployeeInfo) buckets[calcBucket(employeeNum)]
				.get(searchByEmployeeNumber(employeeNum));

		if (theEmployee instanceof FullTimeEmployee) {
			// Editing a full time employee
			if (empType == "Full Time") {
				// Use setter methods to set new information
				theEmployee.setFirstName(firstName);
				theEmployee.setLastName(lastName);
				theEmployee.setSex(sex);
				theEmployee.setWorkLoc(workLoc);
				theEmployee.setDeductRate(deductRate);
				((FullTimeEmployee) theEmployee).setYearlySalary(yearlySalary);
				writeToFile();
			} else if (empType == "Part Time") {
				// Instantiate a new part time employee, and transfer the information.
				removeEmployee(employeeNum);
				theEmployee = new PartTimeEmployee(employeeNum, firstName, lastName, sex, workLoc, deductRate,
						hourlyWage, hoursPerWeek, weeksPerYear);
				addEmployee(theEmployee);
				writeToFile();
			}
		} else if (theEmployee instanceof PartTimeEmployee) {
			// Editing a part time employee
			if (empType == "Full Time") {
				// Instantiate a new full time employee, and transfer the information.
				removeEmployee(employeeNum);
				theEmployee = new FullTimeEmployee(employeeNum, firstName, lastName, sex, workLoc, deductRate,
						yearlySalary);
				addEmployee(theEmployee);
				writeToFile();
			} else if (empType == "Part Time") {
				// Use setter methods to set new information
				theEmployee.setFirstName(firstName);
				theEmployee.setLastName(lastName);
				theEmployee.setSex(sex);
				theEmployee.setWorkLoc(workLoc);
				theEmployee.setDeductRate(deductRate);
				((PartTimeEmployee) theEmployee).setHourlyWage(hourlyWage);
				((PartTimeEmployee) theEmployee).setHoursPerWeek(hoursPerWeek);
				((PartTimeEmployee) theEmployee).setWeeksPerYear(weeksPerYear);
				writeToFile();
			}
		}
	}

	public void removeEmployee(int employeeNum) {
		// Remove the employee from the hash table
		int i = searchByEmployeeNumber(employeeNum);
		if (i != -1) {
			buckets[calcBucket(employeeNum)].remove(i);
			writeToFile();
		}
	}

	public void displayContents() {
		// Print the employee numbers for the employees stored in each bucket's
		// ArrayList.
		// Start with bucket 0, then bucket 1, and so on.
		for (int i = 0; i < buckets.length; i++) {
			// For the current bucket, print out the empNum for each item in its ArrayList.
			int listSize = buckets[i].size();
			if (listSize != 0) {
				for (int j = 0; j < listSize; j++) {
					EmployeeInfo theEmployee = buckets[i].get(j);
					displayEmployee(theEmployee.getEmpNum());
				}
			}
		}
	}

	public void writeToFile() {
		// This method is called every time the hash table is modified.
		// Replaces all old contents with new contents.
		try {
			FileWriter writer = new FileWriter("textFile");
			for (int i = 0; i < buckets.length; i++) {
				// For the current bucket, print out the empNum for each item in its ArrayList.
				int listSize = buckets[i].size();
				if (listSize != 0) {
					for (int j = 0; j < listSize; j++) {
						EmployeeInfo theEmployee = buckets[i].get(j);
						if (theEmployee instanceof FullTimeEmployee) {
							writer.write("Full Time");
							writer.write(System.getProperty("line.separator"));
						} else if (theEmployee instanceof PartTimeEmployee) {
							writer.write("Part Time");
							writer.write(System.getProperty("line.separator"));
						}
						writer.write("" + theEmployee.getEmpNum());
						writer.write(System.getProperty("line.separator"));
						writer.write(theEmployee.getFirstName());
						writer.write(System.getProperty("line.separator"));
						writer.write(theEmployee.getLastName());
						writer.write(System.getProperty("line.separator"));
						writer.write(theEmployee.getSex());
						writer.write(System.getProperty("line.separator"));
						writer.write(theEmployee.getWorkLoc());
						writer.write(System.getProperty("line.separator"));
						writer.write("" + theEmployee.getDeductRate());
						writer.write(System.getProperty("line.separator"));
						if (theEmployee instanceof FullTimeEmployee) {
							writer.write("" + ((FullTimeEmployee) theEmployee).getYearlySalary());
							writer.write(System.getProperty("line.separator"));
						} else if (theEmployee instanceof PartTimeEmployee) {
							writer.write("" + ((PartTimeEmployee) theEmployee).getHourlyWage());
							writer.write(System.getProperty("line.separator"));
							writer.write("" + ((PartTimeEmployee) theEmployee).getHoursPerWeek());
							writer.write(System.getProperty("line.separator"));
							writer.write("" + ((PartTimeEmployee) theEmployee).getWeeksPerYear());
							writer.write(System.getProperty("line.separator"));
						}
						writer.write(System.getProperty("line.separator"));
					}
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() {
		// Call this at the beginning of the test program after the hash table is
		// instantiated.
		// Read from text file and add all contents to the hash table.
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("textFile"));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.equals("Full Time")) {
					line = reader.readLine();
					int empNum = Integer.parseInt(line);
					line = reader.readLine();
					String firstName = line;
					line = reader.readLine();
					String lastName = line;
					line = reader.readLine();
					String sex = line;
					line = reader.readLine();
					String workLoc = line;
					line = reader.readLine();
					Double deductRate = Double.parseDouble(line);
					line = reader.readLine();
					Double yearlySalary = Double.parseDouble(line);
					line = reader.readLine();
					EmployeeInfo theEmployee = new FullTimeEmployee(empNum, firstName, lastName, sex, workLoc,
							deductRate, yearlySalary);
					addEmployee(theEmployee);
				} else if (line.equals("Part Time")) {
					line = reader.readLine();
					int empNum = Integer.parseInt(line);
					line = reader.readLine();
					String firstName = line;
					line = reader.readLine();
					String lastName = line;
					line = reader.readLine();
					String sex = line;
					line = reader.readLine();
					String workLoc = line;
					line = reader.readLine();
					Double deductRate = Double.parseDouble(line);
					line = reader.readLine();
					Double hourlyWage = Double.parseDouble(line);
					line = reader.readLine();
					Double hoursPerWeek = Double.parseDouble(line);
					line = reader.readLine();
					Double weeksPerYear = Double.parseDouble(line);
					line = reader.readLine();
					EmployeeInfo theEmployee = new PartTimeEmployee(empNum, firstName, lastName, sex, workLoc,
							deductRate, hourlyWage, hoursPerWeek, weeksPerYear);
					addEmployee(theEmployee);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}