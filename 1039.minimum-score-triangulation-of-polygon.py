#
# @lc app=leetcode id=1039 lang=python3
#
# [1039] Minimum Score Triangulation of Polygon
#

# @lc code=start


class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        from functools import lru_cache

        @lru_cache(None)
        def dp(i, j):
            # dp(i, j): the minimum score to triangulate the sub-polygon
            # defined by vertices from index i to j (inclusive)

            # Base case: fewer than 3 vertices → cannot form a triangle
            if i + 2 > j:
                return 0

            # Base case: exactly 3 vertices → only one possible triangle
            if i + 2 == j:
                return values[i] * values[i + 1] * values[j]

            # Recursive case:
            # Try every possible "k" as a middle vertex to form a triangle (i, k, j)
            # The score of this triangulation =
            #   score of triangle (i, k, j)
            #   + minimum triangulation of sub-polygon (i..k)
            #   + minimum triangulation of sub-polygon (k..j)
            return min(
                (values[i] * values[k] * values[j] + dp(i, k) + dp(k, j))
                for k in range(i + 1, j)
            )

        # The whole polygon is from 0 to n-1
        return dp(0, len(values) - 1)


# @lc code=end
