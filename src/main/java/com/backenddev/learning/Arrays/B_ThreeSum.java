package com.backenddev.learning.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Solution for: 3Sum.
 * <p>
 * This class provides a solution to the problem where given an array of integers,
 * we need to find all unique triplets in the array that sum up to zero.
 * </p>
 * <p>
 * Approach:
 * </p>
 * <ul>
 *   <li>Sort the array to easily find pairs that sum up to the target (0 in this case).</li>
 *   <li>Use a two-pointer approach to find pairs that sum up to the target with each element.</li>
 *   <li>Skip duplicates to ensure unique triplets.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n^2) where n is the length of the input array, due to sorting and the two-pointer traversal.</li>
 *   <li>Space complexity: O(1) if we disregard the space used by the output list.</li>
 * </ul>
 */
public class B_ThreeSum {

    /**
     * Method to find all unique triplets in the array that sum up to zero.
     *
     * @param nums the input array of integers
     * @return a list of unique triplets that sum up to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicates
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * Main method to run the Three Sum solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        B_ThreeSum threeSum = new B_ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println("Unique triplets: " + result);
    }
}
