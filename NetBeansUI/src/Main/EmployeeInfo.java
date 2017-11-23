package Main;
public class EmployeeInfo {

	// ATTRIBUTES
	private int empNum;
	private String firstName;
	private String lastName;
	private String sex;
	private String workLoc;
	private double deductRate;

	// CONSTRUCTORS
	public EmployeeInfo(int eN, String fN, String lN, String s, String wL, double dR) {
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

	public String getSex() {
		return (sex);
	}

	public String getWorkLoc() {
		return (workLoc);
	}

	public double getDeductRate() {
		return (deductRate);
	}

	// SETTERS
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setWorkLoc(String workLoc) {
		this.workLoc = workLoc;
	}

	public void setDeductRate(double deductRate) {
		this.deductRate = deductRate;
	}

}