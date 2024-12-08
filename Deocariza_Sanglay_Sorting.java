package dataStructuresAndAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Deocariza_Sanglay_Sorting {
	private static int[] originalArray;

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int arraySize;

        System.out.print("Enter the size of the array: ");
        arraySize = scan.nextInt();
        originalArray = new int[arraySize];
        System.out.print("Enter " + arraySize + " values: ");

        for (int i = 0; i < arraySize; i++) {
            originalArray[i] = scan.nextInt();
        }

        while (true) {
            displaySortingMenu();
            int choice;
            do {
                while (!scan.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scan.next();
                }
                choice = scan.nextInt();
                if (choice < 1 || choice > 7) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } while (choice < 1 || choice > 7);

            int[] arrayToSort = Arrays.copyOf(originalArray, originalArray.length); 

            switch (choice) {
                case 1:
                	System.out.print("\n1. Bubble Sort");
                    bubbleSort(arrayToSort);
                    break;
                case 2:
                	System.out.print("\n2. Insertion Sort\n");
                    insertionSort(arrayToSort);
                    break;
                case 3:
                	System.out.print("\n3. Selection Sort\n");
                    selectionSort(arrayToSort);
                    break;
                case 4:
                	System.out.print("\n4. Merge Sort\n");
                	mergeSort(arrayToSort);
                    break;
                case 5:
                	System.out.print("\n5. Quick Sort\n");
                    quickSort(arrayToSort, 0, arrayToSort.length - 1);
                    break;
                case 6:
                	System.out.print("\n6. Heap Sort\n");
                    heapSort(arrayToSort);
                    break;
                case 7:
                    System.out.println("\nDeocariza Jr., Ramil");
                    System.out.println("Sanglay, Ricky Joe");
                    System.out.println("Thank you for using our program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.print("Sorted Numbers: "); 
            printArray(arrayToSort); 
        }
    }
 
    static void bubbleSort(int[] arr) {
        int swap;
        int size = arr.length;  // Get size from the array itself
        int[] arrCopy = Arrays.copyOf(arr, size);
        Arrays.sort(arrCopy);
        System.out.print("\n ");
        printArray(arr);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
                System.out.print(" ");
                printArray(arr);
            }
            System.out.println();
            if (arrayChecker(arr, arrCopy)) {
                break;
            }
            if (i == 0) {
                System.out.print("Second Pass\n");
            }
            if (i == 1) {
                System.out.print("Third Pass\n");
            }
            if (i == 2) {
                System.out.print("Fourth Pass\n");
            }
        }
    }

    static boolean arrayChecker(int[] arr, int[] arrCopy) {
        int size = arr.length; // Get size from the array
        for (int i = 0; i < size; i++) {
            if (arrCopy[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    static void insertionSort(int[] A) {
        int n = A.length, temp;
        
        for (int i = 1; i < n; i++) {
            temp = A[i];
            int j = i - 1;
            while (j >= 0 && temp < A[j]) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = temp;
            System.out.print(" ");
            printArray(A); 
        }
        System.out.print(" ");
        printArray(A);
        System.out.println();
    }
    
    static void selectionSort(int[] A) {
        int n = A.length, min, index = 0;
        
        for (int i = 0; i < n - 1; i++) {
            min = A[i];
            index = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < min) {
                    min = A[j];
                    index = j;
                }
            }
            A[index] = A[i];
            A[i] = min;
            System.out.print(" ");
            printArray(A); 
        }
        System.out.print(" ");
        printArray(A);
        System.out.println();
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];
            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, n - mid);
            mergeSort(left);
            mergeSort(right);
            System.out.print(" "); // Add space before left
            System.out.print("Left: ");
            printArray(left);
            System.out.print(" "); // Add space before right
            System.out.print("Right: ");
            printArray(right);
            merge(arr, left, right);
            System.out.print(" "); // Add space before merged
            System.out.print("Merged: ");
            printArray(arr);
            System.out.println();
        } else {
            return;
        }
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void heapSort(int[] arr) {
    	System.out.print(" ");
        printArray(arr);
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
            System.out.print(" ");
            printArray(arr);
        }
        System.out.println();
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void displaySortingMenu() {
        System.out.println("\nMenu");
        System.out.println(" 1. Bubble Sort");
        System.out.println(" 2. Insertion Sort");
        System.out.println(" 3. Selection Sort");
        System.out.println(" 4. Merge Sort");
        System.out.println(" 5. Quick Sort");
        System.out.println(" 6. Heap Sort");
        System.out.println(" 7. Exit");
        System.out.print("Enter Choice [1..7]: ");
    }
}