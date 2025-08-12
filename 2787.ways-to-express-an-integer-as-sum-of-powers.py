#
# @lc app=leetcode id=2787 lang=python3
#
# [2787] Ways to Express an Integer as Sum of Powers
#


# @lc code=start
class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        """
        Count the number of sets of distinct positive integers {a1, a2, ..., ak}
        such that a1**x + a2**x + ... + ak**x = n.
        This is a 0/1 knapsack counting DP over items {1**x, 2**x, ..., t**x},
        where t = floor(n**(1/x)). Each power can be used at most once.
        """
        MOD = 10**9 + 7

        # dp[s] = number of ways to form sum s using the powers processed so far
        dp = [0] * (n + 1)
        dp[0] = 1  # one way to form sum 0: choose the empty set

        # Iterate over items (powers) in increasing base i
        for i in range(1, n + 1):
            val = i**x  # the "weight/value" of this item (i^x)
            if val > n:
                break  # all further powers will also exceed n

            # 0/1 knapsack update in decreasing order to avoid reusing the same item
            for s in range(n, val - 1, -1):
                # add ways that include this item: form (s - val) previously, then add val
                dp[s] = (dp[s] + dp[s - val]) % MOD

        # Number of ways to form sum n
        return dp[n]


# @lc code=end
