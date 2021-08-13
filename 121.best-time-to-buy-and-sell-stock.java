/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start

public class Solution {
    public int maxProfit(int prices[]) {
        int allTimeMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < allTimeMin) {
                // allTimeMin means the min price before i
                allTimeMin = prices[i];
            } else if (prices[i] - allTimeMin > maxProfit) {
                maxProfit = prices[i] - allTimeMin;
            }
        }
        return maxProfit;
    }
}
// @lc code=end
