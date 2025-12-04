#
# @lc app=leetcode id=242 lang=python3
#
# [242] Valid Anagram
#


# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        n, m = len(s), len(t)
        if m != n:
            return False

        s_cnt = Counter(s)
        t_cnt = Counter(t)

        for char, freq in s_cnt.items():
            if freq != t_cnt[char]:
                return False

        return True


# @lc code=end
