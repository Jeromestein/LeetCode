#
# @lc app=leetcode id=36 lang=python3
#
# [36] Valid Sudoku
#


# @lc code=start
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # A Sudoku board (partially filled) could be valid
        # but is not necessarily solvable.

        # check row
        for i in range(9):
            s = set()
            for j in range(9):
                curr = board[i][j]
                if curr == ".":
                    continue

                num = int(curr)
                if num in s:
                    return False
                else:
                    s.add(num)

        # check column
        for j in range(9):
            s = set()
            for i in range(9):
                curr = board[i][j]
                if curr == ".":
                    continue

                num = int(curr)
                if num in s:
                    return False
                else:
                    s.add(num)

        # check sub-box
        for i in range(3):
            for j in range(3):
                # sub box
                s = set()
                for x in range(3):
                    for y in range(3):
                        curr = board[3 * i + x][3 * j + y]
                        if curr == ".":
                            continue

                        num = int(curr)
                        if num in s:
                            return False
                        else:
                            s.add(num)

        return True


# @lc code=end
