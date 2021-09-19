/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }

        // dp[i][j]: the times of t[j:n] appearance in s[i:m]
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][n]: the times of t[n:n] ("", empty string) appearance in s[i:m]
        // for 0<=i<=m, dp[i][n]=1;
        // dp[m][j]: the times of t[j:n] appearance in s[m:m] ("", empty string)
        // for 0<=j<n, dp[m][j]=0;
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}

// @lc code=end
