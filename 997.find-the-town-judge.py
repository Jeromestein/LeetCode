#
# @lc app=leetcode id=997 lang=python3
#
# [997] Find the Town Judge
#

# @lc code=start

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if len(trust) < n - 1:
            return -1

        trustScores = [0] * (n + 1)

        for a, b in trust:
            trustScores[a] -= 1
            trustScores[b] += 1

        # i, score
        # 1, trustScores[1]
        # 2, trustScores[2]
        # ...
        # n, trustScores[n]
        for i, score in enumerate(trustScores[1:], 1):
            if score == n - 1:
                return i
        return -1


# @lc code=end
