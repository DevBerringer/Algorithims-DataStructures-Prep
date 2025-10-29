package com.backenddev.learning.Trees.MaximumDepthOfBinaryTree;

/**
 * <h2>Solution for: Maximum Depth of Binary Tree.</h2>
 * <p>
 * This class provides a solution to find the maximum depth of a binary tree.
 * The maximum depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use recursive approach to traverse the tree.</li>
 *   <li>For each node, calculate the depth of left and right subtrees.</li>
 *   <li>Return 1 + maximum of left and right subtree depths.</li>
 *   <li>Base case: if node is null, return 0.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the number of nodes in the tree.</li>
 *   <li>Space complexity: O(h) where h is the height of the tree (recursion stack).</li>
 * </ul>
 */
public class MaximumDepthOfBinaryTree {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) { 
            this.val = val; 
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Method to find the maximum depth of a binary tree using recursion.
     *
     * @param root the root of the binary tree
     * @return the maximum depth of the tree
     */
    public int maxDepth(TreeNode root) {
        // Base case: empty tree has depth 0
        if (root == null) {
            return 0;
        }
        
        // Recursively find depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // Return 1 (current node) + maximum of left and right depths
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Method to find the maximum depth using iterative approach (BFS).
     *
     * @param root the root of the binary tree
     * @return the maximum depth of the tree
     */
    public int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return depth;
    }

    /**
     * Method to find the minimum depth of a binary tree.
     *
     * @param root the root of the binary tree
     * @return the minimum depth of the tree
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If it's a leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        // If left subtree is null, recur for right subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        
        // If right subtree is null, recur for left subtree
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        
        // Both subtrees exist, find minimum
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * Method to check if a binary tree is balanced.
     * A balanced tree is one where the heights of the two child subtrees
     * of any node never differ by more than 1.
     *
     * @param root the root of the binary tree
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    /**
     * Helper method to check if tree is balanced and return height.
     *
     * @param root the root of the subtree
     * @return height of the tree if balanced, -1 if unbalanced
     */
    private int checkBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = checkBalance(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        
        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Helper method to create a sample binary tree for testing.
     *
     * @return a sample binary tree
     */
    public TreeNode createSampleTree() {
        // Create tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    /**
     * Helper method to print tree structure (inorder traversal).
     *
     * @param root the root of the tree
     */
    public void printTree(TreeNode root) {
        System.out.print("Inorder traversal: ");
        inorderTraversal(root);
        System.out.println();
    }

    /**
     * Helper method for inorder traversal.
     */
    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    /**
     * Main method to run the Maximum Depth of Binary Tree solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        
        // Test case 1: Sample tree
        TreeNode root1 = solution.createSampleTree();
        System.out.println("Sample tree:");
        solution.printTree(root1);
        
        int maxDepth1 = solution.maxDepth(root1);
        int maxDepthIterative1 = solution.maxDepthIterative(root1);
        int minDepth1 = solution.minDepth(root1);
        boolean isBalanced1 = solution.isBalanced(root1);
        
        System.out.println("Maximum depth (recursive): " + maxDepth1);
        System.out.println("Maximum depth (iterative): " + maxDepthIterative1);
        System.out.println("Minimum depth: " + minDepth1);
        System.out.println("Is balanced: " + isBalanced1);
        System.out.println();
        
        // Test case 2: Single node
        TreeNode root2 = new TreeNode(1);
        System.out.println("Single node tree:");
        int maxDepth2 = solution.maxDepth(root2);
        System.out.println("Maximum depth: " + maxDepth2);
        System.out.println();
        
        // Test case 3: Empty tree
        TreeNode root3 = null;
        System.out.println("Empty tree:");
        int maxDepth3 = solution.maxDepth(root3);
        System.out.println("Maximum depth: " + maxDepth3);
    }
}
