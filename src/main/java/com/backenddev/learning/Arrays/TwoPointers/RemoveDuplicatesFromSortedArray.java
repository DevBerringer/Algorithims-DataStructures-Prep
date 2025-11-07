package com.backenddev.learning.Arrays.TwoPointers;

/**
 * <h2>Solution for: Remove Duplicates from Sorted Array</h2>
 * <p>
 * This class provides an in-place solution to remove duplicates from a sorted array.
 * The goal is to return the length of the array after duplicates are removed,
 * with the first part of the array containing the unique elements.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use two pointers: one for reading (`j`) and one for writing (`i`).</li>
 *   <li>Only write when a new unique element is found.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n)</li>
 *   <li>Space complexity: O(1)</li>
 * </ul>
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Removes duplicates from a sorted array in-place.
     *
     * @param nums the sorted input array
     * @return the number of unique elements
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int writeIndex = 0;

        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex]) {
                nums[++writeIndex] = nums[readIndex];
            }
        }

        return writeIndex + 1;
    }

    /**
     * Main method to test the removeDuplicates operation.
     */
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray remover = new RemoveDuplicatesFromSortedArray();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int newLength = remover.removeDuplicates(nums);
        System.out.print("Array after removing duplicates: [");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + (i < newLength - 1 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println("New length: " + newLength);
    }
}