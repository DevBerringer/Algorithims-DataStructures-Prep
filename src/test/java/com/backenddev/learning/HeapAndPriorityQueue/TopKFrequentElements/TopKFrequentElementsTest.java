package com.backenddev.learning.HeapAndPriorityQueue.TopKFrequentElements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TopKFrequentElements solution.
 */
public class TopKFrequentElementsTest {

    private TopKFrequentElements topKFrequentElements;

    @BeforeEach
    public void setUp() {
        topKFrequentElements = new TopKFrequentElements();
    }

    @Test
    public void testTopKFrequent_BasicCase() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequentElements.topKFrequent(nums, k);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void testTopKFrequent_SingleElement() {
        int[] nums = {1};
        int k = 1;
        int[] result = topKFrequentElements.topKFrequent(nums, k);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    public void testTopKFrequent_AllSameElements() {
        int[] nums = {1,1,1,1};
        int k = 1;
        int[] result = topKFrequentElements.topKFrequent(nums, k);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    public void testTopKFrequent_KEqualsLength() {
        int[] nums = {1,2,3};
        int k = 3;
        int[] result = topKFrequentElements.topKFrequent(nums, k);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }
}
