import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start

class Solution {
    //
    private boolean[][] row = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    // the space of empty units
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[] { i, j });
                } else {
                    // the range is [1,9], but idx starts from 0
                    int digit = board[i][j] - '0' - 1;
                    // digit is in row i, column j, and block[i/3][j/3]
                    row[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    // cnt is the no. of filled units which were empty
    public void dfs(char[][] board, int cnt) {
        if (cnt == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(cnt);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!row[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                row[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, cnt + 1);
                row[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}

// @lc code=end
