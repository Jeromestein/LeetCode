/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int resLeft = -1, resRight = -1;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            // store the current shortest subarray
            if (sum >= target && minLen > right - left + 1) {
                minLen = right - left + 1;
                resLeft = left;
                resRight = right;
            }

            while (sum > target) {
                sum -= nums[left];
                left++;
                if (sum >= target && minLen > right - left + 1) {
                    minLen = right - left + 1;
                    resLeft = left;
                    resRight = right;
                }
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
// @lc code=end
