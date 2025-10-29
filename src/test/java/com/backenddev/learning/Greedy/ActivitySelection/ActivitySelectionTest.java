package com.backenddev.learning.Greedy.ActivitySelection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ActivitySelection solution.
 */
public class ActivitySelectionTest {

    private ActivitySelection activitySelection;

    @BeforeEach
    public void setUp() {
        activitySelection = new ActivitySelection();
    }

    @Test
    public void testSelectActivities_BasicCase() {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] finishTimes = {2, 4, 6, 7, 9, 9};
        
        List<Integer> result = activitySelection.selectActivities(startTimes, finishTimes);
        assertEquals(4, result.size());
        assertTrue(result.contains(0)); // Activity 0
        assertTrue(result.contains(1)); // Activity 1
        assertTrue(result.contains(3)); // Activity 3
        assertTrue(result.contains(4)); // Activity 4
    }

    @Test
    public void testMaxActivities_BasicCase() {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] finishTimes = {2, 4, 6, 7, 9, 9};
        
        int result = activitySelection.maxActivities(startTimes, finishTimes);
        assertEquals(4, result);
    }

    @Test
    public void testSelectActivities_SingleActivity() {
        int[] startTimes = {1};
        int[] finishTimes = {2};
        
        List<Integer> result = activitySelection.selectActivities(startTimes, finishTimes);
        assertEquals(1, result.size());
        assertEquals(0, result.get(0));
    }

    @Test
    public void testSelectActivities_NoOverlap() {
        int[] startTimes = {1, 3, 5};
        int[] finishTimes = {2, 4, 6};
        
        List<Integer> result = activitySelection.selectActivities(startTimes, finishTimes);
        assertEquals(3, result.size());
    }

    @Test
    public void testSelectActivities_AllOverlap() {
        int[] startTimes = {1, 1, 1};
        int[] finishTimes = {3, 3, 3};
        
        List<Integer> result = activitySelection.selectActivities(startTimes, finishTimes);
        assertEquals(1, result.size());
    }

    @Test
    public void testSelectActivities_EmptyArrays() {
        int[] startTimes = {};
        int[] finishTimes = {};
        
        List<Integer> result = activitySelection.selectActivities(startTimes, finishTimes);
        assertTrue(result.isEmpty());
    }
}
