package dataStructuresAndAlgorithms;
import java.util.Scanner;

public class ArrayA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome! Pick one:");
            System.out.println("1. Sum of N number in an array");
            System.out.println("2. Maximum and Minimum number");
            System.out.println("3. Distinct Number");
            System.out.println("4. Exit\n");
            System.out.print("Enter option [1..4]: ");
            int input = scanner.nextInt();

            if (input >= 1 && input <= 3) {
                System.out.print("\nInput array size: ");
                int size = scanner.nextInt();
                int[] arraySize = new int[size];
                System.out.print("Input " + size + " values: ");
                for (int i = 0; i < size; i++) {
                    arraySize[i] = scanner.nextInt();
                }

                switch (input) {
                    case 1:
                        int sum = 0;
                        for (int i = 0; i < size; i++) {
                                sum += arraySize[i];
                        }
                        System.out.println("Sum of " + size + " values: " + sum + "\n");
                        break;

                    case 2:
                        int min = arraySize[0];
                        int max = arraySize[0];
                        for (int i = 1; i < size; i++) {
                            if (arraySize[i] < min) {
                                min = arraySize[i];
                            }
                            if (arraySize[i] > max) {
                                max = arraySize[i];
                            }
                        }
                        System.out.println("Maximum value: " + max);
                        System.out.println("Minimum value: " + min + "\n");
                        break;

                    case 3:
                        System.out.print("Distinct values: ");
                        for (int i = 0; i < size; i++) {
                            boolean isDistinct = true;
                            for (int j = 0; j < i; j++) {
                                if (arraySize[i] == arraySize[j]) {
                                    isDistinct = false;
                                    break;
                                }
                            }
                            if (isDistinct) {
                                System.out.print(arraySize[i] + " ");
                            }
                        }
                        System.out.println("\n");
                        break;
                        
                }

            } else if (input == 4) {
                System.out.println("This program will now exit.");
                exit = true;
            } else {
                System.out.println("Please enter a valid option (1-4).");
            }
        }
        scanner.close();
    }
}