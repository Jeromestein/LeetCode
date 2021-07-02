import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    int[][] visit;

    public int numIslands(char[][] grid) {
        // An island is surrounded by water and is formed
        // by connecting adjacent lands horizontally or vertically.

        int IslandsCNT = 0;
        Queue<int[]> idxQueue = new LinkedList<>();
        visit = new int[grid.length][grid[0].length];

        // find the first '1'
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    IslandsCNT++;
                    // i: row
                    // j: column
                    idxQueue.add(new int[] { i, j });
                    grid[i][j] = '0';

                    while (!idxQueue.isEmpty()) {
                        // idx[0]: i: row
                        // idx[1]: j: column
                        int[] idx = idxQueue.poll();
                        int row = idx[0], col = idx[1];
                        // System.out.println("(" + row + "," + col + ")");
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            idxQueue.add(new int[] { row - 1, col });
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
                            idxQueue.add(new int[] { row + 1, col });
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            idxQueue.add(new int[] { row, col - 1 });
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
                            idxQueue.add(new int[] { row, col + 1 });
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return IslandsCNT;
    }
}
// @lc code=end
