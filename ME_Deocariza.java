package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class ME_Deocariza {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("MENU: ");
            System.out.println("1. REVERSE A WORD");
            System.out.println("2. CHECK IF PARENTHESES ARE BALANCED");
            System.out.println("3. EXIT");
            System.out.print("Select an option [1..3]: ");

            choice = scan.nextInt();
            System.out.println();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter a word to reverse: ");
                    String word = scan.nextLine();
                    String reversedWord = reverseWordRecursive(word);
                    System.out.println("The reverse of the word is " + reversedWord);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter a string with parentheses: ");
                    String input = scan.nextLine();
                    System.out.println(balanceParentheses(input) ? "Parentheses are balanced" : "Parentheses are not balanced");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Program terminated. This is Ramil Deocariza Jr. Thanks...");
                    break;
                default:
                    System.out.println("Please enter a valid option [1..3].");
                    System.out.println();
            }
        }
        scan.close();
    }

    public static String reverseWordRecursive(String word) {
        if (word.length() <= 1) {
            return word;
        }
        return reverseWordRecursive(word.substring(1)) + word.charAt(0);
    }

    public static boolean balanceParentheses(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                count++;
            } else if (input.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
