import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    int[][] disToZero;
    boolean[][] visit;
    int[][] Delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        disToZero = new int[row][col];
        visit = new boolean[row][col];
        Queue<int[]> idxQueue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    disToZero[i][j] = 0;
                    visit[i][j] = true;
                    idxQueue.add(new int[] { i, j });
                }
            }
        }

        while (!idxQueue.isEmpty()) {
            int[] idx = idxQueue.poll();
            int i = idx[0], j = idx[1];
            for (int k = 0; k < 4; k++) {
                int x = i + Delta[k][0], y = j + Delta[k][1];
                if (0 <= x && x < row && 0 <= y && y < col && !visit[x][y]) {
                    visit[x][y] = true;
                    disToZero[x][y] = disToZero[i][j] + 1;
                    idxQueue.add(new int[] { x, y });
                }
            }
        }
        return disToZero;
    }
}
// @lc code=end
