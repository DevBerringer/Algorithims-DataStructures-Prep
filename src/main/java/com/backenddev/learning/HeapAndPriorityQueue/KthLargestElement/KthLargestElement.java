package com.backenddev.learning.HeapAndPriorityQueue.KthLargestElement;

import java.util.PriorityQueue;

/**
 * <h2>Solution for: Kth Largest Element in an Array.</h2>
 * <p>
 * This class provides a solution to find the kth largest element in an unsorted array.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a min-heap (PriorityQueue) of size k to maintain the k largest elements.</li>
 *   <li>Iterate through the array and add elements to the heap.</li>
 *   <li>If the heap size exceeds k, remove the smallest element.</li>
 *   <li>The root of the heap will be the kth largest element.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n log k) where n is the number of elements and k is the parameter.</li>
 *   <li>Space complexity: O(k) for the min-heap.</li>
 * </ul>
 */
public class KthLargestElement {

    /**
     * Method to find the kth largest element in the array.
     *
     * @param nums the input array of integers
     * @param k the position of the largest element to find
     * @return the kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }
        return minHeap.peek();
    }

    /**
     * Main method to run the Kth Largest Element solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println("Kth Largest Element: " + result);
    }
}
