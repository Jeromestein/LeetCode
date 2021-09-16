/*
 * @lc app=leetcode id=292 lang=java
 *
 * [292] Nim Game
 */

// @lc code=start
class Solution {
    public boolean canWinNim(int n) {
        if (n < 4)
            return true;
        // 1<=n<=2^31-1
        // boolean[] dp = new boolean[n + 1];
        // dp[1] = dp[2] = dp[3] = true;

        // for (int i = 4; i <= n; i++) {
        // dp[i] = !dp[i - 1] || !dp[i - 2] || !dp[i - 3];
        // }

        // return dp[n];
        return n % 4 != 0;
    }
}
// @lc code=end
