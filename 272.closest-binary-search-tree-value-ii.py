#
# @lc app=leetcode id=272 lang=python3
#
# [272] Closest Binary Search Tree Value II
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
    def closestKValues(
        self, root: Optional[TreeNode], target: float, k: int
    ) -> List[int]:
        def dfs(root, dq):
            if not root:
                return

            dfs(root.left, dq)

            dq.append(root.val)
            print(root.val)
            if len(dq) > k:
                # predecessor is closer
                if abs(target - dq[0]) <= abs(target - dq[-1]):
                    dq.pop()
                    # right subtree val will be further
                    # skip the right subtree
                    return
                # successor is closer
                else:
                    dq.popleft()

            dfs(root.right, dq)

        dq = deque()
        dfs(root, dq)
        return list(dq)


# @lc code=end
