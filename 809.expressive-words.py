#
# @lc app=leetcode id=809 lang=python3
#
# [809] Expressive Words
#

# @lc code=start
class Solution:
    def expressiveWords(self, s, words):
        return sum(self.check(s, word) for word in words)

    def check(self, s, word):
        i, j, n, m = 0, 0, len(s), len(word)
        for i in range(n):
            if j < m and s[i] == word[j]:
                j += 1
            elif s[i - 1:i + 2] != s[i] * 3 != s[i - 2:i + 1]:
                # s[i]: 'a', s[i]*3: 'aaa'
                return False
        return j == m

# @lc code=end
