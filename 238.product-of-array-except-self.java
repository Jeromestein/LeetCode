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
        int[] prodLeft, prodRight, res;
        prodLeft = new int[nums.length];
        prodRight = new int[nums.length];
        res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prodLeft[i] = 1;
            } else {
                prodLeft[i] = nums[i - 1] * prodLeft[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                prodRight[i] = 1;
            } else {
                prodRight[i] = nums[i + 1] * prodRight[i + 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = prodLeft[i] * prodRight[i];
        }

        return res;
    }
}
// @lc code=end
