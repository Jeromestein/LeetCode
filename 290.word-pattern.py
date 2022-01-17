#
# @lc app=leetcode id=290 lang=python3
#
# [290] Word Pattern
#

# @lc code=start

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        char2word = {}
        word2char = {}
        words = s.split(' ')

        if len(pattern) != len(words):
            return False

        # n = len(words)
        # for i in range(n):
        #     currChar, currWord = pattern[i], words[i]

        for c, w in zip(pattern, words):
            if c not in char2word:
                if w in word2char:
                    return False
                else:
                    char2word[c] = w
                    word2char[w] = c

            else:
                if char2word[c] != w:
                    return False

        return True


# @lc code=end
