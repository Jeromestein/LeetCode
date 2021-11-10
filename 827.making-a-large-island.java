import java.util.Arrays;

/*
 * @lc app=leetcode id=827 lang=java
 *
 * [827] Making A Large Island
 */

// @lc code=start

class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int[][] grid;
    int N;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        N = grid.length;

        int index = 2, ans = 0;
        int[] area = new int[N * N + 2];
        // DFS every island and give it an index of island
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (grid[i][j] == 1) {
                    // get the size of it
                    area[index] = dfs(i, j, index);
                    ans = Math.max(ans, area[index]);
                    index++;
                }

        // traverse every 0 cell and count biggest island it can conntect
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet();
                    for (Integer move : neighbors(i, j)) {
                        int row = move / N, col = move % N;
                        if (grid[row][col] > 1) {
                            // add the index to seen
                            seen.add(grid[row][col]);
                        }
                    }
                    int sum = 1;
                    for (int e : seen)
                        sum += area[e];
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;
    }

    public int dfs(int i, int j, int index) {
        int size = 1;
        grid[i][j] = index;
        for (Integer move : neighbors(i, j)) {
            int row = move / N, col = move % N;
            if (grid[row][col] == 1) {
                grid[row][col] = index;
                size += dfs(row, col, index);
            }
        }

        return size;
    }

    public List<Integer> neighbors(int i, int j) {
        List<Integer> list = new ArrayList();
        for (int k = 0; k < 4; ++k) {
            int ni = i + dirs[k][0], nj = j + dirs[k][1];
            if (0 <= ni && ni < N && 0 <= nj && nj < N)
                list.add(ni * N + nj);
        }

        return list;
    }
}
// @lc code=end
