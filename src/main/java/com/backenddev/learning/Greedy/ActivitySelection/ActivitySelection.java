package com.backenddev.learning.Greedy.ActivitySelection;

import java.util.*;

/**
 * <h2>Solution for: Activity Selection Problem.</h2>
 * <p>
 * This class provides a solution to the activity selection problem using a greedy algorithm.
 * Given a set of activities with start and finish times, select the maximum number of activities
 * that can be performed by a single person, assuming that a person can only work on one activity at a time.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Sort activities by their finish times in ascending order.</li>
 *   <li>Select the first activity (earliest finish time).</li>
 *   <li>For each subsequent activity, if its start time is greater than or equal to the finish time
 *       of the previously selected activity, select it.</li>
 *   <li>This greedy choice ensures maximum number of activities can be selected.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n log n) where n is the number of activities (due to sorting).</li>
 *   <li>Space complexity: O(1) excluding the input array.</li>
 * </ul>
 */
public class ActivitySelection {

    /**
     * Activity class to represent an activity with start and finish times.
     */
    public static class Activity {
        int start;
        int finish;
        int index; // Original index in the input array

        public Activity(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }
    }

    /**
     * Method to find the maximum number of activities that can be performed.
     *
     * @param startTimes array of start times
     * @param finishTimes array of finish times
     * @return list of indices of selected activities
     */
    public List<Integer> selectActivities(int[] startTimes, int[] finishTimes) {
        List<Activity> activities = new ArrayList<>();
        
        // Create activity objects
        for (int i = 0; i < startTimes.length; i++) {
            activities.add(new Activity(startTimes[i], finishTimes[i], i));
        }
        
        // Sort activities by finish time
        activities.sort(Comparator.comparingInt(a -> a.finish));
        
        List<Integer> selectedActivities = new ArrayList<>();
        
        if (activities.isEmpty()) {
            return selectedActivities;
        }
        
        // Select first activity
        selectedActivities.add(activities.get(0).index);
        int lastFinishTime = activities.get(0).finish;
        
        // Select remaining activities
        for (int i = 1; i < activities.size(); i++) {
            Activity current = activities.get(i);
            if (current.start >= lastFinishTime) {
                selectedActivities.add(current.index);
                lastFinishTime = current.finish;
            }
        }
        
        return selectedActivities;
    }

    /**
     * Method to get the count of maximum activities that can be performed.
     *
     * @param startTimes array of start times
     * @param finishTimes array of finish times
     * @return maximum number of activities
     */
    public int maxActivities(int[] startTimes, int[] finishTimes) {
        return selectActivities(startTimes, finishTimes).size();
    }

    /**
     * Main method to run the Activity Selection solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ActivitySelection solution = new ActivitySelection();
        
        // Test case
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] finishTimes = {2, 4, 6, 7, 9, 9};
        
        List<Integer> selected = solution.selectActivities(startTimes, finishTimes);
        int maxCount = solution.maxActivities(startTimes, finishTimes);
        
        System.out.println("Maximum number of activities: " + maxCount);
        System.out.println("Selected activity indices: " + selected);
        
        // Print selected activities with their times
        System.out.println("Selected activities:");
        for (int index : selected) {
            System.out.println("Activity " + index + ": [" + startTimes[index] + ", " + finishTimes[index] + "]");
        }
    }
}
