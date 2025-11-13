#
# @lc app=leetcode id=474 lang=python3
#
# [474] Ones and Zeroes
#


# @lc code=start
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0 for _ in range(101)] for _ in range(101)]

        strs.sort(key=len)
        curr_m, curr_n = 0, 0
        for s in strs:
            cnt = Counter(s)
            x, y = cnt["0"], cnt["1"]

            for i in range(m, x - 1, -1):
                for j in range(n, y - 1, -1):
                    dp[i][j] = max(dp[i - x][j - y] + 1, dp[i][j])

        return dp[m][n]


# @lc code=end
