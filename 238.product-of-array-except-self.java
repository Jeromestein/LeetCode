/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // The product of any prefix or suffix of nums
        // is guaranteed to fit in a 32-bit integer.
        int[] res = new int[nums.length];

        // get the product of i left, prodLeft
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = 1;
            } else {
                res[i] = nums[i - 1] * res[i - 1];
            }
        }

        // get the oriduct of i right, prodRight
        // prodRight * prodLeft =
        // the product of all the elements of nums except nums[i]
        int prodRight = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                res[i] *= prodRight;
            } else {
                prodRight *= nums[i + 1];
                res[i] *= prodRight;
            }
        }
        // Can you solve the problem in O(1) extra space complexity?
        // (The output array does not count as extra space
        // for space complexity analysis.)

        return res;
    }
}
// @lc code=end
