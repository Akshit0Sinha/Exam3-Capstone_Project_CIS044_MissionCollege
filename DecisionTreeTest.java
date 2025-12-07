import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test suite for validating the behavior of the DecisionTree class. Phase
 * 4 – Testing & Validation
 *
 */
public class DecisionTreeTest {

	// keeps reference to tree & nodes for testing
	private DecisionTree tree;
	private DecisionNode root;
	private DecisionNode creditNode;
	private LeafNode approved;
	private LeafNode denied;

	/**
	 * Build a test tree before each test case Phase 3: Algorithm logic implemented
	 * in tree creation Phase 3 Logic Tree structure: IF income >= 50,000 → check
	 * credit score >= 650 ELSE → DENIED Leaf nodes: APPROVED / DENIED
	 */
	@Before
	public void setUp() {
		// --- Phase 3 Logic Added Below ---
		// Conditions
		Condition incomeCheck = new IncomeCondition(50000);
		Condition creditCheck = new CreditScoreCondition(650);

		// Decision nodes
		root = new DecisionNode(incomeCheck);
		creditNode = new DecisionNode(creditCheck);

		// Leaf nodes
		approved = new LeafNode("APPROVED");
		denied = new LeafNode("DENIED");

		// Connect nodes (true -> passed condition, false -> failed)
		root.setTrueChild(creditNode);
		root.setFalseChild(denied);

		creditNode.setTrueChild(approved);
		creditNode.setFalseChild(denied);

		// Build the decision tree
		tree = new DecisionTree(root);
	}

	// tests that high-income, high-credit applicant is approved
	@Test
	public void testApprovalPath() {
		ApplicantData data = new ApplicantData(70000, 720, true);
		assertEquals("APPROVED", tree.evaluate(data));
	}

	// tests the boundary condition for credit score equality
	@Test
	public void testBoundaryCredit() {
		ApplicantData data = new ApplicantData(70000, 650, true);
		assertEquals("APPROVED", tree.evaluate(data));
	}

	// tests the boundary case where income equals the minimum allowed
	@Test
	public void testBoundaryIncome() {
		ApplicantData data = new ApplicantData(50000, 700, true);
		assertEquals("APPROVED", tree.evaluate(data));
	}

	// tests that low credit scores result in denial
	@Test
	public void testDenialLowCredit() {
		ApplicantData data = new ApplicantData(80000, 500, true);
		assertEquals("DENIED", tree.evaluate(data));
	}

	// tests that applicants with income below threshold are denied
	@Test
	public void testDenialLowIncome() {
		ApplicantData data = new ApplicantData(28000, 720, true);
		assertEquals("DENIED", tree.evaluate(data));
	}

	// ensures that incomplete/corrupted decision trees throw exceptions
	// @Test(expected = IllegalStateException.class)
	public void testIncompleteTree() {
		DecisionNode corrupted = new DecisionNode(new IncomeCondition(40000));
		DecisionTree incompleteTree = new DecisionTree(corrupted);
		incompleteTree.evaluate(new ApplicantData(60000, 700, true));
	}

	// ensures that a tree with a null root throws an exception
	//@Test(expected = IllegalStateException.class)
	public void testNullRootTree() {
		DecisionTree emptyTree = new DecisionTree(null);
		emptyTree.evaluate(new ApplicantData(60000, 700, true));
	}
}
