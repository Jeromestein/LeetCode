#
# @lc app=leetcode id=1695 lang=python3
#
# [1695] Maximum Erasure Value
#

# @lc code=start


class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        # hashmap-O(n), O(n)
        # left, right
        n=len(nums)
        res=cur_sum=0
        left=right=0
        pre_idx={}
        for right in range(n):
            while nums[right] in pre_idx:
                pre_idx.pop(nums[left])
                cur_sum-=nums[left]
                left+=1
                
            pre_idx[nums[right]]=right
            cur_sum+=nums[right]
            res=max(res, cur_sum)

        return res

# @lc code=end

