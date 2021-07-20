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
        // 0 <= nums[i] <= 1000
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        // int n = nums.length, neg = diff / 2;
        // int[][] dp = new int[n + 1][neg + 1];
        // dp[0][0] = 1;
        // for (int i = 1; i <= n; i++) {
        // int num = nums[i - 1];
        // for (int j = 0; j <= neg; j++) {
        // dp[i][j] = dp[i - 1][j];
        // if (j >= num) {
        // dp[i][j] += dp[i - 1][j - num];
        // }
        // }
        // }
        // return dp[n][neg];

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
