package com.backenddev.learning.Strings;

import java.util.HashSet;
import java.util.Set;

public class B_LongestSubStringWithoutRepeating {

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
     * Main method to run the Ransom Note check.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        B_LongestSubStringWithoutRepeating ransomNoteObj = new B_LongestSubStringWithoutRepeating();
        String s = "abcabcbbasdfqwerzxcv";
        int result = ransomNoteObj.lengthOfLongestSubstring(s);
        System.out.println("output: " + result);  // Should return true
    }
}
