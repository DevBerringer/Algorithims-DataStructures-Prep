package com.backenddev.learning.Arrays.TwoPointers;

/**
 * <h2>Solution for: Remove Element</h2>
 * <p>
 * This class provides an in-place solution to remove all instances of a given value from an array.
 * The relative order of elements may change, but the first k elements of the array will contain the result.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a right pointer to overwrite elements that are not equal to the target value.</li>
 *   <li>Iterate through the array and copy valid elements to the front.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n)</li>
 *   <li>Space complexity: O(1)</li>
 * </ul>
 */
public class RemoveElement {

    /**
     * Removes all instances of val from nums in-place.
     *
     * @param nums the input array
     * @param val  the value to remove
     * @return the new length of the array after removal
     */
    public int removeElement(int[] nums, int val) {
        int writeIndex = 0;

        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != val) {
                nums[writeIndex++] = nums[readIndex];
            }
        }

        return writeIndex;
    }

    /**
     * Main method to test the removeElement operation.
     */
    public static void main(String[] args) {
        RemoveElement remover = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 2;

        int newLength = remover.removeElement(nums, val);
        System.out.print("Array after removal: [");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + (i < newLength - 1 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println("New length: " + newLength);
    }
}
