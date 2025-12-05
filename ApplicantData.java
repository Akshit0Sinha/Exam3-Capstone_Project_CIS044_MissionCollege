/**
 * Model class to hold attributes of loan applicant. Attributes are used by
 * decision nodes to evaluate conditions.
 */
public class ApplicantData {
	private double income;
	private int creditScore;
	private boolean stableEmployment;

	public ApplicantData(double income, int creditScore, boolean stableEmployment) {
		this.income = income;
		this.creditScore = creditScore;
		this.stableEmployment = stableEmployment;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public double getIncome() {
		return income;
	}

	public boolean hasStableEmployment() {
		return stableEmployment;
	}
}
