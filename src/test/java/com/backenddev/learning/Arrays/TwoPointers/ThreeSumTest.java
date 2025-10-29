package com.backenddev.learning.Arrays.TwoPointers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ThreeSum solution.
 */
public class ThreeSumTest {

    private ThreeSum threeSum;

    @BeforeEach
    public void setUp() {
        threeSum = new ThreeSum();
    }

    @Test
    public void testThreeSum_BasicCase() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(-1, -1, 2)));
        assertTrue(result.contains(Arrays.asList(-1, 0, 1)));
    }

    @Test
    public void testThreeSum_NoSolution() {
        int[] nums = {0, 1, 1};
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testThreeSum_EmptyArray() {
        int[] nums = {};
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testThreeSum_AllZeros() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList(0, 0, 0)));
    }
}
