package com.backenddev.learning.Intervals.MergeIntervals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MergeIntervals solution.
 */
public class MergeIntervalsTest {

    private MergeIntervals mergeIntervals;

    @BeforeEach
    public void setUp() {
        mergeIntervals = new MergeIntervals();
    }

    @Test
    public void testMerge_BasicCase() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mergeIntervals.merge(intervals);
        
        assertEquals(3, result.length);
        assertArrayEquals(new int[]{1, 6}, result[0]);
        assertArrayEquals(new int[]{8, 10}, result[1]);
        assertArrayEquals(new int[]{15, 18}, result[2]);
    }

    @Test
    public void testMerge_AllOverlapping() {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] result = mergeIntervals.merge(intervals);
        
        assertEquals(1, result.length);
        assertArrayEquals(new int[]{1, 5}, result[0]);
    }

    @Test
    public void testMerge_NoOverlapping() {
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result = mergeIntervals.merge(intervals);
        
        assertEquals(3, result.length);
        assertArrayEquals(new int[]{1, 2}, result[0]);
        assertArrayEquals(new int[]{3, 4}, result[1]);
        assertArrayEquals(new int[]{5, 6}, result[2]);
    }

    @Test
    public void testMerge_SingleInterval() {
        int[][] intervals = {{1, 4}};
        int[][] result = mergeIntervals.merge(intervals);
        
        assertEquals(1, result.length);
        assertArrayEquals(new int[]{1, 4}, result[0]);
    }

    @Test
    public void testMerge_EmptyArray() {
        int[][] intervals = {};
        int[][] result = mergeIntervals.merge(intervals);
        
        assertEquals(0, result.length);
    }

    @Test
    public void testMerge_NullArray() {
        int[][] intervals = null;
        int[][] result = mergeIntervals.merge(intervals);
        
        assertNull(result);
    }

    @Test
    public void testMergeIntervals_ListVersion() {
        java.util.List<int[]> intervals = java.util.Arrays.asList(
            new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}
        );
        java.util.List<int[]> result = mergeIntervals.mergeIntervals(intervals);
        
        assertEquals(3, result.size());
        assertArrayEquals(new int[]{1, 6}, result.get(0));
        assertArrayEquals(new int[]{8, 10}, result.get(1));
        assertArrayEquals(new int[]{15, 18}, result.get(2));
    }
}
