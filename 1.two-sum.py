#
# @lc app=leetcode id=1 lang=python
#
# [1] Two Sum
#

# @lc code=start
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n = len(nums)
        numMap={}
        for i in range(n):
            x = target - nums[i]
            if x in numMap:
                return [numMap[x], i]
            
            numMap[nums[i]]=i
        
        return []
        
# @lc code=end

