package dataStructuresAndAlgorithms;

public class DeletionOperation {

	public static void main(String[] args) {
		int LA[] = {1, 3, 5, 7, 8};
        int k = 3, n = 5;
        int i, j;

        System.out.println("The original array elements are: ");
        
        for (i = 0; i < n; i++) {
            System.out.print("LA[" + i + "] = " + LA[i] + "\n");
        }

        j = k;

        while (j < n) {
            LA[j - 1] = LA[j];
            j = j + 1;
        }

        n = n - 1;

        System.out.println("The array elements after deletion :");

        for (i = 0; i < n; i++) {
            System.out.println("LA[" + i + "] = " + LA[i]);
        }
    }
}