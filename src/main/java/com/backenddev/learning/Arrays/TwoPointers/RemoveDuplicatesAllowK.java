package com.backenddev.learning.Arrays.TwoPointers;

/**
 * <h2>Solution for: Remove Duplicates from Sorted Array II</h2>
 * <p>
 * This class removes duplicates from a sorted array in-place,
 * allowing each element to appear at most k times.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use two pointers: one for reading (`j`) and one for writing (`i`).</li>
 *   <li>Only write when the current element is not equal to the element k positions behind.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n)</li>
 *   <li>Space complexity: O(1)</li>
 * </ul>
 */
public class RemoveDuplicatesAllowK {

    /**
     * Removes duplicates from a sorted array, allowing each element at most k times.
     *
     * @param nums the sorted input array
     * @return the number of valid elements after removal
     */
    public int removeDuplicates(int[] nums) {
        int k = 2;
        return nums.length <= k ? nums.length : removeOnlyAfterKValues(nums, k);
    }

    /**
     * Helper method to remove duplicates beyond k occurrences.
     *
     * @param nums the sorted input array
     * @param k    the allowed number of duplicates
     * @return the new length of the array
     */
    private int removeOnlyAfterKValues(int[] nums, int k) {
        int writeIndex = k - 1;

        for (int readIndex = k; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - k + 1]) {
                nums[++writeIndex] = nums[readIndex];
            }
        }

        return writeIndex + 1;
    }

    /**
     * Main method to test the removeDuplicates operation.
     */
    public static void main(String[] args) {
        RemoveDuplicatesAllowK remover = new RemoveDuplicatesAllowK();
        int[] nums = {1, 1, 1, 2, 2, 3};

        int newLength = remover.removeDuplicates(nums);
        System.out.print("Array after removing excess duplicates: [");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + (i < newLength - 1 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println("New length: " + newLength);
    }
}
