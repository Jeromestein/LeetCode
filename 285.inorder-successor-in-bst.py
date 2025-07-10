#
# @lc app=leetcode id=285 lang=python3
#
# [285] Inorder Successor in BST
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
        succ = None
        node = root
        while node:
            if p.val < node.val:
                succ = node      # node 是候选
                node = node.left
            else:
                node = node.right
        return succ
# @lc code=end

