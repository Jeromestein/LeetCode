#
# @lc app=leetcode id=3542 lang=python3
#
# [3542] Minimum Operations to Convert All Elements to Zero
#


# @lc code=start
class Solution:
    def minOperations(self, nums: List[int]) -> int:
        s = []  # Monotonic increasing stack of *positive* "active layers"
        res = 0  # Number of operations needed

        for a in nums:
            # Maintain a strictly increasing stack:
            # any layer higher than current 'a' can never be the minimum of
            # a future chosen subarray (because 'a' is smaller and appears earlier),
            # so those higher layers are not needed anymore.
            while s and s[-1] > a:
                s.pop()

            # Zeros already represent a "scraped" level; no operation needed.
            if a == 0:
                continue

            # If 'a' equals the top layer, it belongs to the same layer → no new op.
            # If there is no layer yet OR 'a' is strictly higher than the top,
            # we have encountered a *new bottom layer* that will require one operation
            # to be turned to zero somewhere in a subarray.
            if not s or s[-1] < a:
                res += 1  # one more operation for this new layer
                s.append(a)  # track this active layer

        return res


# @lc code=end
