/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        // 1. 1+2+3+..+k = k(k+1)/2
        // 2. k(k+1)/2<=n
        // (k+0.5)^2-0.25<=2n
        // k=sqrt(2n+0.25)-0.5
        return (int) (Math.sqrt(2 * (double) n + 0.25) - 0.5);
    }
}
// @lc code=end
