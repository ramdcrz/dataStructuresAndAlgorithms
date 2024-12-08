package dataStructuresAndAlgorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Deocariza_Stacks {
	
    static Stack<Integer> stacks = new Stack<>();
    static int size;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the number of stack elements: ");
        size = scan.nextInt();
        boolean stopper = true;
        while (stopper) {
            printMenu();
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    push();
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    top();
                    break;
                case 4:
                    size();
                    break;
                case 5:
                    isEmpty();
                    break;
                case 6:
                    displayStack();
                    break;
                case 7:
                    System.out.println("\nThis is Ramil Deocariza Jr. Thanks...");
                    stopper = false;
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nMENU");
        System.out.print("1. PUSH\n" +
                "2. POP\n" +
                "3. TOP\n" +
                "4. SIZE\n" +
                "5. EMPTY\n" +
                "6. DISPLAY STACK\n" +
                "7. EXIT\n" +
                "Enter Choice [1..7] : ");
    }

    public static void push() {
        System.out.print("\nEnter an element to add: ");
        int element = scan.nextInt();
        if (stacks.size() >= size) {
            System.out.println("Stack Overflow");
        } else {
            stacks.push(element);
            System.out.println(element + " has been pushed to the stack.");
        }
    }

    public static void pop() {
        if (stacks.isEmpty()) {
            System.out.println("\nStack is empty");
        } else {
            int poppedElement = stacks.pop();
            System.out.println("\n" + poppedElement + " has been popped from the stack.");
        }
    }

    public static void top() {
        System.out.println("\nThe top element is " + (stacks.isEmpty() ? "null" : stacks.peek()));
    }

    public static void size() {
        System.out.println("\nThe size of the stack is " + stacks.size());
    }

    public static void isEmpty() {
        System.out.println("\n" + (stacks.isEmpty() ? "TRUE" : "FALSE"));
    }

    public static void displayStack() {
        System.out.println(stacks);
    }
}