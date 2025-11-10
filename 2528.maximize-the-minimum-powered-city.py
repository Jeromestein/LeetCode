#
# @lc app=leetcode id=2528 lang=python3
#
# [2528] Maximize the Minimum Powered City
#

# @lc code=start


class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        n = len(stations)
        cnt = [0] * (n + 1)

        # Build prefix difference array to compute power coverage
        # Each power station at i affects cities in range [i - r, i + r]
        for i in range(n):
            left = max(0, i - r)
            right = min(n, i + r + 1)
            cnt[left] += stations[i]
            cnt[right] -= stations[i]

        # Check if it's possible to make every city's power >= val
        def check(val: int) -> bool:
            # Copy base power difference array
            diff = cnt.copy()
            total = 0  # Current cumulative power
            remaining = k  # Remaining stations we can add

            # Traverse each city from left to right
            for i in range(n):
                total += diff[
                    i
                ]  # Current city’s total power after all previous adjustments

                if total < val:
                    # Need to add extra power stations
                    add = val - total
                    if remaining < add:
                        # Not enough stations to reach required power
                        return False
                    remaining -= add
                    end = min(n, i + 2 * r + 1)
                    # Apply difference update — this added power affects future cities
                    diff[end] -= add
                    total += add  # Update current total power
            return True

        # Binary search for the maximum minimal power possible
        lo, hi = min(stations), sum(stations) + k
        res = 0
        while lo <= hi:
            mid = (lo + hi) // 2
            if check(mid):
                res = mid  # It's possible to achieve at least mid power
                lo = mid + 1  # Try higher
            else:
                hi = mid - 1  # Too high, try lower
        return res


# @lc code=end
