/*
 * @lc app=leetcode id=1770 lang=java
 *
 * [1770] Maximum Score from Performing Multiplication Operations
 */

// @lc code=start

// Iterative Dynamic Programming:
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[] dp = new int[m + 1];

        Arrays.fill(dp, 0);

        for (int op = m - 1; op >= 0; op--) {
            int[] nextDp = dp.clone();
            for (int left = op; left >= 0; left--) {
                // len(nums)=right-left+op+1
                int right = n - 1 - (op - left);
                dp[left] = Math.max(multipliers[op] * nums[left] + nextDp[left + 1],
                        multipliers[op] * nums[right] + nextDp[left]);
            }
        }

        return dp[0];
    }
}
// @lc code=end
