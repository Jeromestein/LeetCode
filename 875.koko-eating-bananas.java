/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hours(piles, mid) > h) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int hours(int[] piles, int k) {
        int sumHours = 0;
        for (int i = 0; i < piles.length; i++) {
            int a = piles[i] / k;
            int b = piles[i] % k;
            if (b != 0) {
                sumHours += a + 1;
            } else {
                sumHours += a;
            }
        }
        return sumHours;
    }
}
// @lc code=end
