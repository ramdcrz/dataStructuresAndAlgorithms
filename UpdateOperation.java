package dataStructuresAndAlgorithms;

public class UpdateOperation {

	public static void main(String[] args) {
		int LA[] = {1, 3, 5, 7, 8};
		int k = 3, n = 5, item = 10;
		int i, j;
		
		System.out.println("The original array elements are :");
		
		for (i = 0; i < n; i++) {
			System.out.println("LA [" + i + "] = " + LA[i]);
		}
		
		LA[k - 1] = item;
		
		System.out.println("The array elements after updation :");
		
		for (i = 0; i < n; i++) {
			System.out.println("LA [" + i + "] = " + LA[i]);
		}
	}
}