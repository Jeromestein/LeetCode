#
# @lc app=leetcode id=2200 lang=python3
#
# [2200] Find All K-Distant Indices in an Array
#

# @lc code=start
class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        res=list()
        right=0
        n=len(nums)
        for i in range(n):
            if nums[i]==key:
                left=max(right, i-k)
                right=min(n-1, i+k)+1
                for j in range(left, right):
                    res.append(j)

        return res
    
# @lc code=end

