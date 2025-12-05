/**
 * Represents an internal node in the decision tree. Each node contains a
 * condition and two branches: trueBranch: the branch to follow if the condition
 * passes falseBranch: the branch to follow if the condition fails
 * // Constructs a DecisionNode with a given condition.
	// parameters condition the condition associated with this node
 */
/**
 * Evaluates this node by testing condition and recursively evaluating the
 * corresponding branch. param data the applicant data for decision-making
 * return decision result from the leaf
 */
/**
 * Returns false for internal nodes. return false, since this is not a leaf node
 */
public class DecisionNode implements Node {

	private Condition condition;
	private Node trueBranch; // Branch taken when condition is true
	private Node falseBranch; // Branch taken when condition is false

	public DecisionNode(Condition condition) {
		this.condition = condition;
	}

	// --- Phase 3 Logic Added Below ---
	// Setter methods required to connect tree nodes in Main.java

	@Override
	public String evaluate(ApplicantData data) {
		if (condition.evaluate(data)) {
			return trueBranch.evaluate(data);
		} else {
			return falseBranch.evaluate(data);
		}
	}

	public void setFalseChild(Node child) {
		this.falseBranch = child;
	}

	public void setTrueChild(Node child) {
		this.trueBranch = child;
	}
}
