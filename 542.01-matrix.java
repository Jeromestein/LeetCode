import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
// class Solution {
//     int[][] disToZero;
//     boolean[][] visit;
//     int[][] Delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

//     public int[][] updateMatrix(int[][] mat) {
//         int row = mat.length, col = mat[0].length;
//         disToZero = new int[row][col];
//         visit = new boolean[row][col];
//         Queue<int[]> idxQueue = new LinkedList<>();
//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 if (mat[i][j] == 0) {
//                     disToZero[i][j] = 0;
//                     visit[i][j] = true;
//                     idxQueue.add(new int[] { i, j });
//                 }
//             }
//         }

//         while (!idxQueue.isEmpty()) {
//             int[] idx = idxQueue.poll();
//             int i = idx[0], j = idx[1];
//             for (int k = 0; k < 4; k++) {
//                 int x = i + Delta[k][0], y = j + Delta[k][1];
//                 if (0 <= x && x < row && 0 <= y && y < col && !visit[x][y]) {
//                     visit[x][y] = true;
//                     disToZero[x][y] = disToZero[i][j] + 1;
//                     idxQueue.add(new int[] { x, y });
//                 }
//             }
//         }
//         return disToZero;
//     }
// }
class Solution {
    static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化动态规划的数组，所有的距离值都设置为一个很大的数
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }
        // 如果 (i, j) 的元素为 0，那么距离为 0
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i + 1 < m) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }
}
// @lc code=end
