package com.backenddev.learning.HeapAndPriorityQueue.MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h2>Solution for: Merge K Sorted Lists.</h2>
 * <p>
 * This class provides a solution to merge k sorted linked lists into one sorted linked list.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a min-heap (PriorityQueue) to store the head nodes of all lists.</li>
 *   <li>Extract the minimum node from the heap and add it to the result list.</li>
 *   <li>Add the next node from the same list to the heap if it exists.</li>
 *   <li>Continue until all nodes are processed.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n log k) where n is the total number of nodes and k is the number of lists.</li>
 *   <li>Space complexity: O(k) for the min-heap.</li>
 * </ul>
 */
public class MergeKSortedLists {

    /**
     * Method to merge k sorted linked lists into one sorted linked list.
     *
     * @param lists the input array of sorted linked lists
     * @return the head of the merged sorted linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add the initial nodes of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = node;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Main method to run the Merge K Sorted Lists solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        // Create sample lists
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        
        ListNode[] lists = {list1, list2, list3};
        ListNode result = solution.mergeKLists(lists);
        
        System.out.println("Merged List:");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
