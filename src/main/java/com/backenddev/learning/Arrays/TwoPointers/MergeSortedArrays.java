package com.backenddev.learning.Arrays.TwoPointers;

/**
 * <h2>Solution for: Merge Sorted Arrays</h2>
 * <p>
 * This class provides an in-place solution to merge two sorted arrays into one.
 * The first array, nums1, has enough space to hold all elements from both arrays.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Start merging from the end to avoid overwriting elements in nums1.</li>
 *   <li>Use three pointers: one for nums1, one for nums2, and one for the merged position.</li>
 *   <li>Compare elements from the back and place the larger one at the end of nums1.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(m + n)</li>
 *   <li>Space complexity: O(1) — in-place merge</li>
 * </ul>
 */
public class MergeSortedArrays {

    /**
     * Merges two sorted arrays into nums1 in-place.
     *
     * @param nums1 the first sorted array with extra space at the end
     * @param m     the number of initialized elements in nums1
     * @param nums2 the second sorted array
     * @param n     the number of elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;         // Pointer for nums1
        int j = n - 1;         // Pointer for nums2
        int k = m + n - 1;     // Pointer for merged position

        while (j >= 0) {
            nums1[k--] = isNums1Greater(nums1, i, nums2, j) ? nums1[i--] : nums2[j--];
        }
    }

    /**
     * Helper method to compare elements safely.
     *
     * @param nums1  the first array
     * @param indexI index in nums1
     * @param nums2  the second array
     * @param indexJ index in nums2
     * @return true if nums1[indexI] > nums2[indexJ], false otherwise
     */
    private boolean isNums1Greater(int[] nums1, int indexI, int[] nums2, int indexJ) {
        return indexI >= 0 && nums1[indexI] > nums2[indexJ];
    }

    /**
     * Main method to test the merge operation.
     */
    public static void main(String[] args) {
        MergeSortedArrays merger = new MergeSortedArrays();
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        merger.merge(nums1, 3, nums2, 3);
        System.out.println("Merged array: " + java.util.Arrays.toString(nums1));
    }
}