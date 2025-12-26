package com.backenddev.learning.LinkedLists.Heap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MergeKSortedLists solution.
 */
public class MergeKSortedListsTest {

    private MergeKSortedLists mergeKSortedLists;

    @BeforeEach
    public void setUp() {
        mergeKSortedLists = new MergeKSortedLists();
    }

    @Test
    public void testMergeKLists_BasicCase() {
        MergeKSortedLists.ListNode list1 = new MergeKSortedLists.ListNode(1, 
            new MergeKSortedLists.ListNode(4, new MergeKSortedLists.ListNode(5)));
        MergeKSortedLists.ListNode list2 = new MergeKSortedLists.ListNode(1, 
            new MergeKSortedLists.ListNode(3, new MergeKSortedLists.ListNode(4)));
        MergeKSortedLists.ListNode list3 = new MergeKSortedLists.ListNode(2, 
            new MergeKSortedLists.ListNode(6));
        
        MergeKSortedLists.ListNode[] lists = {list1, list2, list3};
        MergeKSortedLists.ListNode result = mergeKSortedLists.mergeKLists(lists);
        
        assertNotNull(result);
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(2, result.next.next.val);
    }

    @Test
    public void testMergeKLists_EmptyArray() {
        MergeKSortedLists.ListNode[] lists = {};
        MergeKSortedLists.ListNode result = mergeKSortedLists.mergeKLists(lists);
        assertNull(result);
    }

    @Test
    public void testMergeKLists_SingleList() {
        MergeKSortedLists.ListNode list1 = new MergeKSortedLists.ListNode(1, 
            new MergeKSortedLists.ListNode(2, new MergeKSortedLists.ListNode(3)));
        
        MergeKSortedLists.ListNode[] lists = {list1};
        MergeKSortedLists.ListNode result = mergeKSortedLists.mergeKLists(lists);
        
        assertNotNull(result);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
    }

    @Test
    public void testMergeKLists_ContainsNullLists() {
        MergeKSortedLists.ListNode list1 = new MergeKSortedLists.ListNode(1);
        MergeKSortedLists.ListNode[] lists = {list1, null, null};
        MergeKSortedLists.ListNode result = mergeKSortedLists.mergeKLists(lists);
        
        assertNotNull(result);
        assertEquals(1, result.val);
    }
}
