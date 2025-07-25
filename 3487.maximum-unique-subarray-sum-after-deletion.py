#
# @lc app=leetcode id=3487 lang=python3
#
# [3487] Maximum Unique Subarray Sum After Deletion
#

# @lc code=start


class Solution:
    def maxSum(self, nums: List[int]) -> int:
        positiveNumsSet = set([num for num in nums if num > 0])
        return max(nums) if len(positiveNumsSet) == 0 else sum(positiveNumsSet)


# @lc code=end
