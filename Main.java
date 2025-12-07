/**
 * Phase 4: Testing & Validation This driver prints PASS (loan approved) / FAIL
 * (loan rejected) for Normal, Empty, and Edge Case cases.
 */
public class Main {

	// Build a small decision tree
	private static DecisionTree buildTestTree() {
		// Phase 3 logic: tree structure
		Condition incomeCheck = new IncomeCondition(50000);
		Condition creditCheck = new CreditScoreCondition(650);

		DecisionNode root = new DecisionNode(incomeCheck);
		DecisionNode creditNode = new DecisionNode(creditCheck);

		LeafNode approved = new LeafNode("approved");
		LeafNode denied = new LeafNode("denied");

		root.setTrueChild(creditNode);
		root.setFalseChild(denied);
		creditNode.setTrueChild(approved);
		creditNode.setFalseChild(denied);

		return new DecisionTree(root);
	}

	public static void main(String[] args) {
		System.out.println("=== DECISION TREE TESTS ===");

		testNormalCases();
		testBoundaryCases();
		testEdgeCases();
		testEmptyTree();
		testInvalidInputs();

		System.out.println("=== TESTING COMPLETE ===");
	}

	// Print PASS/FAIL for console output
	private static void printResult(String testName, boolean passed) {
		System.out.println(testName + ": " + (passed ? "pass" : "fail"));
	}

	// Boundary test cases
	private static void testBoundaryCases() {
		System.out.println("\n--- BOUNDARY CASES ---");
		DecisionTree tree = buildTestTree();

		ApplicantData a4 = new ApplicantData(50000, 700, true);
		printResult("Income exactly at threshold", tree.evaluate(a4).equals("approved"));

		ApplicantData a5 = new ApplicantData(70000, 650, true);
		printResult("Credit exactly at threshold", tree.evaluate(a5).equals("approved"));
	}

	// Edge case tests
	private static void testEdgeCases() {
		System.out.println("\n--- EDGE CASES ---");
		DecisionTree tree = buildTestTree();

		ApplicantData a6 = new ApplicantData(40000, 500, true);
		printResult("Income below threshold & credit below threshold", tree.evaluate(a6).equals("denied"));

		ApplicantData a7 = new ApplicantData(50000, 600, true);
		printResult("Income at threshold & credit below threshold", tree.evaluate(a7).equals("denied"));

		ApplicantData a8 = new ApplicantData(80000, 650, true);
		printResult("Income above threshold & credit at threshold", tree.evaluate(a8).equals("approved"));
	}

	// Empty tree test case
	private static void testEmptyTree() {
		System.out.println("\n--- EMPTY TREE CASE ---");
		DecisionTree emptyTree = new DecisionTree(null);
		try {
			emptyTree.evaluate(new ApplicantData(60000, 700, true));
			printResult("Empty tree evaluation", false);
		} catch (IllegalStateException e) {
			printResult("Empty tree evaluation", true);
		}
	}

	// Invalid input test cases
	private static void testInvalidInputs() {
		System.out.println("\n--- INVALID INPUT CASES ---");
		DecisionTree tree = buildTestTree();

		// Null input should throw exception
		try {
			ApplicantData nullData = null;
			tree.evaluate(nullData);
			printResult("Null applicant data", false);
		} catch (IllegalArgumentException | NullPointerException e) {
			printResult("Null applicant data", true);
		}

		// Negative input → should return denied safely
		try {
			ApplicantData negativeData = new ApplicantData(-1000, -200, true);
			String result = tree.evaluate(negativeData);
			printResult("Negative income & credit handled", result.equals("denied"));
		} catch (Exception e) {
			printResult("Negative income & credit handled", false);
		}
	}

	// Normal test cases
	private static void testNormalCases() {
		System.out.println("\n--- NORMAL CASES ---");
		DecisionTree tree = buildTestTree();

		ApplicantData a1 = new ApplicantData(70000, 720, true);
		printResult("High income & high credit", tree.evaluate(a1).equals("approved"));

		ApplicantData a2 = new ApplicantData(28000, 720, true);
		printResult("Low income & high credit", tree.evaluate(a2).equals("denied"));

		ApplicantData a3 = new ApplicantData(80000, 500, true);
		printResult("High income & low credit", tree.evaluate(a3).equals("denied"));
	}
}
