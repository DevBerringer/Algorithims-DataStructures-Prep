package com.backenddev.learning.LinkedLists.ReverseLinkedList;

/**
 * <h2>Solution for: Reverse Linked List.</h2>
 * <p>
 * This class provides a solution to reverse a singly linked list.
 * Given the head of a singly linked list, reverse the list and return the reversed list.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use three pointers: previous, current, and next.</li>
 *   <li>Iterate through the list, reversing the links as we go.</li>
 *   <li>Update pointers: next = current.next, current.next = previous, previous = current, current = next.</li>
 *   <li>Continue until we reach the end of the list.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the number of nodes in the linked list.</li>
 *   <li>Space complexity: O(1) as we only use a constant amount of extra space.</li>
 * </ul>
 */
public class ReverseLinkedList {

    /**
     * Definition for singly-linked list node.
     */
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) { 
            this.val = val; 
        }
        
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    /**
     * Method to reverse a linked list iteratively.
     *
     * @param head the head of the linked list
     * @return the head of the reversed linked list
     */
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next; // Store next node
            current.next = previous;      // Reverse the link
            previous = current;           // Move previous forward
            current = next;               // Move current forward
        }
        
        return previous; // previous is now the new head
    }

    /**
     * Method to reverse a linked list recursively.
     *
     * @param head the head of the linked list
     * @return the head of the reversed linked list
     */
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively reverse the rest of the list
        ListNode reversedHead = reverseListRecursive(head.next);
        
        // Reverse the current link
        head.next.next = head;
        head.next = null;
        
        return reversedHead;
    }

    /**
     * Helper method to create a linked list from an array.
     *
     * @param values array of values
     * @return head of the created linked list
     */
    public ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }

    /**
     * Helper method to print a linked list.
     *
     * @param head the head of the linked list
     */
    public void printLinkedList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    /**
     * Main method to run the Reverse Linked List solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        
        // Test case
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = solution.createLinkedList(values);
        
        System.out.println("Original linked list:");
        solution.printLinkedList(head);
        
        // Test iterative approach
        ListNode reversedHead = solution.reverseList(head);
        System.out.println("Reversed linked list (iterative):");
        solution.printLinkedList(reversedHead);
        
        // Test recursive approach
        ListNode originalHead = solution.createLinkedList(values);
        ListNode recursiveReversed = solution.reverseListRecursive(originalHead);
        System.out.println("Reversed linked list (recursive):");
        solution.printLinkedList(recursiveReversed);
    }
}
