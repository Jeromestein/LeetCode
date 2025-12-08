#
# @lc app=leetcode id=3578 lang=python3
#
# [3578] Count Partitions With Max-Min Difference at Most K
#

# @lc code=start
from collections import deque
from typing import List


class Solution:
    def countPartitions(self, nums: List[int], k: int) -> int:
        n = len(nums)
        mod = 10**9 + 7

        # dp[i] = number of valid ways to partition the prefix nums[0..i-1]
        #         (i.e., the first i elements).
        dp = [0] * (n + 1)

        # prefix[i] = (dp[0] + dp[1] + ... + dp[i]) % mod
        # Used to quickly compute range sums of dp.
        prefix = [0] * (n + 1)

        # Monotonic queues storing indices for the current window [j..i]:
        # - max_q: decreasing queue of indices (nums[max_q[0]] is current maximum)
        # - min_q: increasing queue of indices (nums[min_q[0]] is current minimum)
        max_q = deque()
        min_q = deque()

        # Base case:
        # There is exactly one way to partition an empty prefix: do nothing.
        dp[0] = 1
        prefix[0] = 1

        # Left boundary of the sliding window; window is [j..i].
        j = 0

        for i in range(n):
            # --------------------------------------------------------
            # Step 1: Extend the window to include nums[i],
            #         and update monotonic queues for max and min.
            # --------------------------------------------------------

            # Maintain max_q as a decreasing queue of values:
            # while the last element in max_q is <= nums[i],
            # it can never be the maximum for any future window
            # that includes nums[i], so we pop it.
            while max_q and nums[max_q[-1]] <= nums[i]:
                max_q.pop()
            max_q.append(i)

            # Maintain min_q as an increasing queue of values:
            # while the last element in min_q is >= nums[i],
            # it can never be the minimum for any future window
            # that includes nums[i], so we pop it.
            while min_q and nums[min_q[-1]] >= nums[i]:
                min_q.pop()
            min_q.append(i)

            # --------------------------------------------------------
            # Step 2: Shrink the window from the left until it becomes valid:
            #         max(nums[j..i]) - min(nums[j..i]) <= k
            #
            # The front of max_q and min_q always hold the indices
            # of the maximum and minimum within [j..i].
            # --------------------------------------------------------
            while max_q and min_q and nums[max_q[0]] - nums[min_q[0]] > k:
                # If the element leaving the window is currently used
                # as the maximum, remove it from the front.
                if max_q[0] == j:
                    max_q.popleft()
                # If the element leaving the window is currently used
                # as the minimum, remove it from the front.
                if min_q[0] == j:
                    min_q.popleft()
                # Move the left boundary of the window to the right.
                j += 1

            # --------------------------------------------------------
            # Step 3: Compute dp[i+1].
            #
            # For the prefix nums[0..i], consider the last segment that ends at i:
            # it must be nums[t..i] for some t in [j..i], because j is the smallest
            # index such that nums[j..i] is valid (max-min <= k).
            #
            # For each such t, the number of ways is dp[t] (partitioning nums[0..t-1]),
            # so:
            #   dp[i+1] = sum(dp[t] for t in range(j, i+1)).
            #
            # With prefix sums,
            #   sum(dp[j..i]) = prefix[i] - prefix[j-1]   (when j > 0)
            #                 = prefix[i]                 (when j == 0).
            # --------------------------------------------------------
            if j > 0:
                dp[i + 1] = (prefix[i] - prefix[j - 1] + mod) % mod
            else:
                dp[i + 1] = prefix[i] % mod

            # --------------------------------------------------------
            # Step 4: Update prefix sums.
            # --------------------------------------------------------
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod

        # dp[n] = number of valid ways to partition the entire array nums[0..n-1].
        return dp[n]


# @lc code=end
