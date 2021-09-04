/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k == 0 || n == 0) {
            return 0;
        }

        int[] buys = new int[k];
        int[] sells = new int[k];
        for (int i = 0; i < k; i++) {
            buys[i] = -prices[0];
            sells[i] = 0;
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    buys[j] = Math.max(buys[j], -prices[i]);
                } else {
                    buys[j] = Math.max(buys[j], sells[j - 1] - prices[i]);
                }
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
            }
        }
        return sells[k - 1];
    }
}

// @lc code=end
