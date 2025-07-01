#
# @lc app=leetcode id=333 lang=python3
#
# [333] Largest BST Subtree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestBSTSubtree(self, root: TreeNode) -> int:
        self.ans = 0

        def dfs(node):
            """
            Returns (is_bst, size, min_val, max_val) for the subtree rooted at node.
            """
            if not node:
                # An empty tree is a BST of size 0
                return True, 0, float('inf'), float('-inf')

            l_bst, l_size, l_min, l_max = dfs(node.left)
            r_bst, r_size, r_min, r_max = dfs(node.right)

            # Check BST property including whole‐subtree min/max
            if l_bst and r_bst and l_max < node.val < r_min:
                size = l_size + r_size + 1
                # Update global maximum
                self.ans = max(self.ans, size)
                # Return BST info
                return True, size, min(l_min, node.val), max(r_max, node.val)
            else:
                # Not a BST: size/min/max returned here are irrelevant
                return False, 0, 0, 0

        dfs(root)
        return self.ans
        
# @lc code=end

