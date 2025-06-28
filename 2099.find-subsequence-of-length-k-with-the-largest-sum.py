#
# @lc app=leetcode id=2099 lang=python3
#
# [2099] Find Subsequence of Length K With the Largest Sum
#

# @lc code=start
class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        n=len(nums)
        pairs=[[i, nums[i]] for i in range(n)]
        # sort the pairs by the nums[i] in descending order
        pairs.sort(key=lambda pair:pair[1], reverse=True)
        # get the first k elements
        pairs=pairs[:k]
        # sort the pairs by the index in ascending order
        pairs.sort(key=lambda pair:pair[0])
        return [pair[1] for pair in pairs]
     
# @lc code=end

