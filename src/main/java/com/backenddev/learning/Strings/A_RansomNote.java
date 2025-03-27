package com.backenddev.learning.Strings;

import java.util.HashMap;

/**
 * <h2>Solution for: Ransom Note.</h2>
 * <p>
 * This class provides a solution to determine if a ransom note can be constructed from a magazine.
 * The ransom note is made up of characters that may appear multiple times in the magazine.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Count the frequency of each character in the magazine using a HashMap.</li>
 *   <li>For each character in the ransom note, check if it exists in the magazine with enough frequency.</li>
 *   <li>If any character is missing or there are not enough characters to match, return false.</li>
 *   <li>If all characters in the ransom note can be constructed from the magazine, return true.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(m + n) where m is the length of the magazine and n is the length of the ransom note. We iterate through both strings once.</li>
 *   <li>Space complexity: O(m) where m is the number of characters in the magazine. We store the character counts in a HashMap.</li>
 * </ul>
 */
public class A_RansomNote {

    /**
     * Method to check if the ransom note can be constructed from the magazine.
     *
     * @param ransomNote the string representing the ransom note
     * @param magazine   the string representing the magazine
     * @return true if the ransom note can be constructed, false otherwise
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<>();

        // Count the frequency of each character in the magazine
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        // Check if each character in the ransom note can be constructed from the magazine
        for (char c : ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c) || magazineMap.get(c) == 0) {
                return false;  // If the character is missing or used up
            }
            magazineMap.put(c, magazineMap.get(c) - 1);  // Use up the character
        }

        return true;
    }

    /**
     * Main method to run the Ransom Note check.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A_RansomNote ransomNoteObj = new A_RansomNote();
        String ransomNote = "foo test";  // The ransom note to be constructed
        String magazine = "foo test note";  // The magazine containing the characters

        boolean result = ransomNoteObj.canConstruct(ransomNote, magazine);
        System.out.println("Can construct: " + result);  // Should return true
    }
}
