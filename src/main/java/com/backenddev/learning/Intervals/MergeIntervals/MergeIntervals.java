package com.backenddev.learning.Intervals.MergeIntervals;

import java.util.*;

/**
 * <h2>Solution for: Merge Intervals.</h2>
 * <p>
 * This class provides a solution to merge overlapping intervals.
 * Given a collection of intervals, merge all overlapping intervals.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Sort intervals by their start times.</li>
 *   <li>Iterate through sorted intervals and merge overlapping ones.</li>
 *   <li>Two intervals overlap if the start of the second is less than or equal to the end of the first.</li>
 *   <li>When merging, take the minimum start and maximum end of the overlapping intervals.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n log n) where n is the number of intervals (due to sorting).</li>
 *   <li>Space complexity: O(1) excluding the output array.</li>
 * </ul>
 */
public class MergeIntervals {

    /**
     * Method to merge overlapping intervals.
     *
     * @param intervals array of intervals where each interval is represented as [start, end]
     * @return array of merged intervals
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // If intervals overlap, merge them
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * Method to merge intervals and return as a list of intervals.
     *
     * @param intervals list of intervals
     * @return list of merged intervals
     */
    public List<int[]> mergeIntervals(List<int[]> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        intervals.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals.get(0);
        merged.add(currentInterval);

        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // If intervals overlap, merge them
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged;
    }

    /**
     * Helper method to print intervals in a readable format.
     *
     * @param intervals array of intervals
     */
    public void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
            if (i < intervals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Main method to run the Merge Intervals solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        
        // Test case 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Original intervals:");
        solution.printIntervals(intervals1);
        
        int[][] merged1 = solution.merge(intervals1);
        System.out.println("Merged intervals:");
        solution.printIntervals(merged1);
        
        System.out.println();
        
        // Test case 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("Original intervals:");
        solution.printIntervals(intervals2);
        
        int[][] merged2 = solution.merge(intervals2);
        System.out.println("Merged intervals:");
        solution.printIntervals(merged2);
    }
}
