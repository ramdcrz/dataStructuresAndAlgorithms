package dataStructuresAndAlgorithms;

import java.util.Scanner;
import java.util.Stack;

public class Deocariza_Infix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Infix Notation Conversion ===\n");

        String infixNotation = getInputInfix(scanner);

        boolean exit = false;
        while (!exit) {
            displayMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    convertToPrefix(infixNotation);
                    break;
                case 2:
                    convertToPostfix(infixNotation);
                    break;
                case 3:
                    System.out.println("This is Ramil Deocariza Jr. Thanks...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    private static String getInputInfix(Scanner scanner) {
        System.out.print("Enter Infix Notation: ");
        return scanner.next();
    }

    private static void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Convert to Prefix Notation");
        System.out.println("2. Convert to Postfix Notation");
        System.out.println("3. Exit\n");
        System.out.print("Enter Choice [1..3]: ");
    }

    private static void convertToPrefix(String infix) {
        String prefix = infixToPrefix(infix);
        System.out.println("Prefix Notation: " + prefix);
    }

    private static void convertToPostfix(String infix) {
        String postfix = infixToPostfix(infix);
        System.out.println("Postfix Notation: " + postfix);
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static String infixToPrefix(String infix) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                prefix.insert(0, c);
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.insert(0, stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    prefix.insert(0, stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            prefix.insert(0, stack.pop());
        }

        return prefix.toString();
    }

    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
}