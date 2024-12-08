package dataStructuresAndAlgorithms;

import java.util.*;

public class GroupProj1 {

	static class Node {
		char data;
		String varName;
		double value;
		Node left, right;

		Node(char data) {
			this.data = data;
			this.left = this.right = null;
		}

		Node(String varName) {
			this.varName = varName;
			this.value = 0; // Initialize all variables to 0
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean run = true;
		printBorder();
		System.out.println("BINARY EXPRESSION TREE");
		System.out.print("\nEnter a fully parenthesized expression: ");
		String expression = input.nextLine();

		Node r = expressionTree(expression);

		while (run) {
			printMenu();
			int choice = input.nextInt();

			System.out.println();

			switch (choice) {
			case 1:
				System.out.println("Infix Notation: ");
				inorder(r);
				System.out.println();
				break;
			case 2:
				System.out.println("Prefix Notation: ");
				preorder(r);
				System.out.println();
				break;
			case 3:
				System.out.println("Postfix Notation: ");
				postorder(r);
				System.out.println();
				break;
			case 4:
				System.out.println("Expression Tree: ");
				printTree(r);
				break;
			case 5:
				Map<String, Double> values = new HashMap<>();
				for (String var : extractVariables(expression)) {
					System.out.print("Enter the value for " + var + ": ");
					while (!input.hasNextDouble()) {
						System.out.println("Invalid value. Please enter a numeric value for " + var + ": ");
						input.next();
					}
					double value = input.nextDouble();
					values.put(var, value);
				}
				updateValues(r, values);
				String updatedExpression = getExpression(r);
				double result = evaluate(r);
				System.out.println("Updated Expression: " + updatedExpression + " = " + String.format("%.2f", result));
				break;
			case 6:
				System.out.print("Exiting Program...");
				System.out.println();
				printBorder();
				run = false;
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 6.");
			}
		}
		input.close();
	}

	
	public static void printMenu() {
		System.out.print("\nMAIN MENU" + "\n[1] Display Infix Notation" + "\n[2] Display Prefix Notation"
				+ "\n[3] Display Postfix Notation" + "\n[4] Display Binary Tree" + "\n[5] Update Values"
				+ "\n[6] Exit Program" + "\n\nPress [1-6]: ");
	}

	public static void printBorder() {
		System.out.println("=========================================================");
	}

	public static Node expressionTree(String expression) {
		Stack<Node> st = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			if (ch == '(') {
				continue;
			} else if (Character.isLetterOrDigit(ch)) {
				String varName = "";
				while (i < expression.length() && Character.isLetterOrDigit(expression.charAt(i))) {
					varName += expression.charAt(i);
					i++;
				}
				i--; // step back to correct index increment
				st.push(new Node(varName));
			} else if (isOperator(ch)) {
				while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
					char op = operators.pop();
					Node right = st.pop();
					Node left = st.pop();
					Node temp = new Node(op);
					temp.left = left;
					temp.right = right;
					st.push(temp);
				}
				operators.push(ch);
			} else if (ch == ')') {
				while (!operators.isEmpty()) {
					char op = operators.pop();
					Node right = st.pop();
					Node left = st.pop();
					Node temp = new Node(op);
					temp.left = left;
					temp.right = right;
					st.push(temp);
				}
			}
		}

		while (!operators.isEmpty()) {
			char op = operators.pop();
			Node right = st.pop();
			Node left = st.pop();
			Node temp = new Node(op);
			temp.left = left;
			temp.right = right;
			st.push(temp);
		}

		return st.pop();
	}

	public static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
	}

	public static int precedence(char op) {
		if (op == '+' || op == '-')
			return 1;
		if (op == '*' || op == '/')
			return 2;
		if (op == '^')
			return 3;
		return 0; // For parentheses
	}

	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print((root.varName != null ? root.varName : root.data) + " ");
		inorder(root.right);
	}

	public static void preorder(Node root) {
		if (root == null)
			return;
		System.out.print((root.varName != null ? root.varName : root.data) + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(Node root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print((root.varName != null ? root.varName : root.data) + " ");
	}

	public static void printTree(Node root) {
		printTreeHelper(root, "", true);
	}

	private static void printTreeHelper(Node node, String prefix, boolean isTail) {
		if (node == null)
			return;
		System.out.println(prefix + (isTail ? "└── " : "├── ") + (node.varName != null ? node.varName : node.data));
		if (node.left != null || node.right != null) {
			if (node.left != null) {
				printTreeHelper(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
			}
			if (node.right != null) {
				printTreeHelper(node.right, prefix + (isTail ? "    " : "│   "), true);
			}
		}
	}

	public static List<String> extractVariables(String expression) {
		List<String> variables = new ArrayList<>();
		StringBuilder varName = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				varName.setLength(0);
				while (i < expression.length()
						&& (Character.isLetterOrDigit(expression.charAt(i)) || expression.charAt(i) == '_')) {
					varName.append(expression.charAt(i));
					i++;
				}
				i--; // step back to correct index increment
				variables.add(varName.toString());
			}
		}
		return variables;
	}

	public static void updateValues(Node root, Map<String, Double> values) {
		if (root == null)
			return;
		if (root.varName != null && values.containsKey(root.varName)) {
			root.value = values.get(root.varName);
		}
		updateValues(root.left, values);
		updateValues(root.right, values);
	}

	public static String getExpression(Node root) {
	    if (root == null)
	        return "";
	    if (root.varName != null)
	        return Double.toString(root.value); // Return the value of the variable
	    String leftExpr = getExpression(root.left);
	    String rightExpr = getExpression(root.right);
	    return "(" + leftExpr + root.data + rightExpr + ")";
	}
	public static double evaluate(Node root) {
		if (root == null)
			return 0;
		if (root.varName != null)
			return root.value;
		double leftVal = evaluate(root.left);
		double rightVal = evaluate(root.right);
		switch (root.data) {
		case '+':
			return leftVal + rightVal;
		case '-':
			return leftVal - rightVal;
		case '*':
			return leftVal * rightVal;
		case '/':
			if (rightVal == 0) {
				throw new ArithmeticException("Division by zero");
			}
			return leftVal / rightVal;
		case '^':
			return Math.pow(leftVal, rightVal);
		default:
			throw new IllegalArgumentException("Invalid operator");
		}
	}

}