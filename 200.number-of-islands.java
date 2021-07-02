import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
// class Solution {
//     int[][] visit;

//     public int numIslands(char[][] grid) {
//         // An island is surrounded by water and is formed
//         // by connecting adjacent lands horizontally or vertically.

//         int IslandsCNT = 0;
//         Queue<int[]> idxQueue = new LinkedList<>();
//         visit = new int[grid.length][grid[0].length];

//         // find the first '1'
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[i].length; j++) {
//                 if (grid[i][j] == '1') {
//                     IslandsCNT++;
//                     // i: row
//                     // j: column
//                     idxQueue.add(new int[] { i, j });
//                     grid[i][j] = '0';

//                     while (!idxQueue.isEmpty()) {
//                         // idx[0]: i: row
//                         // idx[1]: j: column
//                         int[] idx = idxQueue.poll();
//                         int row = idx[0], col = idx[1];
//                         // System.out.println("(" + row + "," + col + ")");
//                         if (row - 1 >= 0 && grid[row - 1][col] == '1') {
//                             idxQueue.add(new int[] { row - 1, col });
//                             grid[row - 1][col] = '0';
//                         }
//                         if (row + 1 < grid.length && grid[row + 1][col] == '1') {
//                             idxQueue.add(new int[] { row + 1, col });
//                             grid[row + 1][col] = '0';
//                         }
//                         if (col - 1 >= 0 && grid[row][col - 1] == '1') {
//                             idxQueue.add(new int[] { row, col - 1 });
//                             grid[row][col - 1] = '0';
//                         }
//                         if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
//                             idxQueue.add(new int[] { row, col + 1 });
//                             grid[row][col + 1] = '0';
//                         }
//                     }
//                 }
//             }
//         }
//         return IslandsCNT;
//     }
// }

class Solution {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}

// @lc code=end
