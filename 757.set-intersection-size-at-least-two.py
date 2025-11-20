#
# @lc app=leetcode id=757 lang=python3
#
# [757] Set Intersection Size At Least Two
#

# @lc code=start


class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        # Sort intervals by:
        #   1. Right endpoint ascending
        #   2. Left endpoint descending (to handle equal right endpoints)
        intervals.sort(key=lambda x: (x[1], -x[0]))

        count = 0  # total number of selected points
        second_last = -1  # second largest point in the chosen set
        last = -1  # largest point in the chosen set

        for left, right in intervals:

            # Case 1:
            # No selected points lie in the interval [left, right]
            # Because even the largest point ('last') is < left
            # → we must add TWO points (right-1, right)
            if left > last:
                second_last = right - 1
                last = right
                count += 2

            # Case 2:
            # Exactly one selected point lies in [left, right]
            # This happens if:
            #   second_last < left <= last
            # → we must add ONE point (right)
            elif left > second_last:
                second_last = last
                last = right
                count += 1

            # Case 3:
            # Already have two points in the interval, do nothing.
            else:
                continue

        return count


# @lc code=end
