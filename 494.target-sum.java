/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    int cnt;

    public int findTargetSumWays(int[] nums, int target) {
        cnt = 0;

        backtrack(nums, target, 0, 0);
        return cnt;
    }

    public void backtrack(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            if (sum == target)
                cnt++;
            return;
        }

        backtrack(nums, target, idx + 1, sum + nums[idx]);
        backtrack(nums, target, idx + 1, sum - nums[idx]);
    }
}
// @lc code=end
