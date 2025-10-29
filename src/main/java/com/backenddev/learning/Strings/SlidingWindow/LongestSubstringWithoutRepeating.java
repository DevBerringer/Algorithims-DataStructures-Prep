package com.backenddev.learning.Strings.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * <h2>Solution for: Longest Substring Without Repeating Characters.</h2>
 * <p>
 * This class provides a solution to find the length of the longest substring without repeating characters.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a sliding window technique with two pointers.</li>
 *   <li>Use a HashSet to track characters in the current window.</li>
 *   <li>Expand the window by moving the right pointer and add characters to the set.</li>
 *   <li>When a duplicate is found, shrink the window by moving the left pointer and removing characters from the set.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the length of the string. Each character is visited at most twice.</li>
 *   <li>Space complexity: O(min(m,n)) where m is the size of the charset and n is the length of the string.</li>
 * </ul>
 */
public class LongestSubstringWithoutRepeating {

    /**
     * Method to find the length of the longest substring without repeating characters.
     *
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int longest = 0;
        int x = 0;
        int y = 0;

        while (y < s.length()) {
            char c = s.charAt(y);
            if (!seen.contains(c)) {
                seen.add(c);
                y++;
                longest = Math.max(longest, y - x);
            } else {
                seen.remove(s.charAt(x));
                x++;
            }
        }

        return longest;
    }

    /**
     * Main method to run the Longest Substring Without Repeating Characters solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();
        String s = "abcabcbbasdfqwerzxcv";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("output: " + result);
    }
}
