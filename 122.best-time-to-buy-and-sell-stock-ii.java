/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start

// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int maxProfit = 0;

//         int bottom = 0, peak = 0;
//         // basically, find the rising edge
//         while (peak < n && bottom < n - 1) {
//             // 1. find the bottom
//             while (bottom + 1 < n && prices[bottom] >= prices[bottom + 1]) {
//                 bottom++;
//             }
//             // 2. find the peak
//             peak = bottom;
//             while (peak + 1 < n && prices[peak] <= prices[peak + 1]) {
//                 peak++;
//             }

//             maxProfit += prices[peak] - prices[bottom];

//             bottom = peak;
//         }

//         return maxProfit;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
// @lc code=end
