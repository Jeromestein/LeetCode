#
# @lc app=leetcode id=3446 lang=python3
#
# [3446] Sort Matrix by Diagonals
#


# @lc code=start
class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        # 0,n-1
        # 0,n-2; 1,n-1
        # ...
        # n-1,0
        DIR = (1, 1)
        for i in range(n - 1):
            x = 0
            y = n - 1 - i
            # print("x,y:", x,y)
            diagonal_idx = []
            diagonal_val = []
            # get diagonal
            while x >= 0 and x < n and y >= 0 and y < n:
                diagonal_idx.append((x, y))
                diagonal_val.append(grid[x][y])
                x += DIR[0]
                y += DIR[1]

            diagonal_val.sort()
            # print(diagonal_val)
            m = len(diagonal_idx)
            for j in range(m):
                nx, ny = diagonal_idx[j]
                grid[nx][ny] = diagonal_val[j]

        for i in range(n):
            x = i
            y = 0
            # print("x,y:", x,y)
            diagonal_idx = []
            diagonal_val = []
            # get diagonal
            while x >= 0 and x < n and y >= 0 and y < n:
                diagonal_idx.append((x, y))
                diagonal_val.append(grid[x][y])
                x += DIR[0]
                y += DIR[1]

            diagonal_val.sort(reverse=True)
            # print(diagonal_val)
            m = len(diagonal_idx)
            for j in range(m):
                nx, ny = diagonal_idx[j]
                grid[nx][ny] = diagonal_val[j]

        return grid


# @lc code=end
