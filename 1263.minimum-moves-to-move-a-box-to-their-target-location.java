/*
 * @lc app=leetcode id=1263 lang=java
 *
 * [1263] Minimum Moves to Move a Box to Their Target Location
 */

// @lc code=start
class Solution {
    // Time : O(n^2) ?
    // Space: O(m*n) ?
    char[][] grid;
    int m, n;
    int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // right, down, left, up

    public int minPushBox(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int step = 0;
        boolean[][][] visited = new boolean[m][n][4]; // considering 4 directons

        Queue<int[]> boxQ = new LinkedList<>();
        Queue<int[]> playerQ = new LinkedList<>();
        int[] boxLoc = new int[2], targetLoc = new int[2], playerLoc = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B')
                    boxLoc = new int[] { i, j };
                if (grid[i][j] == 'T')
                    targetLoc = new int[] { i, j };
                if (grid[i][j] == 'S')
                    playerLoc = new int[] { i, j };
            }
        }
        boxQ.offer(new int[] { boxLoc[0], boxLoc[1] });
        playerQ.offer(new int[] { playerLoc[0], playerLoc[1] });

        while (!boxQ.isEmpty()) {
            for (int i = 0, l = boxQ.size(); i < l; i++) { // as we care about all directions, it should be like
                                                           // this.--> it's related to calculating 'step'
                int[] currBoxLoc = boxQ.poll();
                int[] currPlayerLoc = playerQ.poll();
                if (currBoxLoc[0] == targetLoc[0] && currBoxLoc[1] == targetLoc[1])
                    return step; // If box arrives at the target, it returns 'step'
                for (int j = 0; j < dir.length; j++) { // Checking all directions
                    if (visited[currBoxLoc[0]][currBoxLoc[1]][j])
                        continue;
                    int[] d = dir[j];
                    int r0 = currBoxLoc[0] + d[0], c0 = currBoxLoc[1] + d[1]; // where player stands, need a space to
                                                                              // push
                    if (r0 < 0 || r0 >= m || c0 < 0 || c0 >= n || grid[r0][c0] == '#')
                        continue; // if no space, ignore(/continue)
                    int r = currBoxLoc[0] - d[0], c = currBoxLoc[1] - d[1]; // the box location after pushed
                    if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '#')
                        continue; // if no space for box, ignore(/continue)
                    if (!reachable(r0, c0, currBoxLoc, currPlayerLoc))
                        continue; // Check if the player can reach (r0, c0). if not, continue
                    visited[currBoxLoc[0]][currBoxLoc[1]][j] = true; // After pushed, the player is at 'currBoxLoc'.
                    boxQ.offer(new int[] { r, c }); // update queues accordingly.
                    playerQ.offer(new int[] { currBoxLoc[0], currBoxLoc[1] });
                }
            }
            step++;
        }
        return -1;
    }

    private boolean reachable(int i, int j, int[] boxLoc, int[] playerLoc) {
        // (i,j) is a location where the play will push the box.
        Queue<int[]> q = new LinkedList<>();
        q.offer(playerLoc);
        boolean[][] visited = new boolean[m][n];
        visited[boxLoc[0]][boxLoc[1]] = true; // player cannot go through the spot where the box is located at.
        while (!q.isEmpty()) {
            int[] currPlLoc = q.poll();
            if (currPlLoc[0] == i && currPlLoc[1] == j)
                return true;
            for (int[] d : dir) {
                int r = currPlLoc[0] + d[0], c = currPlLoc[1] + d[1]; // player's location after moving
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] == '#')
                    continue; // check if player can move to (r,c)
                visited[r][c] = true; // if possible, check it visited.
                q.offer(new int[] { r, c });
            }
        }
        return false;
    }
}
// @lc code=end
