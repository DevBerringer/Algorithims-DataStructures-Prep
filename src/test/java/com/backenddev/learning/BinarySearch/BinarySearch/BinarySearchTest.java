package com.backenddev.learning.BinarySearch.BinarySearch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for BinarySearch solution.
 */
public class BinarySearchTest {

    private BinarySearch binarySearch;

    @BeforeEach
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testSearch_TargetExists() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int result = binarySearch.search(nums, target);
        assertEquals(4, result);
    }

    @Test
    public void testSearch_TargetNotExists() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int result = binarySearch.search(nums, target);
        assertEquals(-1, result);
    }

    @Test
    public void testSearch_SingleElement() {
        int[] nums = {5};
        int target = 5;
        int result = binarySearch.search(nums, target);
        assertEquals(0, result);
    }

    @Test
    public void testSearch_EmptyArray() {
        int[] nums = {};
        int target = 1;
        int result = binarySearch.search(nums, target);
        assertEquals(-1, result);
    }

    @Test
    public void testSearch_FirstElement() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 1;
        int result = binarySearch.search(nums, target);
        assertEquals(0, result);
    }

    @Test
    public void testSearch_LastElement() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int result = binarySearch.search(nums, target);
        assertEquals(4, result);
    }
}
