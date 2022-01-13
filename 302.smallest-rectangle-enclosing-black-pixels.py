#
# @lc app=leetcode id=302 lang=python3
#
# [302] Smallest Rectangle Enclosing Black Pixels
#

# @lc code=start

class Solution(object):
    def minArea(self, image, x, y):
        m, n = len(image), len(image[0])
        # binary search [0, x) to find top
        top = self.searchRows(image, 0, x, True)
        # [x+1, m)
        bottom = self.searchRows(image, x + 1, m, False)
        # [0, y)
        left = self.searchColumns(image, 0, y, top, bottom, True)
        # [y+1, n)
        right = self.searchColumns(image, y + 1, n, top, bottom, False)
        return (right - left) * (bottom - top)

    def searchRows(self, image, i, j, opt):
        while i != j:
            m = (i + j) // 2
            # find '1' in string image[m]
            if ('1' in image[m]) == opt:
                j = m
            else:
                i = m + 1
        return i

    def searchColumns(self, image, i, j, top, bottom, opt):
        while i != j:
            m = (i + j) // 2
            if any(image[k][m] == '1' for k in range(top, bottom)) == opt:
                j = m
            else:
                i = m + 1
        return i


# @lc code=end
