package com.backenddev.learning.Arrays.TwoPointers;

/**
 * <h2>Solution for: Rotate Array.</h2>
 * <p>
 * Given an integer array {@code nums}, rotate the array to the right by {@code k} steps,
 * where {@code k} is non-negative.
 * </p>
 *
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use array reversal to rotate the array in-place.</li>
 *   <li>First, reverse the entire array.</li>
 *   <li>Then, reverse the first {@code k} elements and finally reverse the remaining elements.</li>
 * </ul>
 *
 * <h5>Example:</h5>
 * <pre>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * </pre>
 *
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n)</li>
 *   <li>Space complexity: O(1)</li>
 * </ul>
 *
 * <h5>Tags:</h5>
 * Arrays, Two Pointers, In-Place Manipulation
 */
public class RotateArray {

    /**
     * Rotates the given array {@code nums} to the right by {@code k} steps.
     *
     * @param nums the array to rotate
     * @param k    number of steps to rotate
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k % nums.length == 0) {
            return;
        }

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     * Helper method to reverse elements in the array from {@code start} to {@code end}.
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Example usage.
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        System.out.print("Rotated Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
