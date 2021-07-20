/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start

// class Solution {
//     int cnt;

//     public int findTargetSumWays(int[] nums, int target) {
//         cnt = 0;

//         backtrack(nums, target, 0, 0);
//         return cnt;
//     }

//     public void backtrack(int[] nums, int target, int idx, int sum) {
//         if (idx == nums.length) {
//             if (sum == target)
//                 cnt++;
//             return;
//         }

//         backtrack(nums, target, idx + 1, sum + nums[idx]);
//         backtrack(nums, target, idx + 1, sum - nums[idx]);
//     }
// }

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        // use scroll array to optimize the space of DP
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}

// @lc code=end
