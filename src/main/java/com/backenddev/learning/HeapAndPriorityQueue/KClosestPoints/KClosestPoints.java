package com.backenddev.learning.HeapAndPriorityQueue.KClosestPoints;

import java.util.PriorityQueue;

/**
 * <h2>Solution for: K Closest Points to Origin.</h2>
 * <p>
 * This class provides a solution to find the k closest points to the origin (0,0).
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a max-heap (PriorityQueue) to maintain the k closest points.</li>
 *   <li>Calculate the distance from each point to the origin.</li>
 *   <li>Add points to the heap and remove the farthest point if heap size exceeds k.</li>
 *   <li>The remaining points in the heap are the k closest points.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n log k) where n is the number of points and k is the parameter.</li>
 *   <li>Space complexity: O(k) for the max-heap.</li>
 * </ul>
 */
public class KClosestPoints {

    /**
     * Method to find the k closest points to the origin.
     *
     * @param points the input array of 2D points
     * @param k the number of closest points to return
     * @return an array containing the k closest points to the origin
     */
    public int[][] kClosest(int[][] points, int k) {
        // Custom comparator to sort based on distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distB, distA); // Max-heap
        });

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest point
            }
        }

        // Convert the heap to an array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    /**
     * Main method to run the K Closest Points to Origin solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KClosestPoints solution = new KClosestPoints();
        int[][] points = {{1,2},{2,2},{3,3},{4,4}};
        int[][] result = solution.kClosest(points, 2);
        System.out.println("K Closest Points:");
        for (int[] point : result) {
            System.out.println("Point: (" + point[0] + ", " + point[1] + ")");
        }
    }
}
