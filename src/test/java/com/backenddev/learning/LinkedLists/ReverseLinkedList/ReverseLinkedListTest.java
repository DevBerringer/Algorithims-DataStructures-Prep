package com.backenddev.learning.LinkedLists.ReverseLinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ReverseLinkedList solution.
 */
public class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList;

    @BeforeEach
    public void setUp() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    public void testReverseList_BasicCase() {
        int[] values = {1, 2, 3, 4, 5};
        ReverseLinkedList.ListNode head = reverseLinkedList.createLinkedList(values);
        
        ReverseLinkedList.ListNode result = reverseLinkedList.reverseList(head);
        
        // Check that the list is reversed
        assertEquals(5, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(1, result.next.next.next.next.val);
        assertNull(result.next.next.next.next.next);
    }

    @Test
    public void testReverseList_SingleNode() {
        int[] values = {1};
        ReverseLinkedList.ListNode head = reverseLinkedList.createLinkedList(values);
        
        ReverseLinkedList.ListNode result = reverseLinkedList.reverseList(head);
        
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    @Test
    public void testReverseList_TwoNodes() {
        int[] values = {1, 2};
        ReverseLinkedList.ListNode head = reverseLinkedList.createLinkedList(values);
        
        ReverseLinkedList.ListNode result = reverseLinkedList.reverseList(head);
        
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    public void testReverseList_EmptyList() {
        ReverseLinkedList.ListNode result = reverseLinkedList.reverseList(null);
        assertNull(result);
    }

    @Test
    public void testReverseListRecursive_BasicCase() {
        int[] values = {1, 2, 3, 4, 5};
        ReverseLinkedList.ListNode head = reverseLinkedList.createLinkedList(values);
        
        ReverseLinkedList.ListNode result = reverseLinkedList.reverseListRecursive(head);
        
        // Check that the list is reversed
        assertEquals(5, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(1, result.next.next.next.next.val);
        assertNull(result.next.next.next.next.next);
    }

    @Test
    public void testReverseList_Consistency() {
        int[] values = {1, 2, 3, 4, 5};
        ReverseLinkedList.ListNode head1 = reverseLinkedList.createLinkedList(values);
        ReverseLinkedList.ListNode head2 = reverseLinkedList.createLinkedList(values);
        
        ReverseLinkedList.ListNode result1 = reverseLinkedList.reverseList(head1);
        ReverseLinkedList.ListNode result2 = reverseLinkedList.reverseListRecursive(head2);
        
        // Both methods should produce the same result
        ReverseLinkedList.ListNode current1 = result1;
        ReverseLinkedList.ListNode current2 = result2;
        
        while (current1 != null && current2 != null) {
            assertEquals(current1.val, current2.val);
            current1 = current1.next;
            current2 = current2.next;
        }
        
        assertNull(current1);
        assertNull(current2);
    }
}
