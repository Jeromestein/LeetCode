/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], maxSum = sum;
        int start = 0, end = 1;
        while (end < nums.length) {
            if (sum < 0) {
                if (nums[end] > sum) {
                    sum = nums[end];
                    start = end;
                }
            } else {
                sum += nums[end];
            }

            maxSum = Math.max(maxSum, sum);

            end++;
        }

        return maxSum;
    }
}
// @lc code=end
