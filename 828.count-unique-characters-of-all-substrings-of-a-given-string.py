#
# @lc app=leetcode id=828 lang=python3
#
# [828] Count Unique Characters of All Substrings of a Given String
#

# @lc code=start


class Solution:
    def uniqueLetterString(self, s: str) -> int:
        # 1. index[26][2] record last two occurrence index for every upper characters.
        index = {c: [-1, -1] for c in string.ascii_uppercase}
        res = 0

        # 2. Loop on string S, for every character c, update its last two occurrence index to index[c].
        for i, c in enumerate(s):
            k, j = index[c]
            res += (i - j) * (j - k)
            index[c] = [j, i]

        # 3. Count when loop.
        # For example, if "A" appears twice at index 3, 6, 9 seperately, we need to count:
        # For the first "A": (6-3) * (3-(-1))"
        # For the second "A": (9-6) * (6-3)"
        # For the third "A": (N-9) * (9-6)"
        for c in index:
            k, j = index[c]
            res += (len(s) - j) * (j - k)
        return res % (10 ** 9 + 7)


# @lc code=end
