public class PartTimeEmployee extends EmployeeInfo {

	// ATTRIBUTES
	private double hourlyWage;
	private double hoursPerWeek;
	private double weeksPerYear;

	// CONSTRUCTORS
	public PartTimeEmployee(int eN, String fN, String lN, String s, String wL, double dR, double hW, double hPW,
			double wPY) {
		super(eN, fN, lN, s, wL, dR);
		hourlyWage = hW;
		hoursPerWeek = hPW;
		weeksPerYear = wPY;
	}

	// METHODS
	public double calcAnnualGrossIncome() {
		return (hourlyWage * hoursPerWeek * weeksPerYear);
	}

	public double calcAnnualNetIncome() {
		return (hourlyWage * hoursPerWeek * weeksPerYear * (1 - getDeductRate()));
	}

	// GETTERS
	public double getHourlyWage() {
		return (hourlyWage);
	}

	public double getHoursPerWeek() {
		return (hoursPerWeek);
	}

	public double getWeeksPerYear() {
		return (weeksPerYear);
	}

}