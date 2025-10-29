package com.backenddev.learning.HeapAndPriorityQueue.KthLargestElement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for KthLargestElement solution.
 */
public class KthLargestElementTest {

    private KthLargestElement kthLargestElement;

    @BeforeEach
    public void setUp() {
        kthLargestElement = new KthLargestElement();
    }

    @Test
    public void testFindKthLargest_BasicCase() {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int result = kthLargestElement.findKthLargest(nums, k);
        assertEquals(5, result);
    }

    @Test
    public void testFindKthLargest_KEqualsOne() {
        int[] nums = {3,2,1,5,6,4};
        int k = 1;
        int result = kthLargestElement.findKthLargest(nums, k);
        assertEquals(6, result);
    }

    @Test
    public void testFindKthLargest_KEqualsLength() {
        int[] nums = {3,2,1,5,6,4};
        int k = 6;
        int result = kthLargestElement.findKthLargest(nums, k);
        assertEquals(1, result);
    }

    @Test
    public void testFindKthLargest_SingleElement() {
        int[] nums = {1};
        int k = 1;
        int result = kthLargestElement.findKthLargest(nums, k);
        assertEquals(1, result);
    }

    @Test
    public void testFindKthLargest_DuplicateElements() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int result = kthLargestElement.findKthLargest(nums, k);
        assertEquals(4, result);
    }
}
