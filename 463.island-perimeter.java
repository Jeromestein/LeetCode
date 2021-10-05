/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start

class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dirs[k][0], nj = j + dirs[k][1];

                        if (ni < 0 || m <= ni || nj < 0 || n <= nj || grid[ni][nj] == 0) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;
    }
}
// @lc code=end
