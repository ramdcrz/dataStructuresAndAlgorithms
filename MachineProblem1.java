package dataStructuresAndAlgorithms;
import java.util.Scanner;
import java.util.ArrayList;

public class MachineProblem1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
        
        while (!exit) {
            System.out.println("Pick one:");
            System.out.println("1. Sum of digit");
            System.out.println("2. Reverse the number");
            System.out.println("3. Prime numbers from 2 to n");
            System.out.println("4. Palindrome checking");
            System.out.println("5. Odd or even number");
            System.out.println("6. Exit\n");
            System.out.print("Enter option [1..6]: ");
            int input = scanner.nextInt();

            if (input >= 1 && input <= 5) {
                System.out.print("INPUT INTEGER VALUE: ");
                int num = scanner.nextInt();

                switch (input) {
                    case 1: {
                    	System.out.println("\nSum of digit: " + num);
                    	int sum = 0;
                        while (num != 0) {
                            sum += num % 10;
                            num /= 10;
                        }
                        System.out.println("= " + sum + "\n");
                        break;
                    }
                    
                    case 2: {
                    	System.out.println("\nGiven: " + num);
                        int reversedNum = 0;
                        while (num != 0) {
                            reversedNum = reversedNum * 10 + (num % 10);
                            num /= 10;
                        }
                        System.out.println("= " + reversedNum + "\n");
                        break; 
                    }
                    
                    case 3: {
                        System.out.println("\nGiven: " + num);
                        ArrayList<Integer> primes = new ArrayList<>();
                        boolean[] isComposite = new boolean[num + 1];
                        
                        for (int i = 2; i <= num; i++) {
                            if (!isComposite[i]) {
                                primes.add(i);
                                for (int j = i * i; j <= num; j += i) {
                                    isComposite[j] = true;
                                }
                            }
                        }
                        System.out.println("= " + primes + "\n");
                        break;
                    }

                    case 4: {
                        System.out.println("\nGiven: " + num);
                        
                        boolean isPalindrome = true;
                        String originalNum = String.valueOf(num);
                        String reversedStringNum = new StringBuilder(originalNum).reverse().toString();

                        if (!originalNum.equals(reversedStringNum)) {
                            isPalindrome = false;
                        }

                        String palindromeStatus = isPalindrome ? "" : "Not ";
                        System.out.println("= " + num + " " + palindromeStatus + "Palindrome\n");
                        break;
                    }

                    case 5: {
                    	System.out.println("\nGiven: " + num);
                    	if (num % 2 == 0) {
                    	    System.out.println("= " + " Even\n");
                    	} else {
                    	    System.out.println("= " + " Odd\n");
                    	}
                        break;
                    }
                }
            
            } else if (input >= 7) {
            	System.out.println("Please, only enter a digit from 1 to 6.\n");
            } else if (input == 6) {
            	System.out.println("Ramil V. Deocariza Jr.");
            	exit = true;
            }
        }
        scanner.close();
    }
}