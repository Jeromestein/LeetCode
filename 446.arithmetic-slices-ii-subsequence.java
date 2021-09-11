import java.util.Map;

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
        Map<Long, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<Long, Integer>();
        }

        // i is the last one, j is the second last one
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = (long) nums[i] - nums[j];
                int cnt = dp[j].getOrDefault(d, 0);
                ans += cnt;
                // the second last one's cnt + the last one's cnt

                dp[i].put(d, dp[i].getOrDefault(d, 0) + cnt + 1);
            }
        }

        return ans;
    }
}
// @lc code=end
