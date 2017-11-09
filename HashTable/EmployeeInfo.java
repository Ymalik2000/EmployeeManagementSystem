public class EmployeeInfo {

	// ATTRIBUTES
	private int empNum;
	private String firstName;
	private String lastName;
	private int sex;
	private int workLoc;
	private double deductRate;

	// CONSTRUCTORS
	public EmployeeInfo(int eN, String fN, String lN, int s, int wL, double dR) {
		empNum = eN;
		firstName = fN;
		lastName = lN;
		sex = s;
		workLoc = wL;
		deductRate = dR;
	}

	// GETTERS
	public int getEmpNum() {
		return (empNum);
	}

	public String getFirstName() {
		return (firstName);
	}

	public String getLastName() {
		return (lastName);
	}

	public int getSex() {
		return (sex);
	}

	public int getWorkLoc() {
		return (workLoc);
	}

	public double getDeductRate() {
		return (deductRate);
	}

}