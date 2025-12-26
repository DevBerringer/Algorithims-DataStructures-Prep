package com.backenddev.learning.Trees.DFS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MaximumDepthOfBinaryTree solution.
 */
public class MaximumDepthOfBinaryTreeTest {

    private MaximumDepthOfBinaryTree maximumDepthOfBinaryTree;

    @BeforeEach
    public void setUp() {
        maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
    }

    @Test
    public void testMaxDepth_SampleTree() {
        MaximumDepthOfBinaryTree.TreeNode root = maximumDepthOfBinaryTree.createSampleTree();
        int result = maximumDepthOfBinaryTree.maxDepth(root);
        assertEquals(3, result);
    }

    @Test
    public void testMaxDepth_SingleNode() {
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(1);
        int result = maximumDepthOfBinaryTree.maxDepth(root);
        assertEquals(1, result);
    }

    @Test
    public void testMaxDepth_EmptyTree() {
        MaximumDepthOfBinaryTree.TreeNode root = null;
        int result = maximumDepthOfBinaryTree.maxDepth(root);
        assertEquals(0, result);
    }

    @Test
    public void testMaxDepth_LeftSkewed() {
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(1);
        root.left = new MaximumDepthOfBinaryTree.TreeNode(2);
        root.left.left = new MaximumDepthOfBinaryTree.TreeNode(3);
        
        int result = maximumDepthOfBinaryTree.maxDepth(root);
        assertEquals(3, result);
    }

    @Test
    public void testMaxDepth_RightSkewed() {
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(1);
        root.right = new MaximumDepthOfBinaryTree.TreeNode(2);
        root.right.right = new MaximumDepthOfBinaryTree.TreeNode(3);
        
        int result = maximumDepthOfBinaryTree.maxDepth(root);
        assertEquals(3, result);
    }

    @Test
    public void testMaxDepthIterative_SampleTree() {
        MaximumDepthOfBinaryTree.TreeNode root = maximumDepthOfBinaryTree.createSampleTree();
        int result = maximumDepthOfBinaryTree.maxDepthIterative(root);
        assertEquals(3, result);
    }

    @Test
    public void testMaxDepth_Consistency() {
        MaximumDepthOfBinaryTree.TreeNode root = maximumDepthOfBinaryTree.createSampleTree();
        
        int recursiveResult = maximumDepthOfBinaryTree.maxDepth(root);
        int iterativeResult = maximumDepthOfBinaryTree.maxDepthIterative(root);
        
        assertEquals(recursiveResult, iterativeResult);
    }

    @Test
    public void testMinDepth_SampleTree() {
        MaximumDepthOfBinaryTree.TreeNode root = maximumDepthOfBinaryTree.createSampleTree();
        int result = maximumDepthOfBinaryTree.minDepth(root);
        assertEquals(2, result);
    }

    @Test
    public void testMinDepth_SingleNode() {
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(1);
        int result = maximumDepthOfBinaryTree.minDepth(root);
        assertEquals(1, result);
    }

    @Test
    public void testIsBalanced_BalancedTree() {
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(1);
        root.left = new MaximumDepthOfBinaryTree.TreeNode(2);
        root.right = new MaximumDepthOfBinaryTree.TreeNode(3);
        
        boolean result = maximumDepthOfBinaryTree.isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void testIsBalanced_UnbalancedTree() {
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(1);
        root.left = new MaximumDepthOfBinaryTree.TreeNode(2);
        root.left.left = new MaximumDepthOfBinaryTree.TreeNode(3);
        root.left.left.left = new MaximumDepthOfBinaryTree.TreeNode(4);
        
        boolean result = maximumDepthOfBinaryTree.isBalanced(root);
        assertFalse(result);
    }
}
