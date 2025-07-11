#
# @lc app=leetcode id=680 lang=python3
#
# [680] Valid Palindrome II
#

# @lc code=start

class Solution:
    def validPalindrome(self, s: str) -> bool:
        def isValid(chars):
            n=len(chars)
            left,right=0,n-1
            while left<right:
                if chars[left]!=chars[right]:
                    return False
                left+=1
                right-=1

            return True

        n=len(s)
        left,right=0,n-1
        while left<right:
            if s[left]!=s[right]:
                isValidDelLeft=isValid(s[left+1:right+1])
                isValidDelRight=isValid(s[left:right])
                return isValidDelLeft or isValidDelRight
            left+=1
            right-=1

        return True
        
# @lc code=end

