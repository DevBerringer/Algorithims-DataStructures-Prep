package com.backenddev.learning.Strings.Hashing;

import java.util.HashMap;

/**
 * <h2>Solution for: Isomorphic Strings.</h2>
 * <p>
 * This class provides a solution to determine if two strings are isomorphic.
 * Two strings are isomorphic if there is a one-to-one character mapping between the two strings.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use two HashMaps to track the character mappings between the two strings.</li>
 *   <li>Iterate through both strings and ensure that each character in one string maps uniquely to the other string.</li>
 *   <li>If any conflict arises in the mappings, return false.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the length of the input strings. We only iterate once over the strings.</li>
 *   <li>Space complexity: O(n) where n is the number of characters in the input strings. We use two HashMaps to store the mappings.</li>
 * </ul>
 */
public class IsomorphicStrings {

    /**
     * Method to check if two strings are isomorphic.
     * <p>
     * This method checks whether two strings can be transformed into each other by a one-to-one character mapping.
     * </p>
     *
     * @param s the first input string
     * @param t the second input string
     * @return true if the strings are isomorphic, false otherwise
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> charMapS = new HashMap<>();
        HashMap<Character, Character> charMapT = new HashMap<>();

        for (int x = 0; x < s.length(); x++) {
            char c1 = t.charAt(x);
            char c2 = s.charAt(x);

            if (charMapS.containsKey(c1)) {
                if (charMapS.get(c1) != c2) {
                    return false;
                }
            } else {
                charMapS.put(c1, c2);
            }
            if (charMapT.containsKey(c2)) {
                if (charMapT.get(c2) != c1) {
                    return false;
                }
            } else {
                charMapT.put(c2, c1);
            }
        }

        return true;
    }

    /**
     * Main method to test the Isomorphic Strings solution.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        String t = "foof";
        String s = "qppq";
        boolean result = isomorphicStrings.isIsomorphic(t, s);
        System.out.println("Can construct: " + result);
    }
}
