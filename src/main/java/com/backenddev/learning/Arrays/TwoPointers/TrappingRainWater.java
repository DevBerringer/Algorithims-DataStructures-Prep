package com.backenddev.learning.Arrays.TwoPointers;

/**
 * <h2> Solution for: Trapping Rain Water. </h2>
 * <p>
 * This class provides a solution to the problem where given an array representing the height of bars,
 * we need to calculate how much water can be trapped between the bars after raining.
 * </p>
 * <p>
 * <h5>Approach:</h5>
 * </p>
 * <ul>
 *   <li>Use two stacks to store the indices of the bars while traversing the array.</li>
 *   <li>Calculate the amount of water trapped by considering the current height of the bars and the smallest of the highest bars to the left and right.</li>
 *   <li>We compute the trapped water at each index based on the minimum of the highest bars on the left and right minus the height at the current index.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the length of the input array.</li>
 *   <li>Space complexity: O(n) due to the use of a stack to store the indices.</li>
 * </ul>
 */
public class TrappingRainWater {

    /**
     * Method to calculate the total amount of water trapped after raining.
     *
     * @param height the input array representing the heights of the bars
     * @return the total amount of water trapped
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int water = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    /**
     * Main method to run the Trapping Rain Water solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TrappingRainWater trap = new TrappingRainWater();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap.trap(height);

        System.out.println("Amount of water trapped: " + result);
    }
}
