package com.backenddev.learning.Arrays.TwoPointers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TrappingRainWater solution.
 */
public class TrappingRainWaterTest {

    private TrappingRainWater trappingRainWater;

    @BeforeEach
    public void setUp() {
        trappingRainWater = new TrappingRainWater();
    }

    @Test
    public void testTrap_BasicCase() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trappingRainWater.trap(height);
        assertEquals(6, result);
    }

    @Test
    public void testTrap_EmptyArray() {
        int[] height = {};
        int result = trappingRainWater.trap(height);
        assertEquals(0, result);
    }

    @Test
    public void testTrap_NullArray() {
        int[] height = null;
        int result = trappingRainWater.trap(height);
        assertEquals(0, result);
    }

    @Test
    public void testTrap_NoTrapping() {
        int[] height = {1, 2, 3, 4, 5};
        int result = trappingRainWater.trap(height);
        assertEquals(0, result);
    }

    @Test
    public void testTrap_SingleElement() {
        int[] height = {5};
        int result = trappingRainWater.trap(height);
        assertEquals(0, result);
    }
}
