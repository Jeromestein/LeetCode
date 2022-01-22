#
# @lc app=leetcode id=1510 lang=python3
#
# [1510] Stone Game IV
#

# @lc code=start


class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        # Alice starting first

        # dp = [False]*(n+1)
        # for i in range(1, n+1):
        #     for k in range(1, int(i**0.5)+1):
        #         if dp[i-k*k] == False:
        #             dp[i] = True
        #             break
        # return dp[n]

        dp = [False]*(n+1)
        # 1<=i<n+1
        for i in range(n+1):
            # In the backtrack way to avoid unnecessary for k in range(1, int(n**0.5)+1):
            # make it faster
            if dp[i]:
                continue
            for k in range(1, int(n**0.5)+1):
                if i+k*k <= n:
                    dp[i+k*k] = True
                else:
                    break
        return dp[n]

        # @lc code=end
