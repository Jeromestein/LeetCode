#
# @lc app=leetcode id=37 lang=python3
#
# [37] Sudoku Solver
#

# @lc code=start
from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Solve Sudoku in-place using backtracking + bitmasks.
        The board is a 9x9 grid with digits '1'..'9' and '.' for empty cells.
        """

        # row_mask[i], col_mask[j], box_mask[b] are 9-bit masks indicating
        # which digits (1..9) are already used in row i / col j / 3x3 box b.
        # Bit k (0-based) corresponds to digit (k+1).
        row_mask = [0] * 9
        col_mask = [0] * 9
        box_mask = [0] * 9

        empties = []  # list of coordinates (i, j) for empty cells

        def box_id(i: int, j: int) -> int:
            """Return 0..8 index of 3x3 sub-box containing (i, j)."""
            return (i // 3) * 3 + (j // 3)

        def set_digit(i: int, j: int, d: int) -> None:
            """Place digit d (0-based: 0..8 => '1'..'9') at (i, j) and set masks."""
            bit = 1 << d
            board[i][j] = chr(ord("1") + d)
            row_mask[i] |= bit
            col_mask[j] |= bit
            box_mask[box_id(i, j)] |= bit

        def unset_digit(i: int, j: int, d: int) -> None:
            """Remove digit d from (i, j) and unset masks (backtracking)."""
            bit = 1 << d
            board[i][j] = "."
            row_mask[i] ^= bit
            col_mask[j] ^= bit
            box_mask[box_id(i, j)] ^= bit

        # 1) Initialize masks from the given board and collect empty cells.
        for i in range(9):
            for j in range(9):
                c = board[i][j]
                if c == ".":
                    empties.append((i, j))
                else:
                    d = ord(c) - ord("1")  # 0..8
                    set_digit(i, j, d)  # sets masks only (board stays same)

        # 2) Backtracking: fill empties[idx:] one by one.
        #    We choose the next cell greedily (MRV heuristic) to speed up:
        #    pick the empty with the fewest candidates.
        def solve(idx: int) -> bool:
            if idx == len(empties):
                return True  # all filled

            # Pick the best position (minimum remaining candidates)
            best = idx
            best_count = 10  # larger than any possible candidate count (<=9)
            for k in range(idx, len(empties)):
                i, j = empties[k]
                used = row_mask[i] | col_mask[j] | box_mask[box_id(i, j)]
                cand = (~used) & 0x1FF  # available digits (9 bits)
                cnt = cand.bit_count()
                if cnt < best_count:
                    best_count = cnt
                    best = k
                    if cnt == 1:
                        break  # can't get better than 1

            # If no candidate exists for some cell, prune
            if best_count == 0:
                return False

            # Swap the chosen cell to position idx
            empties[idx], empties[best] = empties[best], empties[idx]
            i, j = empties[idx]

            # Try all candidates for (i, j)
            used = row_mask[i] | col_mask[j] | box_mask[box_id(i, j)]
            cand = (~used) & 0x1FF  # 9-bit mask of candidates

            # Iterate set bits of cand using lowbit trick
            while cand:
                low = cand & -cand  # lowest set bit
                d = low.bit_length() - 1  # 0..8 digit index
                set_digit(i, j, d)
                if solve(idx + 1):
                    return True
                unset_digit(i, j, d)
                cand ^= low  # remove this candidate and continue

            # Restore the order (optional for correctness but neat)
            empties[idx], empties[best] = empties[best], empties[idx]
            return False

        solve(0)


# @lc code=end
