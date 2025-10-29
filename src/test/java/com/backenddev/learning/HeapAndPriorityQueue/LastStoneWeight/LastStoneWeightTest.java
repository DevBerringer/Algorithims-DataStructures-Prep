package com.backenddev.learning.HeapAndPriorityQueue.LastStoneWeight;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LastStoneWeight solution.
 */
public class LastStoneWeightTest {

    private LastStoneWeight lastStoneWeight;

    @BeforeEach
    public void setUp() {
        lastStoneWeight = new LastStoneWeight();
    }

    @Test
    public void testLastStoneWeight_BasicCase() {
        int[] stones = {2,7,4,1,8,1};
        int result = lastStoneWeight.lastStoneWeight(stones);
        assertEquals(1, result);
    }

    @Test
    public void testLastStoneWeight_AllSameWeight() {
        int[] stones = {1,1,1,1};
        int result = lastStoneWeight.lastStoneWeight(stones);
        assertEquals(0, result);
    }

    @Test
    public void testLastStoneWeight_SingleStone() {
        int[] stones = {1};
        int result = lastStoneWeight.lastStoneWeight(stones);
        assertEquals(1, result);
    }

    @Test
    public void testLastStoneWeight_TwoStones() {
        int[] stones = {1,2};
        int result = lastStoneWeight.lastStoneWeight(stones);
        assertEquals(1, result);
    }

    @Test
    public void testLastStoneWeight_NoStonesRemaining() {
        int[] stones = {1,1};
        int result = lastStoneWeight.lastStoneWeight(stones);
        assertEquals(0, result);
    }
}
