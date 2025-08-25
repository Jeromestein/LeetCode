#
# @lc app=leetcode id=498 lang=python3
#
# [498] Diagonal Traverse
#


# @lc code=start
class Solution:
    def findDiagonalOrder(self, mat):
        n, m = len(mat), len(mat[0])
        res = []
        right_up = True
        for d in range(n + m - 1):
            if right_up:
                # indices: (r, c) = (d - j, j)
                j0 = max(0, d - (n - 1))
                j1 = min(d, m - 1)
                for j in range(j0, j1 + 1):
                    res.append(mat[d - j][j])
            else:
                # indices: (r, c) = (j, d - j)
                r0 = max(0, d - (m - 1))
                r1 = min(d, n - 1)
                for r in range(r0, r1 + 1):
                    res.append(mat[r][d - r])
            right_up = not right_up
        return res


# @lc code=end
