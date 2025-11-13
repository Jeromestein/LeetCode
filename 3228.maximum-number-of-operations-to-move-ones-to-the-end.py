#
# @lc app=leetcode id=3228 lang=python3
#
# [3228] Maximum Number of Operations to Move Ones to the End
#


# @lc code=start
class Solution:
    def maxOperations(self, s: str) -> int:
        n = len(s)
        zeros_cnt = 0
        res = 0
        for i in range(n - 1, -1, -1):
            if s[i] == "1":
                if i + 1 < n and s[i + 1] == "0":
                    zeros_cnt += 1
                res += zeros_cnt

        return res


# @lc code=end
