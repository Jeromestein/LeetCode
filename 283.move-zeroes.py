#
# @lc app=leetcode id=283 lang=python3
#
# [283] Move Zeroes
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # nums before ptr1 r zero-free
        ptr1=0
        n=len(nums)
        for i in range(n):
            if nums[i]!=0:
                nums[i], nums[ptr1]=  nums[ptr1],nums[i]
                ptr1+=1
        
        return
        
        
# @lc code=end

