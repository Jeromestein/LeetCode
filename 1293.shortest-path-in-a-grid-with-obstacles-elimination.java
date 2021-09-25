/*
 * @lc app=leetcode id=1293 lang=java
 *
 * [1293] Shortest Path in a Grid with Obstacles Elimination
 */

// @lc code=start

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        if (row == 1 && col == 1) {
            return 0;
        }

        // direction matrix
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Deque<int[]> queue = new LinkedList<>();
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                visited[i][j] = -1;
            }
        }

        queue.offerLast(new int[] { 0, 0, k });
        visited[0][0] = k;
        int step = 0;

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            step++;
            for (int i = 0; i < currSize; ++i) {
                int[] currPos = queue.pollFirst();

                for (int j = 0; j < 4; ++j) {
                    int nx = currPos[0] + dirs[j][0];
                    int ny = currPos[1] + dirs[j][1];
                    int currK = currPos[2];
                    // make sure its in matrix
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        // check if get rightdown point
                        // assumed grid[0][0] == grid[m-1][n-1] == 0，if grid[m-1][n-1] could be 1???
                        if (nx == row - 1 && ny == col - 1) {
                            return step;
                        }

                        currK = grid[nx][ny] == 0 ? currK : currK - 1;

                        if (currK >= 0) {
                            // -1 means never pass here before
                            if (visited[nx][ny] == -1 || (visited[nx][ny] != -1 && currK > visited[nx][ny])) {
                                queue.offerLast(new int[] { nx, ny, currK });
                                // record the currK at that step
                                visited[nx][ny] = currK;
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}

// @lc code=end
