package com.backenddev.learning.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Method to find two sum
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

    // Main method to run the solution
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        // Example input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Run the twoSum method
        int[] result = twoSum.twoSum(nums, target);

        // Output the result
        System.out.println("Indices of the two numbers are: [" + result[0] + ", " + result[1] + "]");
    }
}
