#
# @lc app=leetcode id=3354 lang=python3
#
# [3354] Make Array Elements Equal to Zero
#

# @lc code=start


class Solution:
    def countValidSelections(self, nums: List[int]) -> int:
        # return positions , sum_left==sum_right
        sum_left = 0
        sum_right = sum(nums)
        n = len(nums)
        res = 0
        for i in range(n):
            sum_left += nums[i]
            sum_right -= nums[i]
            if sum_left == sum_right and nums[i] == 0:
                res += 2
            if abs(sum_left - sum_right) == 1 and nums[i] == 0:
                res += 1

        return res


# @lc code=end
