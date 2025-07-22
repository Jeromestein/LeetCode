#
# @lc app=leetcode id=1957 lang=python3
#
# [1957] Delete Characters to Make Fancy String
#

# @lc code=start
class Solution:
    def makeFancyString(self, s: str) -> str:
        n=len(s)
        if n<3:
            return s
        
        res=s[0]
        cnt=1
        prev=s[0]
        for i in range(1,n):
            if s[i]==prev:
                cnt+=1
            else:
                prev=s[i]
                cnt=1

            if cnt<3:
                res+=s[i]

        return res
        
# @lc code=end

