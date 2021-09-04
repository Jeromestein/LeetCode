/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start

class Solution {
    public int uniquePaths(int m, int n) {
        // rolling array
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}

// class Solution {
// public int uniquePaths(int m, int n) {
// long ans = 1;
// // total m+n-2 moves, m-1 down moves, n-1 right moves.
// // C(m-1,m+n-2)
// for (int x = n, y = 1; y < m; x++, y++) {
// ans = ans * x / y;
// }
// return (int) ans;
// }
// }

// @lc code=end
