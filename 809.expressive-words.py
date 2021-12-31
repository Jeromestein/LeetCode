#
# @lc app=leetcode id=809 lang=python3
#
# [809] Expressive Words
#

# @lc code=start
class Solution:
    # Loop through all words. check(string S, string W) checks if W is stretchy to S.

    # In check function, use two pointer:

    # If S[i] == W[j, i++, j++
    # If S[i - 2] == S[i - 1] == S[i] or S[i - 1] == S[i] == S[i + 1], i++
    # return false
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
