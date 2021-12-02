/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start

// Why does DFS not work?
// Unfortunately, using dfs you'd have to try every possible path to the end.
// You'd have to mark a cell as unvisited after recurring the neighbors.
// But doing this in this problem would lead to TLE.
// For this reason, BFS is the best choice here.

// Why does DP not work?
// DP doesn't work because you will not calculate all 8 paths before calculating a path. 
// Let see 1,1 now all the 8 paths are valid but not all 8 paths are available to you. 
// That's the difference between this and other DP problems.

// Why should we consider non-overwriting method?
// You should always discuss the possibility of overwriting the input with your interviewer 
// and clarify what kind of environment your algorithm is expected to run in. 

// How to mark the path?
// We can mark the value of cell as the current distance (step), so after reaching 
// target, we can implement the backtracing method, check all the currDis-1 cell to find the pre step.
class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        int count = 0;
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == n - 1 && curr[1] == n - 1)
                    return count + 1;
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (0 <= nr && nr < n && 0 <= nc && nc < n && grid[nr][nc] == 0) {
                        q.add(new int[] { nr, nc });
                        // overwriting
                        // we can use a isVis[][] matrix to implement the non-overwriting one
                        grid[nr][nc] = 1;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}

// @lc code=end
