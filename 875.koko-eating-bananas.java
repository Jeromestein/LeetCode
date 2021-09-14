/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (getHours(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int getHours(int[] piles, int speed) {
        int res = 0;
        for (int p : piles) {
            // res+=Math.ceil(p*1./speed);
            res += (p - 1) / speed + 1;
        }

        return res;
    }
}
// @lc code=end
