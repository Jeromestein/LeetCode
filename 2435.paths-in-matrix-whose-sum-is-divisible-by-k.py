#
# @lc app=leetcode id=2435 lang=python3
#
# [2435] Paths in Matrix Whose Sum Is Divisible by K
#

# @lc code=start
from typing import List


class Solution:
    def numberOfPaths(self, grid: List[List[int]], k: int) -> int:
        # We need to count paths whose sum is divisible by k.
        # Since the number of paths can be very large, we return the result modulo 10^9 + 7.
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])

        # dp[i][j][r] = number of paths from (0, 0) to cell (i-1, j-1)
        #               such that the sum of values on the path % k == r
        #
        # We allocate (m+1) x (n+1) to avoid boundary checks when referring to dp[i-1][j] and dp[i][j-1].
        # Indexing:
        #   grid indices: 0..m-1, 0..n-1
        #   dp indices:   1..m,   1..n   (so dp[i][j] corresponds to grid[i-1][j-1])
        dp = [[[0] * k for _ in range(n + 1)] for _ in range(m + 1)]

        # Iterate over all cells in 1-based dp coordinates
        for i in range(1, m + 1):
            for j in range(1, n + 1):

                # Base case: starting cell (0, 0) in grid -> (1, 1) in dp
                if i == 1 and j == 1:
                    # Only one path of length 1: just the starting cell.
                    # The remainder is grid[0][0] % k, and there is exactly 1 such path.
                    dp[i][j][grid[0][0] % k] = 1
                    continue

                # Current cell value (mod k). We only care about remainders.
                value = grid[i - 1][j - 1] % k

                # For each possible remainder r (0..k-1),
                # we want to compute how many paths end at (i, j) with sum % k == r.
                #
                # A path to (i, j) can only come from:
                #   - above:    (i-1, j)
                #   - left:     (i, j-1)
                #
                # Suppose the sum of the path *before* adding current cell is S_prev,
                # and the current cell value is `value`.
                #
                # Then:
                #   (S_prev + value) % k == r
                #
                # Let prev_mod = S_prev % k. We have:
                #   (prev_mod + value) % k == r
                #
                # => prev_mod == (r - value) mod k
                #
                # So to get dp[i][j][r], we need to sum:
                #   dp[i-1][j][prev_mod] + dp[i][j-1][prev_mod]
                # where prev_mod = (r - value + k) % k (to keep it non-negative).
                for r in range(k):
                    prev_mod = (r - value + k) % k

                    # Number of paths coming from above with remainder prev_mod
                    from_up = dp[i - 1][j][prev_mod]

                    # Number of paths coming from left with remainder prev_mod
                    from_left = dp[i][j - 1][prev_mod]

                    # Total number of paths for dp[i][j][r] is the sum of both sources
                    dp[i][j][r] = (from_up + from_left) % MOD

        # We want paths whose total sum is divisible by k,
        # i.e., remainder r == 0 when we reach the bottom-right cell (m-1, n-1),
        # which corresponds to dp[m][n] in our 1-based dp array.
        return dp[m][n][0]


# @lc code=end
