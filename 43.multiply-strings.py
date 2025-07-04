#
# @lc app=leetcode id=43 lang=python3
#
# [43] Multiply Strings
#

# @lc code=start
class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m,n=len(num1),len(num2)
        res=[0]*(m+n)
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                digit1=ord(num1[i])-ord('0')
                digit2=ord(num2[j])-ord('0')
                res[i+j+1]+=digit1*digit2

        for x in range(m+n-1,0,-1):
            carry=res[x]//10
            res[x]%=10
            res[x-1]+=carry

        idx=0
        while idx<m+n and res[idx]==0:
            idx+=1

        ans=''.join(str(digit) for digit in res[idx:]) 
        return ans or "0"         
# @lc code=end

