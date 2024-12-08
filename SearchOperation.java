package dataStructuresAndAlgorithms;

public class SearchOperation {

	public static void main(String[] args) {
		int LA[] = {1, 3, 5, 7, 8};
        int item = 5, n = 5;
        int i = 0, j = 0;

        System.out.println("The original array elements are: ");
        
        for (i = 0; i < n; i++) {
            System.out.println("LA[" + i + "] = " + LA[i]);
        }

        while (j < n) {
            if (LA[j] == item) {
            	break;
            }
            j = j + 1;
        }

        System.out.println("Found element " + item + " at position " + (j+1));
    }
}
