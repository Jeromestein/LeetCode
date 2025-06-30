#
# @lc app=leetcode id=1283 lang=python3
#
# [1283] Find the Smallest Divisor Given a Threshold
#

# @lc code=start

class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        left, right = 1, max(nums)
        while left < right:
            mid = (left + right) // 2
            sum = 0
            for num in nums:
                sum += math.ceil(num/mid)
            if sum <= threshold:
                right = mid
            else:
                left = mid + 1
        return left


# @lc code=end
