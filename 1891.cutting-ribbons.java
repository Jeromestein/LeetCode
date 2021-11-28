/*
 * @lc app=leetcode id=1891 lang=java
 *
 * [1891] Cutting Ribbons
 */

// @lc code=start

class Solution {
    public int maxLength(int[] ribbons, int k) {
        int left = 1, right = (int) 1e5 + 1;
        // for (int r : ribbons) {
        // right = Math.max(r, right);
        // }
        // right++;
        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (!isCutPossible(ribbons, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public boolean isCutPossible(int[] ribbons, int length, int k) {
        int count = 0;
        for (int ribbon : ribbons) {
            count += (ribbon / length);
        }
        // I could've written an early 'return' here to save some computation, but for
        // me, the more "if", the more likely to bug
        return count >= k;
    }
}

// @lc code=end
