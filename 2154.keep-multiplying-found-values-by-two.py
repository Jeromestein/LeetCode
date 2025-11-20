#
# @lc app=leetcode id=2154 lang=python3
#
# [2154] Keep Multiplying Found Values by Two
#


# @lc code=start
class Solution:
    def findFinalValue(self, nums: List[int], original: int) -> int:
        s = set(nums)
        while original in s:
            original *= 2
        return original


# @lc code=end
