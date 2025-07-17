#
# @lc app=leetcode id=3202 lang=python3
#
# [3202] Find the Maximum Length of Valid Subsequence II
#

# @lc code=start

class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        # k x k, 0 matrix
        dp = [[0] * k for _ in range(k)]
        res = 0
        for num in nums:
            num %= k
            for prev in range(k):
                dp[prev][num] = dp[num][prev] + 1
                res = max(res, dp[prev][num])
        return res

# @lc code=end

