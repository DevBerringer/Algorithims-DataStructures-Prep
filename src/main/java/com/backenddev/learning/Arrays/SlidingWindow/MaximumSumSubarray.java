package com.backenddev.learning.Arrays.SlidingWindow;

/**
 * <h2>Solution for: Maximum Sum Subarray (Kadane's Algorithm).</h2>
 * <p>
 * This class provides a solution to find the contiguous subarray with maximum sum.
 * This is also known as Kadane's Algorithm.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use dynamic programming approach with sliding window concept.</li>
 *   <li>Keep track of the maximum sum ending at current position.</li>
 *   <li>At each position, decide whether to extend the previous subarray or start a new one.</li>
 *   <li>Update the global maximum whenever we find a better sum.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the length of the input array.</li>
 *   <li>Space complexity: O(1) as we only use a constant amount of extra space.</li>
 * </ul>
 */
public class MaximumSumSubarray {

    /**
     * Method to find the maximum sum of contiguous subarray using Kadane's algorithm.
     *
     * @param nums the input array of integers
     * @return the maximum sum of contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start a new one
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            // Update the global maximum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    /**
     * Method to find the maximum sum and also return the subarray indices.
     *
     * @param nums the input array of integers
     * @return array containing [maxSum, startIndex, endIndex]
     */
    public int[] maxSubArrayWithIndices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{0, -1, -1};
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = nums[i];
                tempStart = i;
            } else {
                maxEndingHere += nums[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{maxSoFar, start, end};
    }

    /**
     * Method to find maximum sum subarray using divide and conquer approach.
     *
     * @param nums the input array of integers
     * @return the maximum sum of contiguous subarray
     */
    public int maxSubArrayDivideConquer(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    /**
     * Helper method for divide and conquer approach.
     */
    private int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        // Maximum sum in left half
        int leftMax = maxSubArrayHelper(nums, left, mid);
        
        // Maximum sum in right half
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);
        
        // Maximum sum crossing the middle
        int crossMax = maxCrossingSum(nums, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    /**
     * Helper method to find maximum sum crossing the middle.
     */
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // Find maximum sum in left half including mid
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        // Find maximum sum in right half excluding mid
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    /**
     * Method to print the subarray with maximum sum.
     *
     * @param nums the input array
     */
    public void printMaxSubArray(int[] nums) {
        int[] result = maxSubArrayWithIndices(nums);
        int maxSum = result[0];
        int start = result[1];
        int end = result[2];

        System.out.print("Maximum sum subarray: [");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i]);
            if (i < end) {
                System.out.print(", ");
            }
        }
        System.out.println("] with sum = " + maxSum);
    }

    /**
     * Main method to run the Maximum Sum Subarray solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaximumSumSubarray solution = new MaximumSumSubarray();
        
        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Array: " + java.util.Arrays.toString(nums1));
        int maxSum1 = solution.maxSubArray(nums1);
        System.out.println("Maximum sum: " + maxSum1);
        solution.printMaxSubArray(nums1);
        System.out.println();
        
        // Test case 2
        int[] nums2 = {1};
        System.out.println("Array: " + java.util.Arrays.toString(nums2));
        int maxSum2 = solution.maxSubArray(nums2);
        System.out.println("Maximum sum: " + maxSum2);
        solution.printMaxSubArray(nums2);
        System.out.println();
        
        // Test case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Array: " + java.util.Arrays.toString(nums3));
        int maxSum3 = solution.maxSubArray(nums3);
        System.out.println("Maximum sum: " + maxSum3);
        solution.printMaxSubArray(nums3);
        
        // Test divide and conquer approach
        System.out.println("\nDivide and Conquer approach:");
        int dcResult = solution.maxSubArrayDivideConquer(nums1);
        System.out.println("Maximum sum (DC): " + dcResult);
    }
}
