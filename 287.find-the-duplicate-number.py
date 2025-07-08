#
# @lc app=leetcode id=287 lang=python3
#
# [287] Find the Duplicate Number
#

# @lc code=start
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # find the interection point
        # F+a
        # 2(F+a)=F+nC+a
        # F=nC-a
        slow= fast=nums[0]
        while True:
            slow=nums[slow]
            fast=nums[nums[fast]]
            if slow == fast:
                break

        # Find the entrance of cycle
        # F=nC-a, so we let slow start form 0.
        # It will end up at the entrance
        slow=nums[0]
        while slow!=fast:
            slow=nums[slow]
            fast=nums[fast]

        return fast
        
# @lc code=end

