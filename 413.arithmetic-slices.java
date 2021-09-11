/*
 * @lc app=leetcode id=413 lang=java
 *
 * [413] Arithmetic Slices
 */

// @lc code=start

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        /**
         * Given an integer array nums, return the number of arithmetic subarrays of
         * nums.
         * 
         * A subarray is a contiguous subsequence of the array.
         */

        if (nums.length < 3) {
            return 0;
        }

        // use dp[] to store the max contiguous arithmetic subarrays numbers at ith
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;

        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }

            // the sum of dp[] is the no. of subarrays
            res += dp[i];
        }

        return res;
    }
}
// @lc code=end
