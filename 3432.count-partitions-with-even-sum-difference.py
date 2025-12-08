#
# @lc app=leetcode id=3432 lang=python3
#
# [3432] Count Partitions with Even Sum Difference
#


# @lc code=start
class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        totalSum = sum(nums)
        return len(nums) - 1 if totalSum % 2 == 0 else 0


# @lc code=end
