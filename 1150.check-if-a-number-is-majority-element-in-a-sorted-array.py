#
# @lc app=leetcode id=1150 lang=python3
#
# [1150] Check If a Number Is Majority Element in a Sorted Array
#


# @lc code=start
class Solution:
    def isMajorityElement(self, nums: List[int], target: int) -> bool:
        target_cnt = bisect_right(nums, target) - bisect_left(nums, target)
        return target_cnt * 2 > len(nums)


# @lc code=end
