/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        } else {
            int lo = 1, hi = x / 2;
            double mid = Integer.MAX_VALUE;
            while (lo < hi) {
                mid = lo + (hi - lo) / 2;
                if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                } else if (mid * mid > x) {
                    hi = (int) mid - 1;
                } else {
                    lo = (int) mid + 1;
                }

            }

            return lo;
        }
    }
}
// @lc code=end
