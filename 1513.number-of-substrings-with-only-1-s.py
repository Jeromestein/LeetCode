#
# @lc app=leetcode id=1513 lang=python3
#
# [1513] Number of Substrings With Only 1s
#


# @lc code=start
class Solution:
    def numSub(self, s: str) -> int:
        total, cnt = 0, 0
        length = len(s)
        for i in range(length):
            if s[i] == "0":
                total += cnt * (cnt + 1) // 2
                total %= 10**9 + 7
                cnt = 0
            else:
                cnt += 1

        total += cnt * (cnt + 1) // 2
        total %= 10**9 + 7
        return total


# @lc code=end
