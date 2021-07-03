import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Queue<int[]> idxQueue = new LinkedList<>();
        // find original rotten oranges
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    idxQueue.add(new int[] { i, j });
                }
            }
        }

        int minutes = 0;
        while (!idxQueue.isEmpty()) {
            // the no. of current rotten oranges
            int currRotOrgs = idxQueue.size();

            for (int i = 0; i < currRotOrgs; i++) {
                int[] idx = idxQueue.poll();
                int x0 = idx[0], y0 = idx[1];

                for (int k = 0; k < 4; k++) {
                    int x = x0 + dx[k], y = y0 + dy[k];
                    if (0 <= x && x < row && 0 <= y && y < col && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        idxQueue.add(new int[] { x, y });
                    }
                }
            }
            minutes++;
        }
        // this last round does nothing
        if (minutes > 0) {
            minutes--;
        }

        // end of process, to check if there are still fresh oranges left
        for (int[] rows : grid)
            for (int cell : rows)
                // still got a fresh orange left
                if (cell == 1)
                    return -1;

        return minutes;
    }
}
// class Solution {
// public int orangesRotting(int[][] grid) {
// int ROWS = grid.length, COLS = grid[0].length;
// int timestamp = 2;
// while (runRottingProcess(timestamp, grid, ROWS, COLS))
// timestamp++;

// // end of process, to check if there are still fresh oranges left
// for (int[] row : grid)
// for (int cell : row)
// // still got a fresh orange left
// if (cell == 1)
// return -1;

// // return elapsed minutes if no fresh orange left
// return timestamp - 2;
// }

// public boolean runRottingProcess(int timestamp, int[][] grid, int ROWS, int
// COLS) {
// int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
// // flag to indicate if the rotting process should be continued
// boolean toBeContinued = false;
// for (int row = 0; row < ROWS; ++row)
// for (int col = 0; col < COLS; ++col)
// if (grid[row][col] == timestamp)
// // current contaminated cell
// for (int[] d : directions) {
// int nRow = row + d[0], nCol = col + d[1];
// if (nRow >= 0 && nRow < ROWS && nCol >= 0 && nCol < COLS)
// if (grid[nRow][nCol] == 1) {
// // this fresh orange would be contaminated next
// grid[nRow][nCol] = timestamp + 1;
// toBeContinued = true;
// }
// }
// return toBeContinued;
// }
// }
// @lc code=end
