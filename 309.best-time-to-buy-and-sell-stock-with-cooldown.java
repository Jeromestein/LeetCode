/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start

class Solution {
    public int maxProfit(int[] prices) {

        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, noMoves = 0;

        for (int price : prices) {
            // sold[i]=hold[i−1]+price[i]
            // held[i]=max(held[i−1],noMoves[i−1]−price[i])
            // noMoves[i]=max(noMoves[i−1],sold[i−1])
            int preSold = sold;

            sold = held + price;
            held = Math.max(held, noMoves - price);
            // no buy no sell, or cooldown
            noMoves = Math.max(noMoves, preSold);
        }

        return Math.max(sold, noMoves);
    }
}
// @lc code=end
