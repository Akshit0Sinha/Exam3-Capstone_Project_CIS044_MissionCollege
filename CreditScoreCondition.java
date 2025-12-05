/**
 * Checks whether the applicant meets a minimum credit score.
 */
public class CreditScoreCondition implements Condition {

	private int minimumCreditScore;

	public CreditScoreCondition(int minimumCreditScore) {
		this.minimumCreditScore = minimumCreditScore;
	}

	@Override
	public boolean evaluate(ApplicantData data) {
		return data.getCreditScore() >= minimumCreditScore;
	}
}
