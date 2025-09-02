#
# @lc app=leetcode id=3025 lang=python3
#
# [3025] Find the Number of Ways to Place People I
#


# @lc code=start
class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        # Step 1. Sort points:
        # - Primary key: x coordinate in descending order (-p[0])
        # - Secondary key: y coordinate in ascending order (p[1])
        # Why? To ensure we process larger x first, and for the same x, smaller y first
        points.sort(key=lambda p: (-p[0], p[1]))

        n, res = len(points), 0

        # Step 2. Outer loop: choose a point P[i]
        for i in range(n - 1):
            # Initialize y as a very large value (infinity substitute)
            y = float("inf")

            # Step 3. Inner loop: look at all points after P[i]
            for j in range(i + 1, n):
                # Condition:
                #   1. P[j][1] >= P[i][1]   (y_j >= y_i)
                #   2. P[j][1] < y          (y_j is strictly smaller than the last chosen y)
                if y > points[j][1] >= points[i][1]:
                    res += 1  # Found a valid pair (i, j)
                    y = points[j][
                        1
                    ]  # Update "current best y" to enforce strict decreasing order

        return res


# @lc code=end
