/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // at most m 0's and n 1's in the subset.
        int[] numZeros = new int[strs.length + 1];
        int[] numOnes = new int[strs.length + 1];

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                // strs[i] consists only of digits '0' and '1'.
                if (strs[i].charAt(j) == '0') {
                    numZeros[i + 1]++;
                } else {
                    numOnes[i + 1]++;
                }
            }
        }

        // int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int zeros = numZeros[i], ones = numOnes[i];
            // // for example, "0", the zeros=1, ones=0, still count 1.
            // // so for j and k, we should start from 0.
            // for (int j = 0; j <= m; j++) {
            // for (int k = 0; k <= n; k++) {
            // dp[i][j][k] = dp[i - 1][j][k];
            // if (j >= zeros && k >= ones) {
            // int notplusItemi = dp[i][j][k];
            // int plusItemi = dp[i - 1][j - zeros][k - ones] + 1;
            // dp[i][j][k] = Math.max(notplusItemi, plusItemi);
            // }
            // }
            // }
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    int notplusItemi = dp[j][k];
                    int plusItemi = dp[j - zeros][k - ones] + 1;
                    dp[j][k] = Math.max(notplusItemi, plusItemi);
                }
            }
        }

        return dp[m][n];
    }
}
// @lc code=end
