#
# @lc app=leetcode id=3000 lang=python3
#
# [3000] Maximum Area of Longest Diagonal Rectangle
#

# @lc code=start


class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        longest_diagonal = 0
        area = 0

        for d in dimensions:
            diagonal = d[0] * d[0] + d[1] * d[1]
            if diagonal > longest_diagonal:
                longest_diagonal = diagonal
                area = d[0] * d[1]
            if diagonal == longest_diagonal:
                area = max(area, d[0] * d[1])

        return area


# @lc code=end
