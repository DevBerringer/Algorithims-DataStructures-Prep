package com.backenddev.learning.TwoPointers.ContainerWithMostWater;

/**
 * <h2>Solution for: Container With Most Water.</h2>
 * <p>
 * This class provides a solution to find two lines that together with the x-axis
 * forms a container that holds the most water. Given an array of heights representing
 * vertical lines, find the maximum area of water that can be contained.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use two pointers technique: start from both ends of the array.</li>
 *   <li>Calculate the area using the shorter of the two heights and the distance between them.</li>
 *   <li>Move the pointer pointing to the shorter height inward.</li>
 *   <li>Continue until the pointers meet, keeping track of the maximum area.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the length of the input array.</li>
 *   <li>Space complexity: O(1) as we only use a constant amount of extra space.</li>
 * </ul>
 */
public class ContainerWithMostWater {

    /**
     * Method to find the maximum area of water that can be contained.
     *
     * @param height array of heights representing vertical lines
     * @return the maximum area of water that can be contained
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate current area
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

    /**
     * Method to find the maximum area and also return the indices of the two lines.
     *
     * @param height array of heights representing vertical lines
     * @return array containing [maxArea, leftIndex, rightIndex]
     */
    public int[] maxAreaWithIndices(int[] height) {
        if (height == null || height.length < 2) {
            return new int[]{0, -1, -1};
        }
        
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int bestLeft = 0;
        int bestRight = height.length - 1;
        
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            
            if (currentArea > maxArea) {
                maxArea = currentArea;
                bestLeft = left;
                bestRight = right;
            }
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{maxArea, bestLeft, bestRight};
    }

    /**
     * Alternative brute force approach (for comparison).
     * This method has O(n^2) time complexity.
     *
     * @param height array of heights representing vertical lines
     * @return the maximum area of water that can be contained
     */
    public int maxAreaBruteForce(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        
        int maxArea = 0;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currentArea = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        
        return maxArea;
    }

    /**
     * Method to visualize the container with most water.
     *
     * @param height array of heights
     */
    public void visualizeContainer(int[] height) {
        int[] result = maxAreaWithIndices(height);
        int maxArea = result[0];
        int leftIndex = result[1];
        int rightIndex = result[2];
        
        System.out.println("Container with most water:");
        System.out.println("Left line: index " + leftIndex + ", height " + height[leftIndex]);
        System.out.println("Right line: index " + rightIndex + ", height " + height[rightIndex]);
        System.out.println("Max area: " + maxArea);
        
        // Visual representation
        int maxHeight = Math.max(height[leftIndex], height[rightIndex]);
        System.out.println("\nVisual representation:");
        
        for (int h = maxHeight; h >= 0; h--) {
            System.out.print(h + " ");
            for (int i = 0; i < height.length; i++) {
                if (i == leftIndex || i == rightIndex) {
                    if (height[i] >= h) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                } else if (i > leftIndex && i < rightIndex && h <= Math.min(height[leftIndex], height[rightIndex])) {
                    System.out.print("~"); // Water
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        System.out.print("  ");
        for (int i = 0; i < height.length; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

    /**
     * Method to calculate the area between two specific indices.
     *
     * @param height array of heights
     * @param left left index
     * @param right right index
     * @return area between the two indices
     */
    public int calculateArea(int[] height, int left, int right) {
        if (left >= right || left < 0 || right >= height.length) {
            return 0;
        }
        return Math.min(height[left], height[right]) * (right - left);
    }

    /**
     * Main method to run the Container With Most Water solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        // Test case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Height array: " + java.util.Arrays.toString(height1));
        
        int maxArea1 = solution.maxArea(height1);
        System.out.println("Maximum area: " + maxArea1);
        solution.visualizeContainer(height1);
        System.out.println();
        
        // Test case 2
        int[] height2 = {1, 1};
        System.out.println("Height array: " + java.util.Arrays.toString(height2));
        
        int maxArea2 = solution.maxArea(height2);
        System.out.println("Maximum area: " + maxArea2);
        System.out.println();
        
        // Test case 3
        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println("Height array: " + java.util.Arrays.toString(height3));
        
        int maxArea3 = solution.maxArea(height3);
        System.out.println("Maximum area: " + maxArea3);
        solution.visualizeContainer(height3);
        System.out.println();
        
        // Compare with brute force
        System.out.println("Comparison with brute force:");
        int bruteForceResult = solution.maxAreaBruteForce(height1);
        System.out.println("Two pointers result: " + maxArea1);
        System.out.println("Brute force result: " + bruteForceResult);
        System.out.println("Results match: " + (maxArea1 == bruteForceResult));
    }
}
