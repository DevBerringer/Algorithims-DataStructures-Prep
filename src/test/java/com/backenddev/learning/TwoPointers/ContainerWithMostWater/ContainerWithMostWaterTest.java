package com.backenddev.learning.TwoPointers.ContainerWithMostWater;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ContainerWithMostWater solution.
 */
public class ContainerWithMostWaterTest {

    private ContainerWithMostWater containerWithMostWater;

    @BeforeEach
    public void setUp() {
        containerWithMostWater = new ContainerWithMostWater();
    }

    @Test
    public void testMaxArea_BasicCase() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = containerWithMostWater.maxArea(height);
        assertEquals(49, result);
    }

    @Test
    public void testMaxArea_SingleElement() {
        int[] height = {1};
        int result = containerWithMostWater.maxArea(height);
        assertEquals(0, result);
    }

    @Test
    public void testMaxArea_TwoElements() {
        int[] height = {1, 1};
        int result = containerWithMostWater.maxArea(height);
        assertEquals(1, result);
    }

    @Test
    public void testMaxArea_IncreasingHeights() {
        int[] height = {1, 2, 3, 4, 5};
        int result = containerWithMostWater.maxArea(height);
        assertEquals(6, result);
    }

    @Test
    public void testMaxArea_DecreasingHeights() {
        int[] height = {5, 4, 3, 2, 1};
        int result = containerWithMostWater.maxArea(height);
        assertEquals(6, result);
    }

    @Test
    public void testMaxArea_AllSameHeight() {
        int[] height = {3, 3, 3, 3};
        int result = containerWithMostWater.maxArea(height);
        assertEquals(9, result);
    }

    @Test
    public void testMaxAreaWithIndices_BasicCase() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] result = containerWithMostWater.maxAreaWithIndices(height);
        
        assertEquals(49, result[0]); // max area
        assertTrue(result[1] >= 0 && result[1] < height.length); // valid left index
        assertTrue(result[2] >= 0 && result[2] < height.length); // valid right index
        assertTrue(result[1] < result[2]); // left index < right index
    }

    @Test
    public void testMaxAreaBruteForce_BasicCase() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = containerWithMostWater.maxAreaBruteForce(height);
        assertEquals(49, result);
    }

    @Test
    public void testMaxArea_Consistency() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        int twoPointersResult = containerWithMostWater.maxArea(height);
        int bruteForceResult = containerWithMostWater.maxAreaBruteForce(height);
        
        assertEquals(twoPointersResult, bruteForceResult);
    }

    @Test
    public void testCalculateArea_SpecificIndices() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        int area1 = containerWithMostWater.calculateArea(height, 1, 8);
        assertEquals(49, area1);
        
        int area2 = containerWithMostWater.calculateArea(height, 0, 1);
        assertEquals(1, area2);
        
        int area3 = containerWithMostWater.calculateArea(height, 2, 3);
        assertEquals(2, area3);
    }

    @Test
    public void testMaxArea_EmptyArray() {
        int[] height = {};
        int result = containerWithMostWater.maxArea(height);
        assertEquals(0, result);
    }

    @Test
    public void testMaxArea_NullArray() {
        int[] height = null;
        int result = containerWithMostWater.maxArea(height);
        assertEquals(0, result);
    }
}
