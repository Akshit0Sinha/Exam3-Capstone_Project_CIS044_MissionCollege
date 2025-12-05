/**
 * Checks whether the applicant has stable employment.
 */
public class EmploymentCondition implements Condition {

	@Override
	public boolean evaluate(ApplicantData data) {
		return data.hasStableEmployment();
	}
}
