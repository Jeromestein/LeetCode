/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    int[][] orientation8 = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };

    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;

        // count neighbors
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = countNeighbors(board, i, j);
            }
        }

        // get next state based on no. of neighbors
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = nextState(board[i][j]);
            }
        }

    }

    public int countNeighbors(int[][] board, int i, int j) {
        int row = board.length, col = board[0].length;
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + orientation8[k][0], y = j + orientation8[k][1];
            if (0 <= x && x < row && 0 <= y && y < col && board[x][y] > 0)
                cnt++;
        }

        if (board[i][j] > 0) {
            // aviod positive zero and negtive zero
            // if cnt==0 && board[i][j] > 0, let cnt=1
            return cnt + 1;
        } else {
            return cnt * -1;
        }
    }

    public int nextState(int neighbors) {
        // aviod positive zero and negtive zero
        // if cnt==0 && board[i][j] > 0, let cnt=1
        // so if neighbors > 0, let negtive--
        if (neighbors > 0)
            neighbors--;

        if (neighbors < 0) {
            // current state is dead
            if (neighbors == -3) {
                // Any dead cell with exactly three live neighbors becomes a live cell
                return 1;
            } else {
                return 0;
            }
        } else {
            // current state is live
            if (neighbors < 2 || neighbors > 3) {
                // Any live cell with fewer than two live neighbors dies
                // Any live cell with more than three live neighbors dies
                return 0;
            } else {
                // Any live cell with two or three live neighbors lives
                return 1;
            }
        }
    }
}
// @lc code=end
