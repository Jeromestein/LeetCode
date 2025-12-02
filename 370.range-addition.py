#
# @lc app=leetcode id=370 lang=python3
#
# [370] Range Addition
#


# @lc code=start
class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        res = [0] * length

        for startIdx, endIdx, inc in updates:
            res[startIdx] += inc
            if endIdx + 1 < length:
                res[endIdx + 1] -= inc

        for i in range(1, length):
            res[i] = res[i - 1] + res[i]

        return res


# @lc code=end
