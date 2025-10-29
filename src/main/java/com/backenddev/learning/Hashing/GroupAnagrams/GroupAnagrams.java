package com.backenddev.learning.Hashing.GroupAnagrams;

import java.util.*;

/**
 * <h2>Solution for: Group Anagrams.</h2>
 * <p>
 * This class provides a solution to group anagrams together from a list of strings.
 * An anagram is a word formed by rearranging the letters of another word.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a HashMap where the key is the sorted version of each string.</li>
 *   <li>All anagrams will have the same sorted string as their key.</li>
 *   <li>Group strings with the same sorted key together in the map.</li>
 *   <li>Return all groups as a list of lists.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n * m log m) where n is the number of strings and m is the average length of strings.</li>
 *   <li>Space complexity: O(n * m) for storing the grouped anagrams.</li>
 * </ul>
 */
public class GroupAnagrams {

    /**
     * Method to group anagrams together.
     *
     * @param strs array of strings to group
     * @return list of groups where each group contains anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            // Sort the characters in the string to create a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);
            
            // Add the original string to the group with this key
            anagramGroups.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);
        }
        
        // Convert map values to list of lists
        return new ArrayList<>(anagramGroups.values());
    }

    /**
     * Alternative approach using character frequency counting (more efficient for very long strings).
     *
     * @param strs array of strings to group
     * @return list of groups where each group contains anagrams
     */
    public List<List<String>> groupAnagramsWithFrequency(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            // Create a frequency-based key
            String frequencyKey = getFrequencyKey(str);
            
            // Add the original string to the group with this key
            anagramGroups.computeIfAbsent(frequencyKey, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }

    /**
     * Helper method to create a frequency-based key for a string.
     *
     * @param str the input string
     * @return frequency-based key
     */
    private String getFrequencyKey(String str) {
        int[] frequency = new int[26]; // Assuming only lowercase letters
        
        for (char c : str.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            key.append(frequency[i]).append('#');
        }
        
        return key.toString();
    }

    /**
     * Main method to run the Group Anagrams solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        
        // Test case
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        List<List<String>> result = solution.groupAnagrams(strs);
        
        System.out.println("Grouped Anagrams:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Group " + (i + 1) + ": " + result.get(i));
        }
        
        // Test with frequency-based approach
        List<List<String>> result2 = solution.groupAnagramsWithFrequency(strs);
        System.out.println("\nGrouped Anagrams (Frequency-based):");
        for (int i = 0; i < result2.size(); i++) {
            System.out.println("Group " + (i + 1) + ": " + result2.get(i));
        }
    }
}
