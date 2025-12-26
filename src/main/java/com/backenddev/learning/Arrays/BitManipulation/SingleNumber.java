package com.backenddev.learning.Arrays.BitManipulation;

/**
 * <h2>Solution for: Single Number.</h2>
 * <p>
 * This class provides a solution to find the single number that appears only once in an array
 * where every other number appears exactly twice.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use the XOR (exclusive OR) bitwise operation.</li>
 *   <li>XOR has the property that: a ^ a = 0 and a ^ 0 = a.</li>
 *   <li>When we XOR all numbers in the array, pairs will cancel out (a ^ a = 0).</li>
 *   <li>The single number will remain as it has no pair to cancel with.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the length of the input array.</li>
 *   <li>Space complexity: O(1) as we only use a constant amount of extra space.</li>
 * </ul>
 */
public class SingleNumber {

    /**
     * Method to find the single number using XOR operation.
     *
     * @param nums array of integers where every number appears twice except one
     * @return the single number that appears only once
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // XOR all numbers in the array
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }

    /**
     * Alternative method using HashMap (less efficient but easier to understand).
     *
     * @param nums array of integers
     * @return the single number that appears only once
     */
    public int singleNumberWithHashMap(int[] nums) {
        java.util.HashMap<Integer, Integer> countMap = new java.util.HashMap<>();
        
        // Count occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Find the number with count 1
        for (int num : nums) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        
        return -1; // Should not reach here given the problem constraints
    }

    /**
     * Method to find single number using HashSet (another alternative approach).
     *
     * @param nums array of integers
     * @return the single number that appears only once
     */
    public int singleNumberWithHashSet(int[] nums) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        
        // The remaining element in the set is our answer
        return set.iterator().next();
    }

    /**
     * Main method to run the Single Number solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        
        // Test case 1
        int[] nums1 = {2, 2, 1};
        int result1 = solution.singleNumber(nums1);
        System.out.println("Single number in [2, 2, 1]: " + result1);
        
        // Test case 2
        int[] nums2 = {4, 1, 2, 1, 2};
        int result2 = solution.singleNumber(nums2);
        System.out.println("Single number in [4, 1, 2, 1, 2]: " + result2);
        
        // Test case 3
        int[] nums3 = {1};
        int result3 = solution.singleNumber(nums3);
        System.out.println("Single number in [1]: " + result3);
        
        // Demonstrate XOR properties
        System.out.println("\nXOR Properties Demonstration:");
        System.out.println("5 ^ 5 = " + (5 ^ 5)); // Should be 0
        System.out.println("5 ^ 0 = " + (5 ^ 0)); // Should be 5
        System.out.println("5 ^ 3 ^ 5 = " + (5 ^ 3 ^ 5)); // Should be 3
    }
}
