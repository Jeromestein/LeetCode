#
# @lc app=leetcode id=198 lang=python3
#
# [198] House Robber
#


# @lc code=start
class Solution:
    def rob(self, nums: List[int]) -> int:
        # dp[i]: max amount before i
        # dp[i]= max(dp[i-2]+nums[i-1],dp[i-1])
        n = len(nums)
        # dp=[0]*(n+1)
        # dp[1]=nums[0]
        pre_pre = 0
        pre = nums[0]
        res = nums[0]
        for i in range(2, n + 1):
            # dp[i]=max(dp[i-2]+nums[i-1], dp[i-1])
            res = max(pre_pre + nums[i - 1], pre)
            pre_pre = pre
            pre = res

        return res


# @lc code=end
