/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        } else {
            int left = 1, right = x / 2;
            while (left < right) {
                double mid = left + (right - left) / 2;
                if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                } else if (mid * mid > x) {
                    right = (int) mid - 1;
                } else {
                    left = (int) mid + 1;
                }
            }

            return left;
        }
    }
}
// @lc code=end
