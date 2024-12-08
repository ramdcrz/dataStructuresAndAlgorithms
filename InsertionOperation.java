package dataStructuresAndAlgorithms;

public class InsertionOperation {

    public static void main(String[] args) {
        int LA[] = {1, 3, 5, 7, 8};
        int item = 10;
        int k = 3, n = 5;
        int i, j;

        System.out.println("The original array elements are: ");
        
        for (i = 0; i < n; i++) {
            System.out.println("LA[" + i + "] = " + LA[i]);
        }

        int LA2[] = new int[n + 1];
        
        i = 0;
        do {
        	LA2[i] = LA[i];
        	i++;
        } while (i < n);
        
        j = n;
        do {
        	LA2[j] = LA2[j - 1];
        	j--;
        } while (j > k);

        LA2[k] = item;
        n++;

        System.out.println("The array elements after insertion :");

        for (i = 0; i < n; i++) {
            System.out.println("LA[" + i + "] = " + LA2[i]);
        }
    }
}