/*
 * @lc app=leetcode id=764 lang=java
 *
 * [764] Largest Plus Sign
 */

// @lc code=start

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], 1);
        for (int[] one : mines)
            dp[one[0]][one[1]] = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count = dp[j][i] == 0 ? 0 : count + 1;
                dp[j][i] = count;
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                count = dp[j][i] == 0 ? 0 : count + 1;
                dp[j][i] = Math.min(dp[j][i], count);
            }
        }
        int rs = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int[] arr = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                count = dp[i][j] == 0 ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            for (int j = 0; j < n; j++) {
                count = dp[i][j] == 0 ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
                rs = Math.max(rs, dp[i][j]);
            }
        }
        return rs;

    }
}

// @lc code=end
