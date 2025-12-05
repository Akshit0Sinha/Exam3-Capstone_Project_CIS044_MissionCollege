public class Main {

	public static void main(String[] args) {

		// --- Phase 3 Logic Added Below ---
		// Build a sample decision tree using Phase 2 structure
		Condition incomeCheck = new IncomeCondition(50000);
		Condition creditCheck = new CreditScoreCondition(650);

		DecisionNode root = new DecisionNode(incomeCheck);
		DecisionNode creditNode = new DecisionNode(creditCheck);

		LeafNode approved = new LeafNode("APPROVED");
		LeafNode denied = new LeafNode("DENIED");

		// Connect the nodes (true -> passed condition, false -> failed)
		root.setTrueChild(creditNode);
		root.setFalseChild(denied);

		creditNode.setTrueChild(approved);
		creditNode.setFalseChild(denied);

		DecisionTree tree = new DecisionTree(root);

		// Example applicant
		ApplicantData applicant = new ApplicantData(60000, 700, true);

		// Evaluate the decision tree
		String result = tree.evaluate(applicant);
		System.out.println("Loan Decision: " + result);
	}
}
