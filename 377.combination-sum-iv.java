/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int currTarget = 1; currTarget <= target; currTarget++) {
            for (int num : nums) {
                if (num <= currTarget) {
                    dp[currTarget] += dp[currTarget - num];
                }
            }
        }

        return dp[target];
        // if the num could be negitive, then the combinations could be infinity long.
        // so there must be limitation about length.
    }
}

// @lc code=end
