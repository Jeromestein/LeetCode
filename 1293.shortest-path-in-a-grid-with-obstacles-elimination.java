/*
 * @lc app=leetcode id=1293 lang=java
 *
 * [1293] Shortest Path in a Grid with Obstacles Elimination
 */

// @lc code=start
class Solution {
    int minSteps = Integer.MAX_VALUE;
    boolean[][] footPrint;
    // 4 directions
    int[] deltaI = { 1, -1, 0, 0 };
    int[] deltaJ = { 0, 0, 1, -1 };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        footPrint = new boolean[m][n];

        footPrint[0][0] = true;
        dfs(grid, k, 0, 0, 0);

        if (minSteps == Integer.MAX_VALUE)
            return -1;
        else
            return minSteps;
    }

    public void dfs(int[][] grid, int currk, int i, int j, int currSteps) {
        int m = grid.length, n = grid[0].length;
        if (i == m - 1 && j == n - 1) {
            minSteps = Math.min(minSteps, currSteps);
            return;
        }

        // go through all the directions
        for (int k = 0; k < 4; k++) {
            int ni = i + deltaI[k], nj = j + deltaJ[k];
            // make sure its int the matrix
            if (0 <= ni && ni < m && 0 <= nj && nj < n) {
                // make sure we never pass here
                if (!footPrint[ni][nj]) {
                    // make sure if its obstacle
                    if (grid[ni][nj] == 0) {
                        footPrint[ni][nj] = true;
                        dfs(grid, currk, ni, nj, currSteps + 1);
                        footPrint[ni][nj] = false;
                    }
                    if (grid[ni][nj] == 1 && currk > 0) {
                        //
                        footPrint[ni][nj] = true;
                        dfs(grid, currk - 1, ni, nj, currSteps + 1);
                        footPrint[ni][nj] = false;
                    }
                }
            }
        }

    }
}
// @lc code=end
