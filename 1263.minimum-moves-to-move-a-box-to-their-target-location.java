/*
 * @lc app=leetcode id=1263 lang=java
 *
 * [1263] Minimum Moves to Move a Box to Their Target Location
 */

// @lc code=start
class Solution {
    char[][] g;
    int m, n;
    int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int minPushBox(char[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;

        // 2D is not enough, still need one more dimension to represent four direction
        boolean[][][] visit = new boolean[m][n][4];

        Queue<int[]> q = new LinkedList<>();
        int[] st = new int[] { -1, -1 }, target = new int[] { -1, -1 }, pl = new int[] { -1, -1 };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 'B')
                    st = new int[] { i, j };
                if (g[i][j] == 'T')
                    target = new int[] { i, j };
                if (g[i][j] == 'S')
                    pl = new int[] { i, j };
            }
        }
        // alwasys add the current box coordinate and the player current coordinate
        q.offer(new int[] { st[0], st[1], pl[0], pl[1] });
        int step = 0;
        while (!q.isEmpty()) {
            for (int i = 0, l = q.size(); i < l; i++) {
                int[] curr = q.poll();
                // get to the target
                if (curr[0] == target[0] && curr[1] == target[1])
                    return step;
                for (int k = 0; k < 4; k++) {
                    if (visit[curr[0]][curr[1]][k])
                        continue;
                    // where pl stands, have room to push;
                    int r0 = curr[0] + dir[k][0], c0 = curr[1] + dir[k][1];
                    if (r0 < 0 || r0 >= m || c0 < 0 || c0 >= n || g[r0][c0] == '#')
                        continue;
                    // box next spots;
                    int nextr = curr[0] - dir[k][0], nextc = curr[1] - dir[k][1];
                    if (nextr < 0 || nextr >= m || nextc < 0 || nextc >= n || g[nextr][nextc] == '#')
                        continue;
                    if (!reachable(r0, c0, curr))
                        continue;
                    visit[curr[0]][curr[1]][k] = true;
                    int plr = curr[0], plc = curr[1];
                    q.offer(new int[] { nextr, nextc, plr, plc });
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 1. has room to push the box; 2. has a way to go to the room to push the box.
     * Therefore you need another bfs to find if the path exist;
     */
    private boolean reachable(int i, int j, int[] curr) {
        Queue<int[]> q = new LinkedList<>();
        // start from the player's current place
        q.offer(new int[] { curr[2], curr[3] });
        boolean[][] visit = new boolean[m][n];
        // set the box position as a block
        visit[curr[0]][curr[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == i && cur[1] == j)
                return true;
            for (int[] d : dir) {
                int r = cur[0] - d[0], c = cur[1] - d[1]; // box next spots;
                if (r < 0 || r >= m || c < 0 || c >= n || visit[r][c] || g[r][c] == '#')
                    continue;
                visit[r][c] = true;
                q.offer(new int[] { r, c });
            }
        }
        return false;
    }
}
// @lc code=end
