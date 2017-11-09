public class PartTimeEmployee extends EmployeeInfo {

	public PartTimeEmployee(int eN, String fN, String lN, int s, int wL, double dR) {
		super(eN, fN, lN, s, wL, dR);
	}

	private double hourlyWage;
	private double hoursPerWeek;
	private double weeksPerYear;
	
	public double calcAnnualGrossIncome() {
		return (hourlyWage*hoursPerWeek*weeksPerYear);
	}
	
	public double calcAnnualNetIncome() {
		return (hourlyWage*hoursPerWeek*weeksPerYear*(1-getDeductRate()));
	}

}