#
# @lc app=leetcode id=3227 lang=python3
#
# [3227] Vowels Game in a String
#

# @lc code=start


class Solution:
    def doesAliceWin(self, s: str) -> bool:
        # s consists only of lowercase English letters.
        n = len(s)
        cnt = 0

        for i in range(n):
            if s[i] in "aeiou":
                cnt += 1

        # No Vowel
        return cnt != 0


# @lc code=end
