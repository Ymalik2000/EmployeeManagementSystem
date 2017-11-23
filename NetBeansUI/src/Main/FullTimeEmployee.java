package Main;

public class FullTimeEmployee extends EmployeeInfo {

	// ATTRIBUTES
	private double yearlySalary;

	// CONSTRUCTORS
	public FullTimeEmployee(int eN, String fN, String lN, String s, String wL, double dR, double yS) {
		super(eN, fN, lN, s, wL, dR);
		yearlySalary = yS;
	}

	// METHODS
	public double calcAnnualGrossIncome() {
		return (yearlySalary);
	}

	public double calcAnnualNetIncome() {
		return (yearlySalary * (1 - getDeductRate()));
	}

	// GETTERS
	public double getYearlySalary() {
		return (yearlySalary);
	}

	// SETTERS
	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

}