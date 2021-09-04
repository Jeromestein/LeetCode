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
        // int buy1 = -prices[0], sell1 = 0;
        // int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            // buy1 = Math.max(buy1, -prices[i]);
            // sell1 = Math.max(sell1, buy1 + prices[i]);
            // buy2 = Math.max(buy2, sell1 - prices[i]);
            // sell2 = Math.max(sell2, buy2 + prices[i]);
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
