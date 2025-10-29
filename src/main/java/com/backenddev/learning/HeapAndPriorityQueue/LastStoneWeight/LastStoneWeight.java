package com.backenddev.learning.HeapAndPriorityQueue.LastStoneWeight;

import java.util.PriorityQueue;

/**
 * <h2>Solution for: Last Stone Weight.</h2>
 * <p>
 * This class provides a solution to simulate the process of smashing stones together
 * until at most one stone remains.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a max-heap (PriorityQueue with reverse order) to store the stone weights.</li>
 *   <li>While there are at least two stones, remove the two heaviest stones.</li>
 *   <li>If they are not equal, add the difference back to the heap.</li>
 *   <li>Continue until at most one stone remains.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n log n) where n is the number of stones.</li>
 *   <li>Space complexity: O(n) for the max-heap.</li>
 * </ul>
 */
public class LastStoneWeight {

    /**
     * Method to find the weight of the last remaining stone.
     *
     * @param stones the input array of stone weights
     * @return the weight of the last remaining stone, or 0 if no stones remain
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int largest = maxHeap.poll();
            int nextLargest = maxHeap.poll();

            if (largest != nextLargest) {
                maxHeap.offer(largest - nextLargest);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    /**
     * Main method to run the Last Stone Weight solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();
        int[] stones = {2,7,4,1,8,1};
        int result = solution.lastStoneWeight(stones);
        System.out.println("Last Stone Weight: " + result);
    }
}
