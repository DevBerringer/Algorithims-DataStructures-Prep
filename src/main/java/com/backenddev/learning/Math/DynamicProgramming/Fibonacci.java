package com.backenddev.learning.Math.DynamicProgramming;

/**
 * <h2>Solution for: Fibonacci Number.</h2>
 * <p>
 * This class provides a solution to calculate the nth Fibonacci number using dynamic programming.
 * The Fibonacci sequence is defined as: F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) for n > 1.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use dynamic programming with memoization to avoid recalculating the same values.</li>
 *   <li>Start with base cases: F(0) = 0 and F(1) = 1.</li>
 *   <li>For each subsequent number, calculate it as the sum of the previous two numbers.</li>
 *   <li>Store intermediate results to avoid redundant calculations.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the input number.</li>
 *   <li>Space complexity: O(1) as we only store the last two Fibonacci numbers.</li>
 * </ul>
 */
public class Fibonacci {

    /**
     * Method to calculate the nth Fibonacci number using dynamic programming.
     *
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    /**
     * Alternative recursive solution with memoization (for comparison).
     * This method demonstrates the recursive approach but is less efficient.
     *
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    /**
     * Main method to run the Fibonacci solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        
        // Test cases
        int[] testCases = {0, 1, 2, 3, 4, 5, 10};
        
        System.out.println("Fibonacci Numbers (Dynamic Programming):");
        for (int n : testCases) {
            int result = fibonacci.fib(n);
            System.out.println("F(" + n + ") = " + result);
        }
    }
}
