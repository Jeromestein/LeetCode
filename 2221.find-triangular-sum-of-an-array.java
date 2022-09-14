/*
 * @lc app=leetcode id=2221 lang=java
 *
 * [2221] Find Triangular Sum of an Array
 */

// @lc code=start
class Solution {
    public int triangularSum(int[] nums) {
        for (int len = nums.length; len > 0; len--) {
            for (int i = 0; i < len - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }

        return nums[0];
    }
}
// @lc code=end
