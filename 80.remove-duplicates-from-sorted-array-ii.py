#
# @lc app=leetcode id=80 lang=python3
#
# [80] Remove Duplicates from Sorted Array II
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        duplicatesLen=1
        uniqueCnt=1
        for i in range(1, n):
            if nums[i]>nums[i-1]:
                nums[uniqueCnt]=nums[i]
                uniqueCnt+=1
                duplicatesLen=1
            elif nums[i]==nums[i-1]:
                if duplicatesLen<2:
                    nums[uniqueCnt]=nums[i]
                    uniqueCnt+=1
                duplicatesLen+=1

        return uniqueCnt
        
# @lc code=end

