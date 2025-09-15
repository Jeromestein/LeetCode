#
# @lc app=leetcode id=1935 lang=python3
#
# [1935] Maximum Number of Words You Can Type
#

# @lc code=start


class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        res = 0
        words = text.split()
        for word in words:

            for l in brokenLetters:
                if l in word:
                    res += 1
                    break

        return len(words) - res


# @lc code=end
