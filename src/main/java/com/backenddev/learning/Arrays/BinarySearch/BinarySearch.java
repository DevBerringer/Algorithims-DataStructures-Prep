package com.backenddev.learning.Arrays.BinarySearch;

/**
 * <h2>Solution for: Binary Search.</h2>
 * <p>
 * This class provides a solution to find the index of a target element in a sorted array
 * using the binary search algorithm.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use two pointers (left and right) to define the search range.</li>
 *   <li>Calculate the middle index and compare the middle element with the target.</li>
 *   <li>If the middle element equals the target, return its index.</li>
 *   <li>If the middle element is less than the target, search the right half.</li>
 *   <li>If the middle element is greater than the target, search the left half.</li>
 *   <li>Continue until the target is found or the search range is exhausted.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(log n) where n is the length of the input array.</li>
 *   <li>Space complexity: O(1) as we only use a constant amount of extra space.</li>
 * </ul>
 */
public class BinarySearch {

    /**
     * Method to find the index of target element in a sorted array using binary search.
     *
     * @param nums the input sorted array of integers
     * @param target the target element to find
     * @return the index of the target element, or -1 if not found
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    /**
     * Main method to run the Binary Search solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        
        int result = binarySearch.search(nums, target);
        System.out.println("Target " + target + " found at index: " + result);
        
        // Test case where target is not found
        target = 2;
        result = binarySearch.search(nums, target);
        System.out.println("Target " + target + " found at index: " + result);
    }
}
