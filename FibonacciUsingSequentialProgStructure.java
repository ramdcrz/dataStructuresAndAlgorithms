package dataStructuresAndAlgorithms;
import java.util.Scanner;

public class FibonacciUsingSequentialProgStructure {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of terms for Fibonacci series: ");
		int number = input.nextInt();
		input.close();
		
		// Print how many numbers will be displayed depending on the number picked
		System.out.println("\nFibonacci series up to " + number + " numbers");
		
		// Initialize first two Fibonacci numbers
		int first = 0;
		int second = 1;
		
		// Print first two Fibonacci numbers
		System.out.print(first + " " + second + " ");
		
		// Calculate and print the rest of the Fibonacci series
		for (int i = 3; i <= number; i++) {
			int next = first + second;
			System.out.print(next + " ");
			first = second;
			second = next;
		}
	}
}