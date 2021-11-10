/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start

class Solution {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public void solve(char[][] board) {
        // 1. check the border, any 'O'?
        // 2. find the 'O'region connected with the border 'O', marked as unflipped
        // 3. flip all the others

        // bfs, T-O(mn) S-O(mn)
        int m = board.length, n = board[0].length;
        boolean[][] still = new boolean[m][n];
        Deque<int[]> q = new LinkedList<>();
        // walk through border
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    q.add(new int[] { i, j });
                    still[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] idx = q.poll();
            int i = idx[0], j = idx[1];
            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k][0], nj = j + dirs[k][1];
                if (0 <= ni && ni < m && 0 <= nj && nj < n && !still[ni][nj] && board[ni][nj] == 'O') {
                    q.add(new int[] { ni, nj });
                    still[ni][nj] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!still[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }
}
// @lc code=end
