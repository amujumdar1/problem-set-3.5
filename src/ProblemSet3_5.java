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
		// boolean prime;
		
		for (int between = start; between <= end; between++) {
			
			if (isPrime(between)) counter++; 
		}
		
		System.out.println("There " + ((counter == 1) ? "is 1 prime number." : "are " + counter + " prime numbers."));
	}
	
	public boolean isPrime(int x) { // determines if number is boolean or not 
		
		if (x < 2) return false;
		
		for (int i = 2; i * i <= x; i++) {
			
			if (x % i == 0) return false; 
		}
		
		return true; 
		
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
		
		if (count <= 0) {
			System.out.println("I don't know how to compute the next " + count + " leap years...");
			return;
		}
		
		int newYear = 2018;
		// this method has been created so it works for non 2018 values. 
		
		
		while (!isLeap(newYear)) newYear++;
		
		if (count == 1) {
			
			System.out.println("The next leap year is " + newYear + ".");
			
			return;
		}
		
		else if (count == 2 && isLeap(newYear + 4)) {
			
			System.out.println("The next 2 leap years are " + (newYear)
					+ " and " + (newYear + 4) + ".");
			
			return;
			
		}
		
		
		System.out.print("The next " + count + " leap years are ");
		
		
		for (int x = 0; x < 4 * (count - 2); x+=4) {
			
			if (isLeap(newYear + x)) System.out.print((newYear + x) + ", ");
			else count++;
			/* loop to add 4 until the last two years
			 * if it doesn't follow the condition, though adds 1 to count
			 */
		}
		
		int finalYear = newYear + (count * 4 - 4);
		// so that the "and" is consistent 
		
		if (!isLeap(finalYear)) System.out.println("and " + (finalYear) + ".");
		// in the rare case that the last number is 2100 or something like that
		
		else System.out.println((finalYear - 4) + ", and " + (finalYear) + ".");
		
		
	}
	
	public boolean isLeap(int year) { // determines if a year is a leap year or not 
		
		if (year % 4 != 0) return false; 
		
		else if (year % 400 == 0) return true;
		
		else if (year % 100 == 0) return false; 
		
		else return true;
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
		
		int palindrome = number; 
		
		int backwards = 0; 
		
		while (palindrome != 0) {
			
			int remainder = palindrome % 10;
			
			backwards = backwards * 10  + remainder; 
			// makes the number in reverse 
			
			palindrome /= 10; 
			
		}
		
		
		System.out.println(number + " is " + ((number == backwards) ? "" : "not ") + "a palindromic number.");
		
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
		
		long previous = 1, current = 1, next;
		
		for (int x = 0; x < n - 2; x++) {
			next = previous + current;
			previous = current;
			current = next; 
		}
		
		String suffix; 
		
		switch((n / 10 == 1) ? n : (n % 10)) {
			case 1:
				suffix = "st";
				break;
			case 2: 
				suffix = "nd";
				break;
			case 3:
				suffix = "rd"; 
				break;
			default:
				suffix = "th";
		}
		
		System.out.println("The " + n + suffix + " Fibonacci number is " + current + ".");
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
		long sum = 0;
		
		for (int m = 0; m < limit; m++) {
			
			if (m % x == 0 || m % y == 0) {
				
				sum += m;
			}
		}
		
		
		System.out.println("The sum of all multiples of " + x + " and " + y + " less than " + limit + " is " + sum + ".");
		
	}
	
	
	public void testFunctions() {
		primes(0, 234923);
		multiples(1, 2, 5); 
		palindromicNumbers(14511541);
		palindromicNumbers(1);
		leapYears(20);
		multiples(3, 5, 2000);
	}
}