#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n=len(s)
        left=right=maxLen=0
        # recentIdx[s[right]]=right+1, stores the next idx of the char
        recentIdx={}
        while right < n:                
            if s[right] in recentIdx:
                left=max(left, recentIdx[s[right]])
                
            recentIdx[s[right]]=right+1
            maxLen=max(maxLen, right-left+1)
            right+=1

        return maxLen
        
# @lc code=end

