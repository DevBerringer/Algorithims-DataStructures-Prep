package com.backenddev.learning.MathAndBitManipulation.SingleNumber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for SingleNumber solution.
 */
public class SingleNumberTest {

    private SingleNumber singleNumber;

    @BeforeEach
    public void setUp() {
        singleNumber = new SingleNumber();
    }

    @Test
    public void testSingleNumber_BasicCase() {
        int[] nums = {2, 2, 1};
        int result = singleNumber.singleNumber(nums);
        assertEquals(1, result);
    }

    @Test
    public void testSingleNumber_AnotherCase() {
        int[] nums = {4, 1, 2, 1, 2};
        int result = singleNumber.singleNumber(nums);
        assertEquals(4, result);
    }

    @Test
    public void testSingleNumber_SingleElement() {
        int[] nums = {1};
        int result = singleNumber.singleNumber(nums);
        assertEquals(1, result);
    }

    @Test
    public void testSingleNumberWithHashMap_BasicCase() {
        int[] nums = {2, 2, 1};
        int result = singleNumber.singleNumberWithHashMap(nums);
        assertEquals(1, result);
    }

    @Test
    public void testSingleNumberWithHashSet_BasicCase() {
        int[] nums = {2, 2, 1};
        int result = singleNumber.singleNumberWithHashSet(nums);
        assertEquals(1, result);
    }

    @Test
    public void testSingleNumber_Consistency() {
        int[] nums = {4, 1, 2, 1, 2};
        
        int result1 = singleNumber.singleNumber(nums);
        int result2 = singleNumber.singleNumberWithHashMap(nums);
        int result3 = singleNumber.singleNumberWithHashSet(nums);
        
        assertEquals(result1, result2);
        assertEquals(result2, result3);
        assertEquals(4, result1);
    }

    @Test
    public void testSingleNumber_LargerArray() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = singleNumber.singleNumber(nums);
        assertEquals(10, result);
    }
}
