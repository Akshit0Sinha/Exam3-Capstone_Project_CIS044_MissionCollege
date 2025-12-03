/**
 * leaf node in the decision tree
 */
public class LeafNode extends DecisionNode {

	private String result;

	/**
	 * Constructs a leaf node with the given result
	 */
	public LeafNode(String result) {
		super(null);
		this.result = result;
	}

	/**
	 * Returns the result stored in  leaf node.
	 * @param data applicant data (unused in leaf)
	 * @return the decision result
	 */
	@Override
	public String evaluate(ApplicantData data) {
		return result;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}
}
