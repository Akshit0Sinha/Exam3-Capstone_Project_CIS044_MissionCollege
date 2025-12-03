/**
 * Represents the entire decision tree Contains reference to root node
 */
public class DecisionTree {

	private DecisionNode root;

	// Constructs a DecisionTree with a specified root node.

	public DecisionTree(DecisionNode root) {
		this.root = root;
	}

	/**
	 * Evaluates the decision tree for the given applicant data. parameter data the
	 * applicant data return the final decision result from a leaf node throws
	 * IllegalStateException if the tree has no root
	 */

	public String evaluate(ApplicantData data) {
		if (root == null) {
			throw new IllegalStateException("Decision tree contains no root.");
		}
		return root.evaluate(data);
	}
}