package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MinSubArraySum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int startIndex = 0, endIndex = 0, currentSum = 0;

        System.out.print("Enter the number of elements in the array: ");
        int numElements = input.nextInt();

        int[] num = new int[numElements];
        System.out.println("Enter the elements of the array:");
        
        for (int i = 0; i < numElements; i++) {
            num[i] = input.nextInt();
        }

        System.out.print("\nSub-array size: ");
        int subArraySize = input.nextInt();

        int minSum = (~0) >>> 1;
        

        for (int i = 0; i < numElements - subArraySize + 1; i++) {
            currentSum = 0;
            for (int j = i; j < i + subArraySize; j++) {
                currentSum += num[j];
            }
            if (currentSum < minSum) {
                minSum = currentSum;
                startIndex = i;
                endIndex = i + subArraySize;
            }
        }

        System.out.println("Sub-array from " + startIndex + " to " + (endIndex - 1) + " and sum is: " + minSum);
    }
}