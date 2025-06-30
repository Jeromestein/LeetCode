#
# @lc app=leetcode id=74 lang=python3
#
# [74] Search a 2D Matrix
#

# @lc code=start

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m*n-1

        while left <= right:
            mid = (left+right)//2
            row, col = mid//n, mid % n
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                left = mid+1
            else:
                right = mid-1

        return False


# @lc code=end
