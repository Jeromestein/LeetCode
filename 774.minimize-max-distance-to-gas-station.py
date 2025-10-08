#
# @lc app=leetcode id=774 lang=python3
#
# [774] Minimize Max Distance to Gas Station
#

# @lc code=start


class Solution(object):
    def minmaxGasDist(self, stations, K):
        # Helper function:
        # Return True if we can ensure that the maximum distance
        # between adjacent stations is <= D
        # by adding at most K new stations.
        def possible(D):
            # For each segment between two existing stations,
            # calculate how many additional stations are needed
            # to make every sub-distance <= D
            return (
                sum(
                    int((stations[i + 1] - stations[i]) / D)
                    for i in range(len(stations) - 1)
                )
                <= K
            )

        # Binary search range:
        # lo = minimum possible distance (0)
        # hi = maximum possible distance (large enough upper bound)
        lo, hi = 0, 10**8

        # Continue binary search until the precision threshold is small enough
        while hi - lo > 1e-6:
            mi = (lo + hi) / 2.0  # mid = current guess for max distance

            # If it's possible to achieve max gap ≤ mi with ≤ K stations,
            # try smaller D (narrow the upper bound)
            if possible(mi):
                hi = mi
            else:
                # Otherwise, need a larger D (not enough K stations)
                lo = mi

        # The minimal possible max distance is approximately lo (or hi)
        return lo


# @lc code=end
