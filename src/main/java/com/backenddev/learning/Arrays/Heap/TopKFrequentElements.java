package com.backenddev.learning.Arrays.Heap;

import java.util.*;

/**
 * <h2>Solution for: Top K Frequent Elements.</h2>
 * <p>
 * This class provides a solution to find the k most frequent elements in an array.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Count the frequency of each element using a HashMap.</li>
 *   <li>Use a min-heap (PriorityQueue) to maintain the k most frequent elements.</li>
 *   <li>Iterate through the frequency map and add elements to the heap.</li>
 *   <li>If the heap size exceeds k, remove the least frequent element.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n log k) where n is the number of elements and k is the parameter.</li>
 *   <li>Space complexity: O(n) for the HashMap and O(k) for the heap.</li>
 * </ul>
 */
public class TopKFrequentElements {

    /**
     * Method to find the k most frequent elements in the array.
     *
     * @param nums the input array of integers
     * @param k the number of most frequent elements to return
     * @return an array containing the k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> mapEn : map.entrySet()) {
            pq.add(mapEn);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            result[--k] = pq.poll().getKey();
        }
        return result;
    }

    /**
     * Main method to run the Top K Frequent Elements solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int[] result = solution.topKFrequent(nums, 2);
        System.out.println("Top K Frequent Elements: " + Arrays.toString(result));
    }
}
