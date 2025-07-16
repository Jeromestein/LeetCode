#
# @lc app=leetcode id=209 lang=python3
#
# [209] Minimum Size Subarray Sum
#

# @lc code=start

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        if sum(nums)<target:
            return 0

        n = len(nums)
        left, right = 0, 0
        curr_sum = 0
        res = n
        for right in range(n):
            curr_sum+=nums[right]
            while curr_sum>=target and left<=right:
                res = min(res, right-left +1)
                curr_sum-=nums[left]
                left+=1

        return res

# @lc code=end

