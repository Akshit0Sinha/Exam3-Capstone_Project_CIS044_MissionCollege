/**
 * Common interface for any node in the decision tree. Both DecisionNode
 * (internal node) and LeafNode (terminal node) implement this.
 */
public interface Node {
	/**
	 * Evaluate this node using the provided applicant data. For DecisionNode this
	 * will branch; for LeafNode this will return the final decision.
	 *
	 * @param data applicant data
	 * @return decision string (leaf) or forwarded evaluation result
	 */
	String evaluate(ApplicantData data);
}
