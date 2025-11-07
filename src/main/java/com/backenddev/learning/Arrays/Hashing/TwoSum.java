package com.backenddev.learning.Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Solution for: Two Sum</h2>
 * <p>
 * This class provides a solution to the problem where, given an array of integers,
 * we need to find two indices such that their values sum up to a target.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a HashMap to store previously seen numbers and their indices.</li>
 *   <li>For each number, check if its complement (target - number) exists in the map.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n)</li>
 *   <li>Space complexity: O(n)</li>
 * </ul>
 */
public class TwoSum {

    /**
     * Method to find two indices in the array such that the numbers at those indices add up to the target.
     *
     * @param nums the input array of integers
     * @param target the input target sum
     * @return an integer array of the indexes that sum to the target
     * @throws IllegalArgumentException if no solution is found
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intmap = new HashMap<>();
        for (int x = 0; x < nums.length; x++) {
            if (intmap.containsKey(target - nums[x])) {
                return new int[]{intmap.get(target - nums[x]), x};
            }
            intmap.put(nums[x], x);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Main method to run the Two Sum solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum.twoSum(nums, target);

        System.out.println("Indices of the two numbers are: [" + result[0] + ", " + result[1] + "]");
    }
}
