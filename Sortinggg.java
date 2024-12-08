package dataStructuresAndAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Sortinggg{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int[] array = readArray(scanner);
            if (array.length == 0) {
                break;
            }

            int[] sortedArray = sortArray(array, scanner);
            System.out.println("\nSorted Array:");
            printArray(sortedArray);
        }

        System.out.println("Programmed by: Sanchez, John Marc | Esguerra, Joren Irbert ");
    }

    private static int[] readArray(Scanner scanner) {
        System.out.print("\nEnter the size of the array (0 to exit): ");
        int size = scanner.nextInt();
        if (size <= 0) {
            return new int[0];
        }

        int[] array = new int[size];
        System.out.printf("Enter %d values separated by spaces: ", size);
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int[] sortArray(int[] array, Scanner scanner) {
        boolean continueSorting = true;
        while (continueSorting) {
            System.out.print("\nMenu\n"
                    + "1. Bubble Sort\n"
                    + "2. Insertion Sort\n"
                    + "3. Selection Sort\n"
                    + "4. Merge Sort\n"
                    + "5. Quick Sort\n"
                    + "6. Heap Sort\n"
                    + "7. Exit\n"
                    + "Enter Choice [1-7]: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    array = bubbleSort(array);
                    break;
                case 2:
                    array = insertionSort(array);
                    break;
                case 3:
                    array = selectionSort(array);
                    break;
                case 4:
                    array = mergeSort(array);
                    break;
                case 5:
                    array = quickSort(array);
                    break;
                case 6:
                    array = heapSort(array);
                    break;
                default:
                    continueSorting = false;
                    break;
            }
            if (continueSorting) {
                System.out.println("\nSorted Array:");
                printArray(array);
            }
        }
        return array;
    }


    private static int[] bubbleSort(int[] array) {
        System.out.println("\nBUBBLE SORT");
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean swapped;
        for (int i = 0; i < sortedArray.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            System.out.printf("\nAfter Pass %d:\n", i + 1);
            printArray(sortedArray);
        }
        return sortedArray;
    }

    private static int[] insertionSort(int[] array) {
        System.out.println("\nINSERTION SORT");
        int[] sortedArray = Arrays.copyOf(array, array.length);
        for (int i = 1; i < sortedArray.length; i++) {
            int key = sortedArray[i];
            int j = i - 1;
            while (j >= 0 && sortedArray[j] > key) {
                sortedArray[j + 1] = sortedArray[j];
                j--;
            }
            sortedArray[j + 1] = key;
            System.out.printf("\nAfter Pass %d:\n", i);
            printArray(sortedArray);
        }
        return sortedArray;
    }

    private static int[] selectionSort(int[] array) {
        System.out.println("\nSELECTION SORT");
        int[] sortedArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < sortedArray[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = sortedArray[minIndex];
            sortedArray[minIndex] = sortedArray[i];
            sortedArray[i] = temp;
            System.out.printf("\nAfter Pass %d:\n", i + 1);
            printArray(sortedArray);
        }
        return sortedArray;
    }

    private static int[] mergeSort(int[] array) {
        System.out.println("\nMERGE SORT");
        int[] sortedArray = Arrays.copyOf(array, array.length);
        mergeSortHelper(sortedArray, 0, sortedArray.length - 1);
        return sortedArray;
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(array, left, mid);
            mergeSortHelper(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        for (i = left; i <= right; i++) {
            array[i] = temp[i - left];
        }
    }

    private static int[] quickSort(int[] array) {
        System.out.println("\nQUICK SORT");
        int[] sortedArray = Arrays.copyOf(array, array.length);
        quickSortHelper(sortedArray, 0, sortedArray.length - 1);
        return sortedArray;
    }

    private static void quickSortHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortHelper(array, low, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    private static int[] heapSort(int[] array) {
        System.out.println("\nHEAP SORT");
        int[] sortedArray = Arrays.copyOf(array, array.length);
        int n = sortedArray.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(sortedArray, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = sortedArray[0];
            sortedArray[0] = sortedArray[i];
            sortedArray[i] = temp;
            heapify(sortedArray, i, 0);
        }
        return sortedArray;
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest);
        }
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
