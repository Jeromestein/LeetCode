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
            sum = 0
            for num in nums:
                sum += math.ceil(num/m)
            if sum <= threshold:
                r = m
            else:
                l = m + 1
        return l


# @lc code=end
