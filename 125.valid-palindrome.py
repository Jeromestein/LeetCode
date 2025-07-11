#
# @lc app=leetcode id=125 lang=python3
#
# [125] Valid Palindrome
#

# @lc code=start

class Solution:
    def isPalindrome(self, s: str) -> bool:
        def getLetters(s):
            return [
                ch.lower()
                for ch in s
                if ch.isalnum() or ch.isdigit()
            ]
        
        chars=getLetters(s)
        n=len(chars)
        left, right=0,n-1
        while left<right:
            if chars[left]!=chars[right]:
                return False
            left+=1
            right-=1
        
        return True
     
# @lc code=end

