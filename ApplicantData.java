/**
 * Model class to hold attributes of loan applicant. Attributes are used by
 * decision nodes to evaluate conditions.
 */
public class ApplicantData {

	private double income;
	private int creditScore;
	private double debtRatio;

	/**
	 * Constructs ApplicantData with given attributes. parameter income applicant
	 * income, applicant credit score & applicant debt ratio
	 */
	public ApplicantData(double income, int creditScore, double debtRatio) {
		this.income = income;
		this.creditScore = creditScore;
		this.debtRatio = debtRatio;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public double getDebtRatio() {
		return debtRatio;
	}

	// Getter methods
	public double getIncome() {
		return income;
	}
}
