/**
 * INSTRUCTIONS.
 * 
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainy doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control strucurs we've covered. You are not permitted to use
 * recursive code in your solutions.
 * 
 * Please be mindful of the expected outputs, as your code will be tested against that
 * directly. If you're unsure, please ask for clarification.
 * 
 * This problem set is worth 25 points and is due no later than 11:59pm on October 28, 2018.
 */

public class ProblemSet3_5 {
	
	public static void main(String[] args) {
		ProblemSet3_5 ps = new ProblemSet3_5();
		
		// test your solutions here
		
		ps.testFunctions();
		
		// ps.primes(1, 1000);
	}
	
	/**
	 * How many prime numbers are there between @start and @end, where @start and @end
	 * are positive integers in the range [1, @Integer.MAX_VALUE]?
	 * 
	 * Print your solution in the following formats: "There is X prime number."
	 *                                               "There are X prime numbers."
	 * 
	 * @param start
	 * @param end
	 */
	
	public void primes(int start, int end) {
		int counter = 0;
		Boolean prime;
		
		for (int between = start; between <= end; between++) {
			
			prime = true;
			
			for (int factor = 2; factor * factor <= between; factor++) {
				if(between % factor == 0) {
					prime = false;
					break;
				}
			}
			
			prime = (between < 2) ? false : prime;
			
			if (prime) counter++; 
		}
		
		System.out.println("There " + ((counter == 1) ? "is 1 prime number." : "are " + counter + " prime numbers."));
	}
	
	/**
	 * What are the next @count leap years?
	 * 
	 * Print your solution in the following formats: "The next leap year is X."
	 *                                               "The next 2 leap years are X and Y."
	 *                                               "THe next N leap years are A, ..., X, Y, and Z."
	 * 
	 * @param count
	 */
	
	public void leapYears(int count) {
		
	}
	
	/**
	 * Is @number a palindromic number?
	 * 
	 * Print your solution in the following formats: "X is a palindromic number."
	 *                                               "X is not a palindromic number."
	 *                                               
	 * @param number
	 */
	
	public void palindromicNumbers(int number) {
		
		int len = Integer.toString(number).length();
		// will be the length of the array that stores digits
		
		int numberDivide = number;
		
		int[] iarray = new int[len];
		// initializes array 
		
		
		for (int index = 0; index < len; index++) {
			
		    iarray[index] = numberDivide % 10;
		    
		    numberDivide /= 10;
		    
		}
		// for loop that stores each number in array 
		
		
		for(int n = 0; n < len / 2; n++) {
			
			if(iarray[n] != iarray[len - 1 - n]) {
				// if the opposite end numbers are unequal 
				
				System.out.println(number + " is not a palindromic number.");
				return;
			}
		}
		System.out.println(number + " is a palindromic number.");
	}
	
	/**
	 * What is the @nth Fibonacci number, where @n is a positive integer?
	 * 
	 * Print your solution in the following formats: "The 21st Fibonacci number is X."
	 *                                               "The 22nd Fibonacci number is X."
	 *                                               "The 23rd Fibonacci number is X."
	 *                                               "The 24th Fibonacci number is X."
	 *                                               
	 * @param n
	 */
	
	public void fibonacci(int n) {
		
	}
	
	/**
	 * What is the sum of all multiples of @x and @y less than @limit, where @x, @y, and
	 * @limit are positive integers?
	 * 
	 * Print your solution in the following format: "The sum is X."
	 * 
	 * @param limit
	 */
	
	public void multiples(int x, int y, int limit) {
		int totalSum = 0;
		
		for (int n = 0; n * x * y < limit; n++) {
			totalSum += n * x * y;
		}
		
		System.out.println("The sum is " + totalSum + ".");
		
	}
	
	public void testFunctions() {
		primes(0, 234923);
		multiples(1, 2, 5); 
		palindromicNumbers(12322321);
	}
}