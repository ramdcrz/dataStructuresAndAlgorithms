package dataStructuresAndAlgorithms;

import java.util.Scanner;
import java.util.Arrays;

public class ArrangePositiveNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i, j, temp;

        System.out.println("Enter 10 integers for the array:");
        int arra_nums[] = new int[10];
        for (i = 0; i < 10; i++) {
            arra_nums[i] = input.nextInt();
        }

        System.out.println("\nOriginal array: " + Arrays.toString(arra_nums));

        // Sort the array in descending order
        for (i = 0; i < arra_nums.length; i++) {
            for (j = 0; j < arra_nums.length - i - 1; j++) {
                if (arra_nums[j] < arra_nums[j + 1]) {
                    temp = arra_nums[j];
                    arra_nums[j] = arra_nums[j + 1];
                    arra_nums[j + 1] = temp;
                }
            }
        }

        // Move negative numbers to the right side of the array
        for (i = 0; i < arra_nums.length; i++) {
            if (arra_nums[i] > 0) {
                continue;
            }
            for (j = i + 1; j < arra_nums.length; j++) {
                if (arra_nums[j] > 0) {
                    temp = arra_nums[i];
                    arra_nums[i] = arra_nums[j];
                    arra_nums[j] = temp;
                    break;
                }
            }
        }

        System.out.println("New array: " + Arrays.toString(arra_nums));
    }
}