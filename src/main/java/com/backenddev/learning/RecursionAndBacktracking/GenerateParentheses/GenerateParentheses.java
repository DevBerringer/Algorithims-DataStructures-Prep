package com.backenddev.learning.RecursionAndBacktracking.GenerateParentheses;

import java.util.*;

/**
 * <h2>Solution for: Generate Parentheses.</h2>
 * <p>
 * This class provides a solution to generate all combinations of well-formed parentheses
 * given n pairs of parentheses.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use backtracking to generate all valid combinations.</li>
 *   <li>Keep track of the number of opening and closing parentheses used.</li>
 *   <li>Add opening parenthesis if we haven't used all n opening parentheses.</li>
 *   <li>Add closing parenthesis if it won't make the string invalid (more closing than opening).</li>
 *   <li>Base case: when we have used all n pairs, add the string to result.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(4^n / √n) - Catalan number complexity.</li>
 *   <li>Space complexity: O(4^n / √n) for storing all combinations.</li>
 * </ul>
 */
public class GenerateParentheses {

    /**
     * Method to generate all valid combinations of parentheses.
     *
     * @param n the number of pairs of parentheses
     * @return list of all valid combinations
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    /**
     * Backtracking helper method to generate parentheses combinations.
     *
     * @param result list to store valid combinations
     * @param current current string being built
     * @param openCount number of opening parentheses used
     * @param closeCount number of closing parentheses used
     * @param n total number of pairs needed
     */
    private void backtrack(List<String> result, String current, int openCount, int closeCount, int n) {
        // Base case: we have used all n pairs
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add opening parenthesis if we haven't used all n opening parentheses
        if (openCount < n) {
            backtrack(result, current + "(", openCount + 1, closeCount, n);
        }

        // Add closing parenthesis if it won't make the string invalid
        if (closeCount < openCount) {
            backtrack(result, current + ")", openCount, closeCount + 1, n);
        }
    }

    /**
     * Alternative iterative approach using queue (BFS-like).
     *
     * @param n the number of pairs of parentheses
     * @return list of all valid combinations
     */
    public List<String> generateParenthesisIterative(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> openCounts = new LinkedList<>();
        Queue<Integer> closeCounts = new LinkedList<>();

        queue.offer("");
        openCounts.offer(0);
        closeCounts.offer(0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int openCount = openCounts.poll();
            int closeCount = closeCounts.poll();

            if (current.length() == 2 * n) {
                result.add(current);
            } else {
                if (openCount < n) {
                    queue.offer(current + "(");
                    openCounts.offer(openCount + 1);
                    closeCounts.offer(closeCount);
                }
                if (closeCount < openCount) {
                    queue.offer(current + ")");
                    openCounts.offer(openCount);
                    closeCounts.offer(closeCount + 1);
                }
            }
        }

        return result;
    }

    /**
     * Method to validate if a string of parentheses is valid.
     *
     * @param s the string to validate
     * @return true if valid, false otherwise
     */
    public boolean isValidParentheses(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }

    /**
     * Main method to run the Generate Parentheses solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        
        // Test cases
        for (int n = 1; n <= 4; n++) {
            List<String> result = solution.generateParenthesis(n);
            System.out.println("n = " + n + ": " + result);
            System.out.println("Total combinations: " + result.size());
            
            // Validate all generated combinations
            for (String combo : result) {
                if (!solution.isValidParentheses(combo)) {
                    System.out.println("Invalid combination found: " + combo);
                }
            }
            System.out.println();
        }
        
        // Test iterative approach
        System.out.println("Iterative approach for n = 3:");
        List<String> iterativeResult = solution.generateParenthesisIterative(3);
        System.out.println(iterativeResult);
    }
}
