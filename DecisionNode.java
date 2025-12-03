/**
 * Represents an internal node in the decision tree. Each node contains a
 * condition and two branches: trueBranch: the branch to follow if the condition
 * passes falseBranch: the branch to follow if the condition fails
 */
public class DecisionNode {

	private Condition condition; // eval. point
	private DecisionNode trueBranch; // if true
	private DecisionNode falseBranch; // if false

	// Constructs a DecisionNode with a given condition.
	// parameters condition the condition associated with this node
	public DecisionNode(Condition condition) {
		this.condition = condition;
	}

	/**
	 * Evaluates this node by testing condition and recursively evaluating the
	 * corresponding branch. param data the applicant data for decision-making
	 * return decision result from the leaf
	 */
	public String evaluate(ApplicantData data) {
		if (condition.test(data)) {
			return trueBranch.evaluate(data);
		} else {
			return falseBranch.evaluate(data);
		}
	}

	/**
	 * Returns false for internal nodes.
	 * return false, since this is not a leaf node
	 */
	public boolean isLeaf() {
		return false;
	}

	public void setFalseBranch(DecisionNode falseBranch) {
		this.falseBranch = falseBranch;
	}

	//Setters for child branches
	public void setTrueBranch(DecisionNode trueBranch) {
		this.trueBranch = trueBranch;
	}
}
