#
# @lc app=leetcode id=3136 lang=python3
#
# [3136] Valid Word
#

# @lc code=start

class Solution:
    def isValid(self, word: str) -> bool:
        if len(word)<3:
            return False

        if not word.isalnum():
            return False

        has_vowel = False
        has_consonant = False

        for c in word:
            if c.isalpha():
                if c.lower() in "aeiou":
                    has_vowel = True
                else:
                    has_consonant = True
            elif not c.isdigit():
                return False

        return has_vowel and has_consonant
        

        
# @lc code=end

