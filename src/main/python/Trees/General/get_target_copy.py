"""
Find Corresponding Node in a Clone of a Binary Tree (LeetCode 1379 style).

Solution: recursively traverse original and cloned trees in parallel. When the
original node matches the target (by identity), return the corresponding
cloned node.
"""
from __future__ import annotations
from typing import Optional


class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self) -> str:  # helpful for debugging/demo
        return f"TreeNode({self.val})"


class Solution:
    def getTargetCopy(self, original: Optional[TreeNode], cloned: Optional[TreeNode], target: Optional[TreeNode]) -> Optional[TreeNode]:
        if original is None:
            return None

        if original is target:
            return cloned

        left = self.getTargetCopy(original.left, cloned.left if cloned else None, target)
        if left:
            return left

        return self.getTargetCopy(original.right, cloned.right if cloned else None, target)


if __name__ == "__main__":
    # Build example original tree
    #       7
    #      / \
    #     4   3
    #        / \
    #       6  19
    orig = TreeNode(7, TreeNode(4), TreeNode(3, TreeNode(6), TreeNode(19)))
    # Build cloned tree (separate objects but same structure/values)
    cloned = TreeNode(7, TreeNode(4), TreeNode(3, TreeNode(6), TreeNode(19)))

    target = orig.left  # node with value 4 in original
    found = Solution().getTargetCopy(orig, cloned, target)

    print("target (original):", target)
    print("found (cloned):", found)
    print("values equal?", found.val == target.val if found and target else None)
    print("same object as original?", found is target)
    print("same object as cloned.left?", found is cloned.left)

