package com.backenddev.learning.Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Solution for: Majority Element</h2>
 * <p>
 * This class finds the majority element in an integer array.
 * A majority element is one that appears more than {@code n / 2} times.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a {@link HashMap} to count occurrences of each number.</li>
 *   <li>Iterate through the map to find the element with count greater than {@code n / 2}.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n)</li>
 *   <li>Space complexity: O(n)</li>
 * </ul>
 */
public class MajorityElementFinder {

    /**
     * Finds the majority element in the given array.
     *
     * @param nums the input array of integers
     * @return the majority element if one exists; otherwise, {@code -1}
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> intMap = new HashMap<>();

        for (int num : nums) {
            intMap.merge(num, 1, Integer::sum);
        }

        int majorityCount = nums.length / 2;

        for (Map.Entry<Integer, Integer> entry : intMap.entrySet()) {
            if (entry.getValue() > majorityCount) {
                return entry.getKey();
            }
        }

        return -1;
    }

    /**
     * Main method to test the majorityElement operation.
     */
    public static void main(String[] args) {
        MajorityElementFinder finder = new MajorityElementFinder();
        int[] nums = {3, 3, 4, 2, 3, 3, 3};

        int result = finder.majorityElement(nums);
        System.out.println("Majority element: " + result);
    }
}
