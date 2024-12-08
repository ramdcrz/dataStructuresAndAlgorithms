package dataStructuresAndAlgorithms;

import java.util.*;
public class Project_Esguerra_Deocariza_Miranda_Reyes_Sanchez_Sanglay {
	
	    static boolean run = true;
	    static Scanner input = new Scanner(System.in);

	    public static void main(String[] args) {
	        printBorder();
	        System.out.println("Welcome to the Combined Program!");

	        while (run) {
	            System.out.println("\nTell me what you want to do. Here are your options: ");
	            System.out.println("[1] Determine if a year is a LEAP YEAR or NOT.");
	            System.out.println("[2] HEIGHT COMPARISON of 3 persons.");
	            System.out.println("[3] Display the Series.");
	            System.out.println("[4] Display a diamond of asterisk.");
	            System.out.println("[5] Binary Expression Tree Operations.");
	            System.out.println("[6] Exit.");
	            System.out.print("Select [1-6]: ");
	            int option = input.nextInt();

	            System.out.println();

	            switch (option) {
	                case 1:
	                    System.out.print("Enter year: ");
	                    int year = input.nextInt();
	                    leapYearCheck(year);
	                    break;

	                case 2:
	                    int people = 3; // Number of people to compare
	                    int height[] = new int[people];

	                    for (int i = 0; i < height.length; i++) {
	                        System.out.print("Enter height of Person " + (i + 1) + ": ");
	                        height[i] = input.nextInt();
	                    }
	                    heightComparison(height);
	                    break;

	                case 3:
	                    System.out.print("Enter an integer to determine the limit: ");
	                    int n = input.nextInt();
	                    generateSeries(n);
	                    break;

	                case 4:
	                    System.out.print("Enter size: ");
	                    int size = input.nextInt();
	                    createDiamond(size);
	                    break;

	                case 5:
	                    binaryExpressionTree();
	                    break;

	                case 6:
	                    System.out.println("Exiting Program...");
	                    run = false;
	                    break;

	                default:
	                    System.out.println("Invalid option. Please try again.");
	                    break;
	            }
	        }

	        printBorder();
	    }

	    // Main Method
	    static void leapYearCheck(int year) {
	        if (isLeapYear(year))
	            System.out.printf("%d is a leap year.\n", year);
	        else
	            System.out.printf("%d is NOT a leap year.\n", year);
	    }

	    static void heightComparison(int[] height) {
	        if (isHeightEqual(height)) {
	            System.out.println("Persons are the same height.");
	        } else {
	            int tallest = height[0];
	            int index = 0; // Added index initialization
	            for (int i = 0; i < height.length; i++) {
	                if (height[i] > tallest) {
	                    tallest = height[i];
	                    index = i;
	                }
	            }
	            System.out.printf("Person %d is the tallest (%d cm)\n", index + 1, tallest); // Corrected output format
	        }
	    }

	    private static void generateSeries(int num) {
			int a1 =0;  //store the first term
			int a2 = 1; //store the succeeding term
			int sum =1;
			System.out.printf("Series of %d: ",num);
			for(int i = 1;i<=num;i++) {
				System.out.print(sum+" ");
			    sum = a1+a2;
				a1 = a2;
				a2 = sum;
			}
		}

	    private static void createDiamond(int size) {
	        // Print the upper half and the middle row of the diamond
	        for (int row = 0; row < size * 2 - 1; row++) { // Declare and initialize 'row' variable
	            // Determine whether to print upper or lower half
	            int spaces = Math.abs(size - 1 - row);
	            int asterisks = size - spaces;

	            // Print spaces
	            for (int j = 0; j < spaces; j++) {
	                System.out.print(" ");
	            }
	            // Print asterisks
	            for (int k = 0; k < asterisks * 2 - 1; k++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	    }

	    // Utility and Submethods
	    static void printBorder() {
	        System.out.println("=======================================================");
	    }

	    static boolean isLeapYear(int year) {
	        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    static boolean isHeightEqual(int[] height) {
	        for (int i = 0; i < height.length; i++) {
	            if (height[i] != height[0]) // Removed semicolon and added braces
	                return false;
	        }
	        return true;
	    }

	    static void binaryExpressionTree() {
	        Scanner input = new Scanner(System.in);
	        boolean run = true;
	        printBorder();
	        System.out.println("BINARY EXPRESSION TREE");

	        Node r = null;
	        String expression = null;
	        while (true) {
	            System.out.print("\nEnter a fully parenthesized expression: ");
	            expression = input.nextLine();
	            if (isValidExpression(expression)) {
	                r = expressionTree(expression);
	                break;
	            } else {
	                System.out.println("Invalid expression. Please enter a fully parenthesized expression.");
	            }
	        }

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
	                    System.out.print("Exiting Binary Expression Tree Operations...");
	                    System.out.println();
	                    printBorder();
	                    run = false;
	                    System.exit(0);
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
	   
	    public static boolean isValidExpression(String expression) {
	        int balance = 0;
	        for (int i = 0; i < expression.length(); i++) {
	            char ch = expression.charAt(i);
	            if (ch == '(') {
	                balance++;
	            } else if (ch == ')') {
	                balance--;
	                if (balance < 0) {
	                    return false;
	                }
	            }
	        }
	        return balance == 0;
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
	                operators.push(ch);
	            } else if (ch == ')') {
	                if (!operators.isEmpty()) {
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

	        return st.pop();
	    }

	    public static boolean isOperator(char ch) {
	        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
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
}