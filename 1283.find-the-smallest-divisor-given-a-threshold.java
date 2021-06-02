/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 */

// @lc code=start
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // 1 <= nums.length <= threshold <= 106
        int lo = 1, hi = 1000000;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = 0;
            for (float i : nums) {
                sum += Math.ceil(i / mid);
            }
            if (sum > threshold) {
                // need bigger divisor
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
// @lc code=end
