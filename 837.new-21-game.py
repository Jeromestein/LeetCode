#
# @lc app=leetcode id=837 lang=python3
#
# [837] New 21 Game
#

# @lc code=start

class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        # If Alice stops immediately, she always has 0 points ≤ n
        if k == 0:
            return 1.0

        # dp[x] is the probability of having exactly x points
        dp = [0.0] * (n + 1)
        dp[0] = 1.0

        # window_sum = sum of dp[x - 1], dp[x - 2], …, dp[x - maxPts]
        # but only for states where x - i < k (she is still drawing)
        window_sum = 1.0
        result = 0.0

        for x in range(1, n + 1):
            # Compute dp[x] in O(1) by dividing the window sum by maxPts
            dp[x] = window_sum / maxPts

            # If x is still below k, Alice continues drawing, so include dp[x]
            if x < k:
                window_sum += dp[x]
            else:
                # Once x ≥ k, Alice stops drawing; accumulate to final result
                result += dp[x]

            # Slide the window: remove dp[x - maxPts] when it falls out
            if x - maxPts >= 0 and x - maxPts < k:
                window_sum -= dp[x - maxPts]

        return result

# @lc code=end

