#
# @lc app=leetcode id=345 lang=python3
#
# [345] Reverse Vowels of a String
#

# @lc code=start

class Solution:
    def reverseVowels(self, s: str) -> str:
        # 2 pointers, left right, find vowels and swap
        chars=list(s)
        n=len(chars)
        vowels="aeiouAEIOU"
        left,right=0,n-1
        while left<right:
            if chars[left] in vowels and chars[right] in vowels:
                chars[left], chars[right]=chars[right], chars[left]
                left+=1
                right-=1
            if chars[left] not in vowels:
                left+=1
            if chars[right] not in vowels:
                right-=1
        
        return "".join(chars)
        
# @lc code=end

