#
# @lc app=leetcode id=2294 lang=python
#
# [2294] Partition Array Such That Maximum Difference Is K
#

# @lc code=start
class Solution(object):
    def partitionArray(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # typical most k senario, use queue/stack
        # we can sort it first
        n=len(nums)
        nums.sort()
        queue=[]
        queue.append(nums[0])
        qCount=1
        for i in range(n-1):
            if (nums[i+1]-queue[0]>k):
                qCount+=1
                queue=[]

            queue.append(nums[i+1])
            
        return qCount
# @lc code=end

