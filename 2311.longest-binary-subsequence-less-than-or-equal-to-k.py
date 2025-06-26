#
# @lc app=leetcode id=2311 lang=python3
#
# [2311] Longest Binary Subsequence Less Than or Equal to K
#

# @lc code=start
class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        # find all zeros and insert ones to it?
        count=0
        sum=0
        for i,ch in enumerate(s[::-1]):
            if ch=='1':
                ## use bit shift to calculate the power of 2
                sum += 1<<i
                if sum<=k:
                    count+=1
            if ch=='0':
                count+=1
        
        return count



# @lc code=end

