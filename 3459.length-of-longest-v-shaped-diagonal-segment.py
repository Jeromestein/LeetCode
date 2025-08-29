#
# @lc app=leetcode id=3459 lang=python3
#
# [3459] Length of Longest V-Shaped Diagonal Segment
#

# @lc code=start


from typing import List
from functools import lru_cache


class Solution:
    def lenOfVDiagonal(self, grid: List[List[int]]) -> int:
        # SE, SW, NW, NE (clockwise order)
        DIRS = [(1, 1), (1, -1), (-1, -1), (-1, 1)]
        m, n = len(grid), len(grid[0])

        def in_bounds(x: int, y: int) -> bool:
            return 0 <= x < m and 0 <= y < n

        @cache
        def dfs(x: int, y: int, dir_idx: int, can_turn: bool, target: int) -> int:
            """
            Return the max number of further steps starting from (x,y),
            moving one step first (must match `target`), then optionally
            continuing straight or making at most one clockwise 90° turn.
            """
            nx, ny = x + DIRS[dir_idx][0], y + DIRS[dir_idx][1]
            # next cell must be inside and equal to `target`
            if not in_bounds(nx, ny) or grid[nx][ny] != target:
                return 0

            # 1) continue straight
            best = dfs(nx, ny, dir_idx, can_turn, 2 - target)  # toggle target: 2<->0

            # 2) optional clockwise turn (only once)
            if can_turn:
                nd = (dir_idx + 1) % 4
                best = max(best, dfs(nx, ny, nd, False, 2 - target))

            return best + 1  # count current step

        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:  # start only from cells with value 1
                    for d in range(4):
                        # start length is 1 (the starting cell), then extend
                        ans = max(ans, 1 + dfs(i, j, d, True, 2))
        return ans


# @lc code=end
