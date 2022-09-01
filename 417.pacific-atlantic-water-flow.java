import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    int rows, cols;
    int[][] m;
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        m = matrix;

        // 1. from ocean to island, find all the cells that ocean can reach
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            pacificQ.add(new int[] { i, 0 });
            atlanticQ.add(new int[] { i, cols - 1 });
        }
        for (int i = 0; i < cols; i++) {
            pacificQ.add(new int[] { 0, i });
            atlanticQ.add(new int[] { rows - 1, i });
        }

        boolean[][] isPacificReachable = bfs(pacificQ);
        boolean[][] isAtlanticReachable = bfs(atlanticQ);

        // 2. add cells reaching both oceans to 2D list
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPacificReachable[i][j] && isAtlanticReachable[i][j]) {
                    // 2D list
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private boolean[][] bfs(Queue<int[]> q) {
        boolean[][] isReachable = new boolean[rows][cols];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            isReachable[curr[0]][curr[1]] = true;

            for (int[] dir : directions) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        !isReachable[newRow][newCol] &&
                        m[curr[0]][curr[1]] <= m[newRow][newCol]) {
                    q.add(new int[] { newRow, newCol });
                }
            }
        }

        return isReachable;
    }
}
// @lc code=end
