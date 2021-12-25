/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start

/**
 * Explanation
 * Given the number of bags,
 * return the minimum capacity of each bag,
 * so that we can put items one by one into all bags.
 * 
 * We binary search the final result.
 * The left bound is max(A), The right bound is sum(A).
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (getNeed(weights, mid) > D)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int getNeed(int[] weights, int mid) {
        int need = 1, cur = 0;
        for (int w : weights) {
            if (cur + w > mid) {
                need += 1;
                cur = 0;
            }
            cur += w;
        }

        return need;
    }
}
// @lc code=end
