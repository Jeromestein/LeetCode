#
# @lc app=leetcode id=1283 lang=python3
#
# [1283] Find the Smallest Divisor Given a Threshold
#

# @lc code=start

class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        l, r = 1, max(nums)
        while l < r:
            m = (l + r) // 2
            if sum((i + m - 1) // m for i in nums) > threshold:
                l = m + 1
            else:
                r = m
        return l


# @lc code=end
