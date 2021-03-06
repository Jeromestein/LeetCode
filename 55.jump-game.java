/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            // rightmost >= i means that i is reachable
            if (rightmost >= i) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

// @lc code=end
