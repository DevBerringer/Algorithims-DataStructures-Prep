package com.backenddev.learning.HeapAndPriorityQueue.KClosestPoints;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for KClosestPoints solution.
 */
public class KClosestPointsTest {

    private KClosestPoints kClosestPoints;

    @BeforeEach
    public void setUp() {
        kClosestPoints = new KClosestPoints();
    }

    @Test
    public void testKClosest_BasicCase() {
        int[][] points = {{1,1},{2,2},{3,3}};
        int k = 2;
        int[][] result = kClosestPoints.kClosest(points, k);
        assertEquals(2, result.length);
    }

    @Test
    public void testKClosest_SinglePoint() {
        int[][] points = {{1,1}};
        int k = 1;
        int[][] result = kClosestPoints.kClosest(points, k);
        assertEquals(1, result.length);
        assertArrayEquals(new int[]{1,1}, result[0]);
    }

    @Test
    public void testKClosest_KEqualsLength() {
        int[][] points = {{1,1},{2,2}};
        int k = 2;
        int[][] result = kClosestPoints.kClosest(points, k);
        assertEquals(2, result.length);
    }

    @Test
    public void testKClosest_OriginPoint() {
        int[][] points = {{0,0},{1,1},{2,2}};
        int k = 1;
        int[][] result = kClosestPoints.kClosest(points, k);
        assertEquals(1, result.length);
        assertArrayEquals(new int[]{0,0}, result[0]);
    }
}
