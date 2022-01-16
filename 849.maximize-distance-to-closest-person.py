#
# @lc app=leetcode id=849 lang=python3
#
# [849] Maximize Distance to Closest Person
#

# @lc code=start

class Solution(object):
    def maxDistToClosest(self, seats):
        ans = seats.index(1)
        seats.reverse()
        ans = max(ans, seats.index(1))
        for seat, group in itertools.groupby(seats):
            if seat == 0:
                # K is the current longest group of empty seats
                K = len(list(group))
                ans = max(ans, (K+1)//2)

        return ans


# @lc code=end
