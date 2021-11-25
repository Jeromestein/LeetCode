#
# @lc app=leetcode id=828 lang=python3
#
# [828] Count Unique Characters of All Substrings of a Given String
#

# @lc code=start


class Solution:
    def uniqueLetterString(self, s: str) -> int:
        index = {c: [-1, -1] for c in string.ascii_uppercase}
        res = 0
        for i, c in enumerate(s):
            k, j = index[c]
            res += (i - j) * (j - k)
            index[c] = [j, i]
        for c in index:
            k, j = index[c]
            res += (len(s) - j) * (j - k)
        return res % (10 ** 9 + 7)


# @lc code=end
