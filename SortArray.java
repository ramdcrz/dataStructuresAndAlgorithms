package dataStructuresAndAlgorithms;

import java.util.Scanner;
import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 6 integers for the first array:");
        int[] num1 = new int[6];
        for (int i = 0; i < 6; i++) {
            num1[i] = input.nextInt();
        }
        System.out.println("\nEnter 7 integers for the second array:");
        int[] num2 = new int[7];
        for (int i = 0; i < 7; i++) {
            num2[i] = input.nextInt();
        }

        for (int i = 0; i < num1.length - 1; i++) {
            for (int j = 0; j < num1.length - i - 1; j++) {
                if (num1[j] > num1[j + 1]) {
                    int temp = num1[j];
                    num1[j] = num1[j + 1];
                    num1[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < num2.length - 1; i++) {
            for (int j = 0; j < num2.length - i - 1; j++) {
                if (num2[j] > num2[j + 1]) {
                    int temp = num2[j];
                    num2[j] = num2[j + 1];
                    num2[j + 1] = temp;
                }
            }
        }

        System.out.println("\nAfter sorting new array becomes: " + Arrays.toString(num1));
        System.out.println("After sorting new array becomes: " + Arrays.toString(num2));
    }
}