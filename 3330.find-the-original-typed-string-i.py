#
# @lc app=leetcode id=3330 lang=python3
#
# [3330] Find the Original Typed String I
#

# @lc code=start
class Solution:
    def possibleStringCount(self, word: str) -> int:
        n, res= len(word), 1
        for i in range(1, n):
            if word[i]==word[i-1]:
                res+=1

        return res
        
# @lc code=end

