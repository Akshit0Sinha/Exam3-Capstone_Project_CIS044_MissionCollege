/**
 * Interface for defining a decision condition Each condition implements test
 * method, which returns true if the condition passes, false otherwise.
 */
public interface Condition {
	boolean test(ApplicantData data);
}