#
# @lc app=leetcode id=2257 lang=python3
#
# [2257] Count Unguarded Cells in the Grid
#


# @lc code=start
class Solution:
    def countUnguarded(
        self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]
    ) -> int:
        guards_set = {(r, c) for r, c in guards}
        walls_set = {(r, c) for r, c in walls}
        seen = set()
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        for r, c in guards:
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                while (
                    0 <= nr < m
                    and 0 <= nc < n
                    and (nr, nc) not in walls_set
                    and (nr, nc) not in guards_set
                ):
                    seen.add((nr, nc))
                    nr += dr
                    nc += dc
        return m * n - len(walls_set) - len(guards_set) - len(seen)


# @lc code=end
