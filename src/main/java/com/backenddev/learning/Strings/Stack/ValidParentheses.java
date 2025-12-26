package com.backenddev.learning.Strings.Stack;

import java.util.*;

/**
 * <h2>Solution for: Valid Parentheses.</h2>
 * <p>
 * This class provides a solution to determine if a string containing only parentheses
 * is valid. A string is valid if every opening bracket has a corresponding closing bracket
 * of the same type and they are properly nested.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a stack to keep track of opening brackets.</li>
 *   <li>When encountering an opening bracket, push it onto the stack.</li>
 *   <li>When encountering a closing bracket, check if it matches the top of the stack.</li>
 *   <li>If it matches, pop from stack; if not, the string is invalid.</li>
 *   <li>At the end, the stack should be empty for a valid string.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the length of the input string.</li>
 *   <li>Space complexity: O(n) in the worst case for the stack.</li>
 * </ul>
 */
public class ValidParentheses {

    /**
     * Method to check if a string of parentheses is valid.
     *
     * @param s the input string containing only parentheses
     * @return true if the string is valid, false otherwise
     */
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // Push opening brackets onto the stack
                stack.push(c);
            } else {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Check if the closing bracket matches the opening bracket
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }
        
        // Stack should be empty for a valid string
        return stack.isEmpty();
    }

    /**
     * Helper method to check if opening and closing brackets match.
     *
     * @param open the opening bracket
     * @param close the closing bracket
     * @return true if they match, false otherwise
     */
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    /**
     * Alternative approach using HashMap for bracket mapping.
     *
     * @param s the input string containing only parentheses
     * @return true if the string is valid, false otherwise
     */
    public boolean isValidWithHashMap(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');

        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                // Closing bracket
                if (stack.isEmpty() || stack.pop() != bracketMap.get(c)) {
                    return false;
                }
            } else {
                // Opening bracket
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }

    /**
     * Method to generate all valid combinations of parentheses for given n.
     *
     * @param n the number of pairs of parentheses
     * @return list of all valid combinations
     */
    public List<String> generateValidParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateHelper(result, "", 0, 0, n);
        return result;
    }

    /**
     * Helper method for generating valid parentheses.
     */
    private void generateHelper(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generateHelper(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            generateHelper(result, current + ")", open, close + 1, n);
        }
    }

    /**
     * Method to find the length of the longest valid parentheses substring.
     *
     * @param s the input string
     * @return length of the longest valid parentheses substring
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }

    /**
     * Main method to run the Valid Parentheses solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        
        // Test cases
        String[] testCases = {
            "()",           // true
            "()[]{}",       // true
            "(]",           // false
            "([)]",         // false
            "{[]}",         // true
            "((()))",       // true
            "((())",        // false
            "))",           // false
            "",             // true
            "(((((())))))"  // true
        };
        
        System.out.println("Testing Valid Parentheses:");
        for (String testCase : testCases) {
            boolean result = solution.isValid(testCase);
            System.out.println("'" + testCase + "' -> " + result);
        }
        
        System.out.println("\nTesting with HashMap approach:");
        for (String testCase : testCases) {
            boolean result = solution.isValidWithHashMap(testCase);
            System.out.println("'" + testCase + "' -> " + result);
        }
        
        // Test longest valid parentheses
        System.out.println("\nTesting Longest Valid Parentheses:");
        String[] longestTestCases = {"(()", ")()())", "()(()", ""};
        for (String testCase : longestTestCases) {
            int length = solution.longestValidParentheses(testCase);
            System.out.println("'" + testCase + "' -> " + length);
        }
    }
}
