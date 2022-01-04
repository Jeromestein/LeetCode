#
# @lc app=leetcode id=568 lang=python3
#
# [568] Maximum Vacation Days
#

# @lc code=start

class Solution:
    def maxVacationDays(self, flights: List[List[int]], days: List[List[int]]) -> int:
        # k weeks, n cities
        # one chance to change city every week
        # return max possible vacation days
        n, k = len(days), len(days[0])  # n cities, k weeks
        dp = [0] + [float('-inf') for _ in range(n-1)]

        for week in range(k):
            curr = [float('-inf') for _ in range(n)]
            # double-for loop,
            # walk through all the permutations of start and end city
            for start in range(n):
                # end, haveFlight
                # 0, flights[start][0]
                # 1, flights[start][1]
                # ...
                # n-1, flights[start][n-1]
                for end, haveFlight in enumerate(flights[start]):
                    if haveFlight or start == end:
                        curr[end] = max(curr[end], dp[start] + days[end][week])
            # update DP table
            dp = curr

        return max(dp)

        # @lc code=end
