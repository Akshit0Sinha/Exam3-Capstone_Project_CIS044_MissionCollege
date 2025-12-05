/**
 * Implements conditions that checks applicant income > minimum
 */
public class IncomeCondition implements Condition {

	private double minimumIncome;

	public IncomeCondition(double minimumIncome) {
		this.minimumIncome = minimumIncome;
	}

	@Override
	public boolean evaluate(ApplicantData data) {
		return data.getIncome() >= minimumIncome;
	}
}
