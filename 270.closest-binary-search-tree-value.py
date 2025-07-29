#
# @lc app=leetcode id=270 lang=python3
#
# [270] Closest Binary Search Tree Value
#


# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        #  number of nodes in the tree is in the range [1, 10^4]
        res = root.val

        while root:
            if abs(target - root.val) < abs(target - res):
                res = root.val
            # the equal situation
            if abs(target - root.val) == abs(target - res):
                res = min(res, root.val)

            if root.val > target:
                root = root.left
            else:
                root = root.right

        return res


# @lc code=end
