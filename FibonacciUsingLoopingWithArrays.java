package dataStructuresAndAlgorithms;
import java.util.Scanner;

public class FibonacciUsingLoopingWithArrays {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of terms for Fibonacci series: ");
		int number = input.nextInt();
		input.close();
		
		// Print how many numbers will be displayed depending on the number picked
		System.out.println("\nFibonacci series up to " + number + " numbers");
		
		int[] fib = new int[number];
		
		// Initialize first two Fibonacci numbers
		fib[0] = 0;
		fib[1] = 1;
		
		// Calculate and print the rest of the Fibonacci series
		for (int i = 2; i < number; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		
		for (int i = 0; i < number; i++) {
			System.out.print(fib[i] + " ");
		}
	}
}