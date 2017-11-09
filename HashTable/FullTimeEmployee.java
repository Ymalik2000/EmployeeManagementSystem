public class FullTimeEmployee extends EmployeeInfo {

	public FullTimeEmployee(int eN, String fN, String lN, int s, int wL, double dR) {
		super(eN, fN, lN, s, wL, dR);
	}

	private double yearlySalary;
	
	public double calcAnnualGrossIncome() {
		return (yearlySalary);
	}
	
	public double calcAnnualNetIncome() {
		return (yearlySalary*(1-getDeductRate()));
	}

}