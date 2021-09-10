/*
 * @lc app=leetcode id=764 lang=java
 *
 * [764] Largest Plus Sign
 */

// @lc code=start

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dis[i], 1);
        for (int[] one : mines)
            dis[one[0]][one[1]] = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count = dis[j][i] == 0 ? 0 : count + 1;
                dis[j][i] = count;
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                count = dis[j][i] == 0 ? 0 : count + 1;
                dis[j][i] = Math.min(dis[j][i], count);
            }
        }
        int rs = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int[] arr = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                count = dis[i][j] == 0 ? 0 : count + 1;
                dis[i][j] = Math.min(dis[i][j], count);
            }
            count = 0;
            for (int j = 0; j < n; j++) {
                count = dis[i][j] == 0 ? 0 : count + 1;
                dis[i][j] = Math.min(dis[i][j], count);
                rs = Math.max(rs, dis[i][j]);
            }
        }
        return rs;

    }
}

// @lc code=end
