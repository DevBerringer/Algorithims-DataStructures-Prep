package com.backenddev.learning.Arrays.Hashing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TwoSum solution.
 */
public class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    public void setUp() {
        twoSum = new TwoSum();
    }

    @Test
    public void testTwoSum_BasicCase() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testTwoSum_NoSolution() {
        int[] nums = {2, 7, 11, 15};
        int target = 100;
        assertThrows(IllegalArgumentException.class, () -> {
            twoSum.twoSum(nums, target);
        });
    }

    @Test
    public void testTwoSum_SameElementTwice() {
        int[] nums = {3, 3};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testTwoSum_NegativeNumbers() {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] result = twoSum.twoSum(nums, target);
        assertArrayEquals(new int[]{2, 4}, result);
    }
}
