/*
 * @lc app=leetcode id=446 lang=java
 *
 * [446] Arithmetic Slices II - Subsequence
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        /**
         * Given an integer array nums, return the number of all the arithmetic
         * subsequences of nums.
         * 
         * A subsequence of an array is a sequence that can be formed by removing some
         * elements (possibly none) of the array. (don't change relatively order)
         */

        // -2^31 <= nums[i] <= 2^31 - 1 long
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }

        return ans;
    }
}
// @lc code=end
