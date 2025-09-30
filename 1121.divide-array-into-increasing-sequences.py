#
# @lc app=leetcode id=1121 lang=python3
#
# [1121] Divide Array Into Increasing Sequences
#


# @lc code=start
class Solution:
    def canDivideIntoSubsequences(self, nums: List[int], k: int) -> bool:
        pre = nums[0]
        cnt = 0
        for n in nums:
            # find the longest same number lenth
            if pre == n:
                cnt += 1
            else:
                pre = n
                cnt = 1
            if cnt * k > len(nums):
                return False
        return True


# @lc code=end
