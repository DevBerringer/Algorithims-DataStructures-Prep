package com.backenddev.learning.Arrays.SlidingWindow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MaximumSumSubarray solution.
 */
public class MaximumSumSubarrayTest {

    private MaximumSumSubarray maximumSumSubarray;

    @BeforeEach
    public void setUp() {
        maximumSumSubarray = new MaximumSumSubarray();
    }

    @Test
    public void testMaxSubArray_BasicCase() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maximumSumSubarray.maxSubArray(nums);
        assertEquals(6, result);
    }

    @Test
    public void testMaxSubArray_SingleElement() {
        int[] nums = {1};
        int result = maximumSumSubarray.maxSubArray(nums);
        assertEquals(1, result);
    }

    @Test
    public void testMaxSubArray_AllPositive() {
        int[] nums = {5, 4, -1, 7, 8};
        int result = maximumSumSubarray.maxSubArray(nums);
        assertEquals(23, result);
    }

    @Test
    public void testMaxSubArray_AllNegative() {
        int[] nums = {-5, -4, -1, -7, -8};
        int result = maximumSumSubarray.maxSubArray(nums);
        assertEquals(-1, result);
    }

    @Test
    public void testMaxSubArray_Mixed() {
        int[] nums = {1, -3, 2, 1, -1};
        int result = maximumSumSubarray.maxSubArray(nums);
        assertEquals(3, result);
    }

    @Test
    public void testMaxSubArrayWithIndices_BasicCase() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maximumSumSubarray.maxSubArrayWithIndices(nums);
        
        assertEquals(6, result[0]); // max sum
        assertEquals(3, result[1]);  // start index
        assertEquals(6, result[2]);  // end index
    }

    @Test
    public void testMaxSubArrayDivideConquer_BasicCase() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maximumSumSubarray.maxSubArrayDivideConquer(nums);
        assertEquals(6, result);
    }

    @Test
    public void testMaxSubArray_Consistency() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int kadaneResult = maximumSumSubarray.maxSubArray(nums);
        int dcResult = maximumSumSubarray.maxSubArrayDivideConquer(nums);
        
        assertEquals(kadaneResult, dcResult);
    }

    @Test
    public void testMaxSubArray_EmptyArray() {
        int[] nums = {};
        int result = maximumSumSubarray.maxSubArray(nums);
        assertEquals(0, result);
    }

    @Test
    public void testMaxSubArray_NullArray() {
        int[] nums = null;
        int result = maximumSumSubarray.maxSubArray(nums);
        assertEquals(0, result);
    }
}
